package cn.demo.random.rbac;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import cn.demo.random.rbac.domain.RbacUser;
import cn.demo.random.rbac.mapper.UserMapper;

/**
 * Created by DaoSui on 2015/10/18.
 * Authenticate from database
 */
@Component
public class UserDetailService implements UserDetailsService{

    private static final Logger logger = LoggerFactory.getLogger(UserDetailService.class);

    @Autowired
    private UserMapper userRepository;

    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        logger.debug("Authenticating {}", login);
        String lowercaseLogin = login.trim().toLowerCase();
        Optional<RbacUser> userFromDatabase =  userRepository.findOneByUserName(lowercaseLogin);
        return userFromDatabase.map(user -> {
            if (!user.getActivated()) {
                throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
            }
            List<GrantedAuthority> grantedAuthorities = userRepository.listUserAuthoritis(user.getUserId()).stream()
                    .map(authority -> new SimpleGrantedAuthority(authority))
                    .collect(Collectors.toList());
            return new org.springframework.security.core.userdetails.User(lowercaseLogin,
                    user.getUserPwd(),
                    grantedAuthorities);
        }).orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));
    }
}
