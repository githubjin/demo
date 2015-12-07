package cn.demo.random.rbac;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import cn.demo.random.rbac.model.RolePermissionResources;
import cn.demo.random.rbac.repository.UserRepository;

/**
 * Created by DaoSui on 2015/10/30.
 */
@Component("urlFilterInvocationSecurityMetadataSource")
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserRepository userRepository;
    private final static List<ConfigAttribute> NULL_CONFIG_ATTRIBUTE = Collections.emptyList();
    private Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;


    @Override
    public void afterPropertiesSet() throws Exception {
        this.requestMap = this.bindRequestMap();
        logger.info("resources with role {}", this.requestMap);
    }

    /**
     *  refresh resources with role
     */
    public void refreshResourceMap() {
        this.requestMap = this.bindRequestMap();
        logger.info("refresh resouces with role {}", this.requestMap);
    }

    /**
     *
     * @return
     */
    protected Map<RequestMatcher, Collection<ConfigAttribute>> bindRequestMap() {
        Map<RequestMatcher, Collection<ConfigAttribute>> map =
                new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
        Optional<Map<String, String>> resMap = this.loadResource();
        if(resMap.isPresent()) {
            resMap.get().forEach((url, role) -> {
                Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                atts = SecurityConfig.createListFromCommaDelimitedString(role);
                map.put(new AntPathRequestMatcher(url), atts);
            });
        }
        return map;
    }

    /**
     * query all resources with role
     * @return
     */
    private Optional<Map<String, String>> loadResource() {
        Map<String, String> map = new LinkedHashMap<String, String>();
        Optional<List<RolePermissionResources>> rolePermissionResources = this.userRepository.listAllPermissionsBindedToRoles();
        if(rolePermissionResources.isPresent()) {
            rolePermissionResources.get().forEach(pr -> {
                if(map.containsKey(pr.getPsUrl())) {
                    String s = map.get(pr.getPsUrl());
                    map.put(pr.getPsUrl(), s + "," + pr.getRoleName());
                }else{
                    map.put(pr.getPsUrl(), pr.getRoleName());
                }
            });
        }
        return Optional.ofNullable(map);
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();

        Collection<ConfigAttribute> attrs = NULL_CONFIG_ATTRIBUTE;

        for(Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
            if(entry.getKey().matches(request)) {
                attrs = entry.getValue();
                break;
            }
        }
        logger.info("URI on resource {} -> {}", request.getRequestURI(), attrs);
        return attrs;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();

        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap
                .entrySet()) {
            allAttributes.addAll(entry.getValue());
        }

        return allAttributes;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
