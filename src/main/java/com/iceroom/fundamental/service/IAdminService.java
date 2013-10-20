package com.iceroom.fundamental.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iceroom.fundamental.entity.Category;
import com.iceroom.fundamental.entity.EmployerApplication;
import com.iceroom.fundamental.entity.PaginationWrapper;
import com.iceroom.fundamental.entity.Post;
import com.iceroom.fundamental.entity.User;
import com.iceroom.fundamental.viewmodel.CategoryViewModel;

/**
 * @author Lincoln
 *
 */
public interface IAdminService {
    
    /**
     * Get all Employer entities, in paginal format.
     * @param startIndex Pagination start index.
     * @param pageSize Count of records per page.
     * @return {@link PaginationWrapper}
     */
    PaginationWrapper getAllEmployers(int startIndex, int pageSize);
    
    /**
     * Get an User as an employer.
     * @param id The id of the User entity.
     * @return {@link User}
     */
    User getEmployer(long id);
    
    /**
     * Update an Employer entity with data submitted.
     * @param user The User entity (including an Employer entity).
     */
    void updateEmployer(User user);
    
    /**
     * Get all Candidate entities, in paginal format.
     * @param startIndex Pagination start index.
     * @param pageSize Count of records per page.
     * @return {@link PaginationWrapper}
     */
    PaginationWrapper getAllCandidates(int startIndex, int pageSize);
    
    /**
     * Get all categories as a tree.
     * @param root_id The id of the root category.
     * @return List&lt;{@link CategoryViewModel}&gt;
     */
    CategoryViewModel getCategoryAndChildren(long root_id);
    
    /**
     * Add a new Category entity.
     * @param category Submitted by the user, filled.
     */
    void addCategory(Category category);
    
    /**
     * Add a new Post.
     * @param post The Post entity.
     * @param miniPic The mini picture of the post.
     */
    void addPost(Post post, MultipartFile miniPic) throws Exception;
    
    /**
     * Update a Post entity.
     * @param post The entity.
     * @param miniPic The mini picture of the post.
     * @throws Exception
     */
    void updatePost(Post post, MultipartFile miniPic) throws Exception;
    
    /**
     * Get all Post entities, in paginal format.
     * @param startIndex Start index.
     * @param pageSize Count of records per-page.
     * @return {@link PaginationWrapper}
     */
    PaginationWrapper getAllPosts(int startIndex, int pageSize);
    
    /**
     * Get a particular Post entity by its id.
     * @param id The id of the Post entity.
     * @return {@link Post}
     */
    Post getPost(long id);
    
    /**
     * Delete a particular Post entity.
     * @param id The id of the entity.
     */
    void deletePost(long id);
    
    /**
     * Get all post pictures within /res/postPic
     * @return List&lt;{@link String}&gt;
     */
    List<String> getAllPostPics();
    
    /**
     * Save an uploaded post picture to /res/postPic
     * @param image The uploaded picture file.
     * @throws Exception
     */
    void savePostPic(MultipartFile image) throws Exception;
    
    /**
     * Get all employer applications.
     * @param startIndex The pagination start index.
     * @param pageSize The size of a single page.
     * @return {@link PaginationWrapper}
     */
    PaginationWrapper getAllApplications(int startIndex, int pageSize);
    
    /**
     * Get a particular employer application.
     * @param id The id of EmployerApplication
     * @return {@link EmployerApplication}
     */
    EmployerApplication getApplication(long id);
    
    /**
     * Get all feedbacks in paginal format.
     * @param startIndex The start index.
     * @param pageSize The page size.
     * @return {@link PaginationWrapper}
     */
    PaginationWrapper getAllFeedbacks(int startIndex, int pageSize);
    
}
