package cn.demo.random.rbac.domain;

import java.util.Date;

public class RbacMenu {
    private Long menuId;

    private String commonts;

    private Date createDate;

    private Long creator;

    private String isvalid;

    private String menuIcon;

    private String nemuName;

    private String menuUrl;

    private Long roleId;

    private Long upperMenu;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getCommonts() {
        return commonts;
    }

    public void setCommonts(String commonts) {
        this.commonts = commonts;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public String getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getNemuName() {
        return nemuName;
    }

    public void setNemuName(String nemuName) {
        this.nemuName = nemuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUpperMenu() {
        return upperMenu;
    }

    public void setUpperMenu(Long upperMenu) {
        this.upperMenu = upperMenu;
    }
}