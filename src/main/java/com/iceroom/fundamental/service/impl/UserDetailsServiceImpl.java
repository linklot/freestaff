/**
 * 
 */
package com.iceroom.fundamental.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.iceroom.fundamental.dao.IRoleDao;
import com.iceroom.fundamental.dao.IUserDao;
import com.iceroom.fundamental.entity.Role;
import com.iceroom.fundamental.entity.User;
import com.iceroom.fundamental.entity.UserDetailsImpl;

/**
 * @author Lincoln
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private IUserDao userDao;
    private IRoleDao roleDao;
    private UserDetailsImpl userDetails;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String account)
            throws UsernameNotFoundException {
        
        /* Get User instance according to its account */
        String hql = "from User u where u.account=?1";
        User user = userDao.findSingleByHql(hql, account);
        if((user == null))
            throw new UsernameNotFoundException("User " + account + " does not exist!");
        
        // Get Role list of the user
        hql = "select u.roles from User u where u.account=?1";
        List<Role> roles = roleDao.findByHql(hql, account);
        
        /* Fill up an UserDetails instance */
        userDetails = new UserDetailsImpl();
        userDetails.setUsername(user.getAccount());
        userDetails.setPassword(user.getPassword());
        userDetails.setEnabled(user.isEnabled());
        userDetails.setAccountNonExpired(true);
        userDetails.setAccountNonLocked(true);
        userDetails.setCredentialsNonExpired(true);
        
        /* Fill up the user's authorities */
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        userDetails.setAuthorities(authorities);
        
        return userDetails;
    }

    /**
     * @param userDao the userDao to set
     */
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * @param roleDao the roleDao to set
     */
    public void setRoleDao(IRoleDao roleDao) {
        this.roleDao = roleDao;
    }

}
