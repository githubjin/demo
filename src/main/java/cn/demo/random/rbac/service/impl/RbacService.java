package cn.demo.random.rbac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.demo.random.rbac.domain.RbacUser;
import cn.demo.random.rbac.mapper.RbacPermissionMapper;
import cn.demo.random.rbac.mapper.RbacUserMapper;
import cn.demo.random.rbac.mapper.RbacUserRoleMapper;
import cn.demo.random.rbac.model.RolePermissionResources;
import cn.demo.random.rbac.service.IRbacService;

@Service
@Transactional(readOnly = true)
public class RbacService implements IRbacService {

	@Autowired
	private RbacUserMapper rbacUserMapper;
	
	@Autowired
	private RbacUserRoleMapper rbacUserRoleMapper;
	
	@Autowired
    private RbacPermissionMapper rbacPermissionMapper;

	@Override
	@Cacheable(value = "rbacuser", key = "#userName")
	public RbacUser findOneByUserName(String userName) {
		return rbacUserMapper.findOneByUserName(userName);
	}

	@Override
	@Cacheable(value = "userauthoritis", key = "#userId")
	public List<String> listUserAuthoritis(Long userId) {
		return rbacUserRoleMapper.listUserAuthoritis(userId);
	}

	@Override
	@Cacheable(value = "rolePermissionResources", key = "#root.methodName")
	public List<RolePermissionResources> listAllPermissionsBindedToRoles() {
		return rbacPermissionMapper.listAllPermissionsBindedToRoles();
	} 
	
}
