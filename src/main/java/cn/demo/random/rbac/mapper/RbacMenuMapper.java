package cn.demo.random.rbac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.demo.random.rbac.domain.RbacMenu;
import cn.demo.random.rbac.domain.RbacMenuExample;

@Repository
public interface RbacMenuMapper {
    int countByExample(RbacMenuExample example);

    int deleteByExample(RbacMenuExample example);

    int deleteByPrimaryKey(Long menuId);

    int insert(RbacMenu record);

    int insertSelective(RbacMenu record);

    List<RbacMenu> selectByExample(RbacMenuExample example);

    RbacMenu selectByPrimaryKey(Long menuId);

    int updateByExampleSelective(@Param("record") RbacMenu record, @Param("example") RbacMenuExample example);

    int updateByExample(@Param("record") RbacMenu record, @Param("example") RbacMenuExample example);

    int updateByPrimaryKeySelective(RbacMenu record);

    int updateByPrimaryKey(RbacMenu record);
}