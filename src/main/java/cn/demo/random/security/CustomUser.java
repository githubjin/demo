package cn.demo.random.security;

import java.util.Collection;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import cn.demo.random.rbac.domain.RbacUser;

public class CustomUser extends User {

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String langKey;
	private String userName;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	public RbacUser getRbacUser() {
		RbacUser user = new RbacUser();
		BeanUtils.copyProperties(this, user);
		return user;
	}
	
	public String getEmail() {
		return email;
	}

	public CustomUser setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getLangKey() {
		return langKey;
	}

	public CustomUser setLangKey(String languageKey) {
		this.langKey = languageKey;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public CustomUser setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	
}
