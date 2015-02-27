/**
 * <p>Copyright (c) 2014 ZhaoQian.All Rights Reserved.</p>
 * @author <a href="zhaoqianjava@foxmail.com">ZhaoQian</a>
 */
package org.zhaoqian.security.shiro.authc;

import java.util.UUID;

import org.apache.shiro.crypto.hash.Sha512Hash;
import org.zhaoqian.security.model.User;

/**
 *
 * @author ZhaoQian
 * @date: 2014年8月10日
 */
public class PasswordHelper
{
	public static User generatePassword(User user){
		byte[] passwordSalt = UUID.randomUUID().toString().getBytes();
		user.setPasswordSalt(passwordSalt);
		String passwordHash = new Sha512Hash(user.getPassword(), user.getName() + new String(passwordSalt), 99).toString();
		user.setPasswordHash(passwordHash);
		return user;
	}
}
