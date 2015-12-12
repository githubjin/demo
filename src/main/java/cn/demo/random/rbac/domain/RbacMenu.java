package cn.demo.random.rbac.domain;


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
@Table(name = "rbac_menu")
public class RbacMenu extends BaseEntityClass{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;
    @Column(name = "nemu_name", length = 30)
    private String menuName;
    @Column(name = "menu_icon", length = 100)
    private String menuIcon;
    @Column(name = "menu_url", length = 100)
    private String menuUrl;
    @Column(name = "upper_menu")
    private Long upperNemu = 0l;
    @Column(name = "role_id")
    private Long roleId;

    public RbacMenu() {

    }

    public RbacMenu(Date createDate, Long creator, String isValid, String commonts, String menuName, String menuIcon, String menuUrl, Long upperNemu) {
        super(createDate, creator, isValid, commonts);
        this.menuName = menuName;
        this.menuIcon = menuIcon;
        this.menuUrl = menuUrl;
        this.upperNemu = upperNemu;
    }

    public Long getMenuId() {
        return menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public Long getUpperNemu() {
        return upperNemu;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public void setUpperNemu(Long upperNemu) {
        this.upperNemu = upperNemu;
    }
}