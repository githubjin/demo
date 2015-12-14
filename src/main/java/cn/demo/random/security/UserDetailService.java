package cn.demo.random.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import cn.demo.random.rbac.UserNotActivatedException;
import cn.demo.random.rbac.domain.RbacUser;
import cn.demo.random.rbac.mapper.RbacUserMapper;
import cn.demo.random.rbac.mapper.RbacUserRoleMapper;

/**
 * Created by DaoSui on 2015/10/18.
 * Authenticate from database
 */
@Component
public class UserDetailService implements UserDetailsService{

    private static final Logger logger = LoggerFactory.getLogger(UserDetailService.class);

    @Autowired
    private RbacUserMapper rbacUserMapper;
    @Autowired
    private RbacUserRoleMapper rbacUserRoleMapper;
    
    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        logger.debug("Authenticating {}", login);
        String lowercaseLogin = login.trim();
        RbacUser user = rbacUserMapper.findOneByUserName(lowercaseLogin);
        if(user != null){
        	if (!user.getActivated()) {
                throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
            }
        	List<String> list = rbacUserRoleMapper.listUserAuthoritis(user.getUserId());
        	List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        	for(String authority : list){
        		grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        	}
            /*List<GrantedAuthority> grantedAuthorities = rbacUserRoleMapper.listUserAuthoritis(user.getUserId()).stream()
                    .map(authority -> new SimpleGrantedAuthority(authority))
                    .collect(Collectors.toList());*/
            return new org.springframework.security.core.userdetails.User(lowercaseLogin, user.getUserPwd(),grantedAuthorities);
            
        }else{
        	throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database");
        }
    }
}
