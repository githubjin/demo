package cn.demo.random.rbac.entity;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by DaoSui on 2015/10/17.
 */
@Entity
@Table(name = "rbac_role")
public class RbacRole extends BaseEntityClass{

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @Column(name = "role_name", length = 30)
    private String roleName;
    @Column(name = "role_description", length = 100)
    private String roleDescription;
    @Column(name = "main_page", length = 100)
    private String mainPage;
    @Column(name = "upper_role_id")
    private Long upperRoleId;

    public RbacRole() {
    }

    public RbacRole(Date createDate, Long creator, String isValid, String commonts, String roleName, String roleDescription, String mainPage, Long upperRoleId) {
        super(createDate, creator, isValid, commonts);
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.mainPage = mainPage;
        this.upperRoleId = upperRoleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public void setMainPage(String mainPage) {
        this.mainPage = mainPage;
    }

    public void setUpperRoleId(Long upperRoleId) {
        this.upperRoleId = upperRoleId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public String getMainPage() {
        return mainPage;
    }

    public Long getUpperRoleId() {
        return upperRoleId;
    }
}
