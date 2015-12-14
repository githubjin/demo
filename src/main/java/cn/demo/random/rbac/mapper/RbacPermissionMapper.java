package cn.demo.random.rbac.mapper;

import cn.demo.random.annotations.Mapper;
import cn.demo.random.rbac.domain.RbacPermission;
import cn.demo.random.rbac.domain.RbacPermissionExample;
import cn.demo.random.rbac.model.RolePermissionResources;

import java.util.List;
import org.apache.ibatis.annotations.Param;
@Mapper
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
    
    /* ------------------------------- 自定义查询 ------------------------------------*/
    /**
     * 查询所有角色和权限关联关系
     * @return
     */
    List<RolePermissionResources> listAllPermissionsBindedToRoles();
}