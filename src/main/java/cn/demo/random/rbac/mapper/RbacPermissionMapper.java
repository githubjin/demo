package cn.demo.random.rbac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.demo.random.rbac.domain.RbacPermission;
import cn.demo.random.rbac.domain.RbacPermissionExample;
import cn.demo.random.rbac.model.RolePermissionResources;
@Repository
public interface RbacPermissionMapper {
    int countByExample(RbacPermissionExample example);

    int deleteByExample(RbacPermissionExample example);

    int deleteByPrimaryKey(Long psId);

    int insert(RbacPermission record);

    int insertSelective(RbacPermission record);

    List<RbacPermission> selectByExample(RbacPermissionExample example);

    RbacPermission selectByPrimaryKey(Long psId);

    int updateByExampleSelective(@Param("record") RbacPermission record, @Param("example") RbacPermissionExample example);

    int updateByExample(@Param("record") RbacPermission record, @Param("example") RbacPermissionExample example);

    int updateByPrimaryKeySelective(RbacPermission record);

    int updateByPrimaryKey(RbacPermission record);
    
	/**
     * 查询所有角色和权限关联关系
     * @return
     */
    List<RolePermissionResources> listAllPermissionsBindedToRoles();
    
}