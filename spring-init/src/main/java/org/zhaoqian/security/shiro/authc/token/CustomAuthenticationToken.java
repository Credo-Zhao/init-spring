package org.zhaoqian.security.shiro.authc.token;

import org.apache.shiro.authc.UsernamePasswordToken;

public class CustomAuthenticationToken extends UsernamePasswordToken {

	private static final long serialVersionUID = -968753661299866537L;

	private String extraId;

	public CustomAuthenticationToken(final String extraId, final String username, final String password, final boolean rememberMe, final String host) {

		super(username, password, rememberMe, host);
		this.extraId = extraId;
	}

	public CustomAuthenticationToken(final String extraId, final String username, final String password, final boolean rememberMe) {

		super(username, password, rememberMe);
		this.extraId = extraId;
	}

	public CustomAuthenticationToken(final String extraId, final String username, final String password) {

		super(username, password);
		this.extraId = extraId;
	}

	public String getextraId() {

		return extraId;
	}

	public void setextraId(String extraId) {

		this.extraId = extraId;
	}
}
