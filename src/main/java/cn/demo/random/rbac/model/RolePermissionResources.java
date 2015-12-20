package cn.demo.random.rbac.model;

import java.io.Serializable;

/**
 * Created by DaoSui on 2015/10/18.
 */
public class RolePermissionResources implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private String roleName;
    private String psUrl;
    private String psType;


    public RolePermissionResources() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RolePermissionResources(String roleName, String psUrl, String psType) {
		super();
		this.roleName = roleName;
		this.psUrl = psUrl;
		this.psType = psType;
	}

	public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPsUrl() {
        return psUrl;
    }

    public void setPsUrl(String psUrl) {
        this.psUrl = psUrl;
    }

    public String getPsType() {
        return psType;
    }

    public void setPsType(String psType) {
        this.psType = psType;
    }
}
