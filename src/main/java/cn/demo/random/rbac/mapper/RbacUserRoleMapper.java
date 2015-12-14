package cn.demo.random.rbac.mapper;

import cn.demo.random.annotations.Mapper;
import cn.demo.random.rbac.domain.RbacUserRole;
import cn.demo.random.rbac.domain.RbacUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RbacUserRoleMapper {
    int countByExample(RbacUserRoleExample example);

    int deleteByExample(RbacUserRoleExample example);

    int deleteByPrimaryKey(Long rid);

    int insert(RbacUserRole record);

    int insertSelective(RbacUserRole record);

    List<RbacUserRole> selectByExample(RbacUserRoleExample example);

    RbacUserRole selectByPrimaryKey(Long rid);

    int updateByExampleSelective(@Param("record") RbacUserRole record, @Param("example") RbacUserRoleExample example);

    int updateByExample(@Param("record") RbacUserRole record, @Param("example") RbacUserRoleExample example);

    int updateByPrimaryKeySelective(RbacUserRole record);

    int updateByPrimaryKey(RbacUserRole record);
    
    /* --------------------------- 自定义查询 -----------------------------*/
    /**
     * 查询用户角色
     * @param userId
     * @return
     */
    public List<String> listUserAuthoritis(Long userId);
} 