package cn.demo.random.rbac.domain;

import java.util.Date;

public class RbacPermission {
    private Long psId;

    private String commonts;

    private Date createDate;

    private Long creator;

    private String isvalid;

    private String psDescription;

    private String psGroup;

    private String psName;

    private String psType;

    private String psUrl;

    private Long roleId;

    public Long getPsId() {
        return psId;
    }

    public void setPsId(Long psId) {
        this.psId = psId;
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

    public String getPsDescription() {
        return psDescription;
    }

    public void setPsDescription(String psDescription) {
        this.psDescription = psDescription;
    }

    public String getPsGroup() {
        return psGroup;
    }

    public void setPsGroup(String psGroup) {
        this.psGroup = psGroup;
    }

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }

    public String getPsType() {
        return psType;
    }

    public void setPsType(String psType) {
        this.psType = psType;
    }

    public String getPsUrl() {
        return psUrl;
    }

    public void setPsUrl(String psUrl) {
        this.psUrl = psUrl;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}