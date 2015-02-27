/**
 * <p>Copyright (c) 2014 ZhaoQian.All Rights Reserved.</p>
 * @author <a href="zhaoqianjava@foxmail.com">ZhaoQian</a>
 */
package org.zhaoqian.security.shiro.authc.credential;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

/**
 * 验证密码服务,可以提供密码错误登录次数的限制
 * 
 * @author ZhaoQian
 * @date: 2014年8月2日
 */
public class CustomCredentialsMatcher  extends HashedCredentialsMatcher 
{

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info)
	{
		boolean result=super.doCredentialsMatch(token, info);
		System.out.println("String result:"+result);
		return result;
	}

}
