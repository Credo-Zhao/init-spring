/**
 * <p>Copyright (c) 2014 ZhaoQian.All Rights Reserved.</p>
 * @author <a href="zhaoqianjava@foxmail.com">ZhaoQian</a>
 */
package org.credo.security.controller;

import org.credo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ZhaoQian
 * @date: 2014年8月13日
 */
@Controller
@RequestMapping("/user")
public class UserBean
{
	private static final Logger log = LoggerFactory.getLogger(LoginBean.class);
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/list")
	public void list(){
		
	}
}
