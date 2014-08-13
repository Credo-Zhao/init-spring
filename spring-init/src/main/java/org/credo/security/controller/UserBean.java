/**
 * <p>Copyright (c) 2014 ZhaoQian.All Rights Reserved.</p>
 * @author <a href="zhaoqianjava@foxmail.com">ZhaoQian</a>
 */
package org.credo.security.controller;

import org.credo.repository.UserRepository;
import org.credo.security.model.User;
import org.credo.security.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ZhaoQian
 * @date: 2014年8月13日
 */
@Controller
@RequestMapping("/user")
public class UserBean
{
	private static final Logger log = LoggerFactory.getLogger(UserBean.class);

	private static final int DEFAULT_PAGE_NUM = 0;
	private static final int DEFAULT_PAGE_SIZE = 10;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) Integer page, Model model)
	{
		int pageNumber = page != null ? page : DEFAULT_PAGE_NUM;
		Page<User> pagingPerson = userService.findAllForPagination(pageNumber, DEFAULT_PAGE_SIZE);
		model.addAttribute("pagingPerson", pagingPerson);
		return "/user/list";
	}

	public void create()
	{

	}

	public void edit()
	{

	}

	public void delete()
	{

	}

}
