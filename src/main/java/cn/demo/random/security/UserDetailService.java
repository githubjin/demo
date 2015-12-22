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
import cn.demo.random.rbac.service.IRbacService;

/**
 * Created by DaoSui on 2015/10/18.
 * Authenticate from database
 */
@Component
public class UserDetailService implements UserDetailsService{

    private static final Logger logger = LoggerFactory.getLogger(UserDetailService.class);

    @Autowired
    private IRbacService rbacService;
    
    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        logger.debug("Authenticating {}", login);
        String lowercaseLogin = login.trim();
        RbacUser user = rbacService.findOneByUserName(lowercaseLogin);
        if(user != null){
        	if (!user.getActivated()) {
                throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
            }
        	List<String> list = rbacService.listUserAuthoritis(user.getUserId());
        	List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        	for(String authority : list){
        		grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        	}
            /*List<GrantedAuthority> grantedAuthorities = rbacUserRoleMapper.listUserAuthoritis(user.getUserId()).stream()
                    .map(authority -> new SimpleGrantedAuthority(authority))
                    .collect(Collectors.toList());*/
        	CustomUser principal = new CustomUser(lowercaseLogin, user.getUserPwd(),grantedAuthorities);
        	principal.setEmail(user.getEmail()).setLangKey(user.getLangKey()).setUserName(user.getUserName());
            return principal;
            
        }else{
        	throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database");
        }
    }
}
