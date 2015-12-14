package cn.demo.random.rbac.mapper;

import cn.demo.random.annotations.Mapper;
import cn.demo.random.rbac.domain.RbacRole;
import cn.demo.random.rbac.domain.RbacRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@Mapper
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