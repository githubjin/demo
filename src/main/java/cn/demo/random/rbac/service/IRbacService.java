package cn.demo.random.rbac.service;

import java.util.List;

import cn.demo.random.rbac.domain.RbacUser;
import cn.demo.random.rbac.model.RolePermissionResources;

public interface IRbacService {

	/**
	 * 更具用户名查询用户信息
	 * @param userName
	 * @return
	 */
	RbacUser findOneByUserName(String userName);
	
    /**
     * 查询用户角色
     * @param userId
     * @return
     */
    public List<String> listUserAuthoritis(Long userId);
    
	/**
     * 查询所有角色和权限关联关系
     * @return
     */
    List<RolePermissionResources> listAllPermissionsBindedToRoles();
	
}
