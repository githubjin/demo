package cn.demo.random.rbac.mapper;

import cn.demo.random.annotations.Mapper;
import cn.demo.random.rbac.domain.RbacUser;
import cn.demo.random.rbac.domain.RbacUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RbacUserMapper {
    int countByExample(RbacUserExample example);

    int deleteByExample(RbacUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(RbacUser record);

    int insertSelective(RbacUser record);

    List<RbacUser> selectByExample(RbacUserExample example);

    RbacUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") RbacUser record, @Param("example") RbacUserExample example);

    int updateByExample(@Param("record") RbacUser record, @Param("example") RbacUserExample example);

    int updateByPrimaryKeySelective(RbacUser record);

    int updateByPrimaryKey(RbacUser record);
    
    /* ------------------------- 自定义操作 -------------------------------- */
    RbacUser findOneByUserName(String userName);
}