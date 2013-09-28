/**
 * 
 */
package com.iceroom.fundamental.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iceroom.fundamental.dao.ICategoryDao;
import com.iceroom.fundamental.dao.IEmployerDao;
import com.iceroom.fundamental.dao.IPostDao;
import com.iceroom.fundamental.dao.IUserDao;
import com.iceroom.fundamental.entity.Category;
import com.iceroom.fundamental.entity.Employer;
import com.iceroom.fundamental.entity.PaginationWrapper;
import com.iceroom.fundamental.entity.Post;
import com.iceroom.fundamental.entity.User;
import com.iceroom.fundamental.service.IAdminService;
import com.iceroom.fundamental.util.StringComparable;
import com.iceroom.fundamental.util.StringUtil;
import com.iceroom.fundamental.viewmodel.CategoryViewModel;

/**
 * @author Lincoln
 *
 */
public class AdminService implements IAdminService {
    
    private IUserDao userDao;
    private IEmployerDao employerDao;
    private ICategoryDao categoryDao;
    private IPostDao postDao;
    private String miniPicPath;
    private String postPicPath;
    private final String MINIPIC_URL_PATH = "/res/miniPic/";
    private final String POSTPIC_URL_PATH = "/res/postPic/";
    
    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAdminService#getAllEmployers()
     */
    @Override
    @Transactional(readOnly=true)
    public PaginationWrapper getAllEmployers(int startIndex, int pageSize) {
        String hql = "from User user where user.employer.id is not null order by user.id";
        return userDao.paginatedFind(startIndex, pageSize, hql, true);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAdminService#getEmployer(long)
     */
    @Override
    @Transactional(readOnly=true)
    public User getEmployer(long id) {
        User user = userDao.getEntityById(id);
        user.getEmployer().getId();
        return user;
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAdminService#updateEmployer(com.iceroom.fundamental.entity.User)
     */
    @Override
    @Transactional
    public void updateEmployer(User user) {
        Employer emp = user.getEmployer();
        User _user = userDao.getEntityById(user.getId());
        Employer _emp = _user.getEmployer();
        _emp.setName(emp.getName());
        _emp.setPhone(emp.getPhone());
        _emp.setEmail(emp.getEmail());
        _emp.setAddrStreet(emp.getAddrStreet());
        _emp.setAddrCity(emp.getAddrCity());
        _emp.setAddrState(emp.getAddrState());
        _emp.setAddrCountry(emp.getAddrCountry());
        _emp.setZip(emp.getZip());
        _emp.setStatement(emp.getStatement());
        employerDao.update(_emp);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAdminService#getAllCandidates(int, int)
     */
    @Override
    @Transactional(readOnly=true)
    public PaginationWrapper getAllCandidates(int startIndex, int pageSize) {
        String hql = "from User user where user.candidate.id is not null order by user.id";
        return userDao.paginatedFind(startIndex, pageSize, hql, true);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAdminService#getCategoryAndChildren(long)
     */
    @Override
    @Transactional(readOnly=true)
    public CategoryViewModel getCategoryAndChildren(long root_id) {
        String hql = "from Category cate where cate.id=?1";
        Category root = categoryDao.findSingleByHql(hql, root_id);
        CategoryViewModel viewModel = new CategoryViewModel();
        viewModel.setId(root.getId());
        viewModel.setName(root.getName());
        viewModel.setOrder(root.getSequence());
        
        hql = "from Category cate where cate.parent.id=?1 order by cate.sequence, cate.name";
        List<Category> children = categoryDao.findByHql(hql, root_id);
        if(children != null) {
            if(children.size() > 0) {
                List<CategoryViewModel> list = new ArrayList<CategoryViewModel>();
                for(Category child : children) {
                    list.add(getCategoryAndChildren(child.getId()));
                }
                viewModel.setChildren(list);
            }
        }
        return viewModel;
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAdminService#addCategory(com.iceroom.fundamental.entity.Category)
     */
    @Override
    @Transactional
    public void addCategory(Category category) {
        Category parent = categoryDao.getEntityById(category.getParent().getId());
        category.setParent(parent);
        categoryDao.create(category);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAdminService#addPost(com.iceroom.fundamental.entity.Post, org.springframework.web.multipart.MultipartFile)
     */
    @Override
    @Transactional
    public void addPost(Post post, MultipartFile miniPic) throws Exception {
        /* 1, get the Category it belongs to. */
        Category category = categoryDao.getEntityById(post.getCategory().getId());
        
        /* 2, save the Post entity. */
        Post newPost = new Post();
        newPost.setCategory(category);
        newPost.setTitle(post.getTitle());
        newPost.setMiniPicUrl("");
        newPost.setSummary(post.getSummary());
        newPost.setSequence(post.getSequence());
        newPost.setPubTime(Calendar.getInstance());
        newPost.setContent(post.getContent());
        newPost.setHits(0);
        long id = ((Long)postDao.create(newPost)).longValue();// Get the id of the new entity.
        
        if(miniPic.getSize() > 0) {
            /* 2.1, save the mini picture file if uploaded. */
            String extName = StringUtil.getExtName(miniPic.getOriginalFilename());
            String fileName = id + "." + extName;
            File file = new File(miniPicPath + fileName);
            FileUtils.writeByteArrayToFile(file, miniPic.getBytes());
            
            /* 2.2, update the post entity if mini picture is uploaded. */
            newPost = postDao.getEntityById(id);
            newPost.setMiniPicUrl(MINIPIC_URL_PATH + fileName);
            postDao.update(newPost);
        }
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAdminService#updatePost(com.iceroom.fundamental.entity.Post, org.springframework.web.multipart.MultipartFile)
     */
    @Override
    @Transactional
    public void updatePost(Post post, MultipartFile miniPic) throws Exception {
        /* 1, get the Category it belongs to. */
        Category category = categoryDao.getEntityById(post.getCategory().getId());
        
        /* 2, save the Post entity. */
        Post newPost = postDao.getEntityById(post.getId());
        newPost.setCategory(category);
        newPost.setTitle(post.getTitle());
        newPost.setSummary(post.getSummary());
        newPost.setSequence(post.getSequence());
        newPost.setContent(post.getContent());
        postDao.update(newPost);
        
        if(miniPic.getSize() > 0) {
            /* 2.1, save the mini picture file if uploaded. */
            String extName = StringUtil.getExtName(miniPic.getOriginalFilename());
            String fileName = newPost.getId() + "." + extName;
            File file = new File(miniPicPath + fileName);
            FileUtils.writeByteArrayToFile(file, miniPic.getBytes());
            
            /* 2.2, update the post entity if mini picture is uploaded. */
            newPost = postDao.getEntityById(newPost.getId());
            newPost.setMiniPicUrl(MINIPIC_URL_PATH + fileName);
            postDao.update(newPost);
        }
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAdminService#getAllPosts(int, int)
     */
    @Override
    @Transactional(readOnly=true)
    public PaginationWrapper getAllPosts(int startIndex, int pageSize) {
        String hql = "from Post post order by post.id";
        return postDao.paginatedFind(startIndex, pageSize, hql, true);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAdminService#getPost(long)
     */
    @Override
    @Transactional(readOnly=true)
    public Post getPost(long id) {
        Post post = postDao.getEntityById(id);
        post.getCategory().getId();
        return post;
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAdminService#deletePost(long)
     */
    @Override
    @Transactional
    public void deletePost(long id) {
        Post post = postDao.getEntityById(id);
        postDao.delete(post);
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAdminService#getAllPostPics()
     */
    @Override
    public List<String> getAllPostPics() {
        List<String> fileNames = new ArrayList<String>();
        File folder = new File(postPicPath);
        for(File file : folder.listFiles()) {
            String fileName = file.getName();
            fileNames.add(POSTPIC_URL_PATH + fileName);
        }
        Collections.sort(fileNames, new StringComparable());
        return fileNames;
    }

    /* (non-Javadoc)
     * @see com.iceroom.fundamental.service.IAdminService#savePostPic(org.springframework.web.multipart.MultipartFile)
     */
    @Override
    public void savePostPic(MultipartFile image) throws Exception {
        String filename = StringUtil.getCurrentTimeString();
        String extension = StringUtil.getExtName(image.getOriginalFilename());
        File file = new File(postPicPath + filename + "." + extension);
        FileUtils.writeByteArrayToFile(file, image.getBytes());
    }

    /**
     * @param userDao the userDao to set
     */
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * @param employerDao the employerDao to set
     */
    public void setEmployerDao(IEmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    /**
     * @param categoryDao the categoryDao to set
     */
    public void setCategoryDao(ICategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    /**
     * @param postDao the postDao to set
     */
    public void setPostDao(IPostDao postDao) {
        this.postDao = postDao;
    }

    /**
     * @param miniPicPath the miniPicPath to set
     */
    public void setMiniPicPath(String miniPicPath) {
        this.miniPicPath = miniPicPath;
    }

    /**
     * @param postPicPath the postPicPath to set
     */
    public void setPostPicPath(String postPicPath) {
        this.postPicPath = postPicPath;
    }
    
}
