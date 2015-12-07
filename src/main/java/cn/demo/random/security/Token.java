package cn.demo.random.security;

import java.util.List;

/**
 * The security token.
 */
public class Token {

    String iss;
    long exp;
    String userId;
    List<String> roles;
    
	public Token(String iss, long exp, String userId, List<String> roles) {
		super();
		this.iss = iss;
		this.exp = exp;
		this.userId = userId;
		this.roles = roles;
	}

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public long getExp() {
		return exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
    
    

}
