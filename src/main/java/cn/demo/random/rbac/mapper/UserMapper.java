package cn.demo.random.rbac.mapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import cn.demo.random.annotations.Mapper;
import cn.demo.random.rbac.domain.RbacUser;

@Mapper
public interface UserMapper {

    Optional<RbacUser> findOneByUserName(String userName);

    @Query(nativeQuery = true, value = "SELECT role_name FROM rbac_user_role ur,rbac_role r WHERE ur.user_id=:userId AND ur.role_id=r.role_id")
    List<String> listUserAuthoritis(@Param("userId") Long userId);

    @Query(value = "SELECT r.role_name as roleName,p.ps_url as psUrl,p.ps_type as psType FROM rbac_permission p,rbac_role r WHERE p.role_id=r.role_id", nativeQuery = true)
    List<Map<String, Object>> listAllPermissionsBindedToRoles();

}
