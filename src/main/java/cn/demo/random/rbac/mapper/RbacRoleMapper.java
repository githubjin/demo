package cn.demo.random.rbac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.demo.random.rbac.domain.RbacRole;
import cn.demo.random.rbac.domain.RbacRoleExample;

@Repository
public interface RbacRoleMapper {
    int countByExample(RbacRoleExample example);

    int deleteByExample(RbacRoleExample example);

    int deleteByPrimaryKey(Long roleId);

    int insert(RbacRole record);

    int insertSelective(RbacRole record);

    List<RbacRole> selectByExample(RbacRoleExample example);

    RbacRole selectByPrimaryKey(Long roleId);

    int updateByExampleSelective(@Param("record") RbacRole record, @Param("example") RbacRoleExample example);

    int updateByExample(@Param("record") RbacRole record, @Param("example") RbacRoleExample example);

    int updateByPrimaryKeySelective(RbacRole record);

    int updateByPrimaryKey(RbacRole record);
}