/**
 * <p>Copyright (c) 2014 ZhaoQian.All Rights Reserved.</p>
 * @author <a href="zhaoqianjava@foxmail.com">ZhaoQian</a>
 */
package org.zhaoqian.security.shiro.realm;

import java.io.Serializable;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.zhaoqian.security.controller.LoginBean;
import org.zhaoqian.security.model.Role;
import org.zhaoqian.security.model.User;
import org.zhaoqian.security.shiro.support.JpaRealmRepository;

/**
 * @author ZhaoQian
 * @date: 2014年7月30日
 */
public class JpaRealm extends AuthorizingRealm implements Serializable
{
	private static final long serialVersionUID = -1392013496182744585L;

	private static final Logger log = LoggerFactory.getLogger(LoginBean.class);

	@Autowired
	JpaRealmRepository jpaRealmRepository;

	/*
	 * 授权信息处理
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
	{
		String username = principals.getPrimaryPrincipal().toString();
		User user = this.jpaRealmRepository.findUserByName(username);

		if (null != user)
		{
			SimpleAuthorizationInfo authorization = new SimpleAuthorizationInfo();
			for (Role role : user.getRoles())
			{
				authorization.addStringPermissions(role.getPermissions());
			}
			return authorization;
		}

		return null;
	}

	/*
	 * 认证信息处理
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
	{
		String username = token.getPrincipal().toString();
		User user = this.jpaRealmRepository.findUserByName(username);

		if (null == user)
		{
			log.error("没有相关用户!");
			throw new UnknownAccountException();
		}

		String principal = username;
		String hashedCredentials = user.getPasswordHash();
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getName() + new String(user.getPasswordSalt()));
		String realmName = getName();

		SimpleAuthenticationInfo authentication = new SimpleAuthenticationInfo(principal, hashedCredentials, credentialsSalt, realmName);
		return authentication;
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals)
	{
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals)
	{
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals)
	{
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo()
	{
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo()
	{
		getAuthenticationCache().clear();
	}

	public void clearAllCache()
	{
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}
