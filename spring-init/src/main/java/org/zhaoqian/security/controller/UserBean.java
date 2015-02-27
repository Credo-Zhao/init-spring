/**
 * <p>Copyright (c) 2014 ZhaoQian.All Rights Reserved.</p>
 * @author <a href="zhaoqianjava@foxmail.com">ZhaoQian</a>
 */
package org.zhaoqian.security.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.zhaoqian.repository.UserRepository;
import org.zhaoqian.security.model.User;
import org.zhaoqian.security.service.UserService;
import org.zhaoqian.security.shiro.authc.PasswordHelper;

import com.alibaba.fastjson.JSON;

/**
 * @author ZhaoQian
 * @date: 2014年8月13日
 */
@Controller
@RequestMapping("/security/user")
public class UserBean
{
	private static final Logger log = LoggerFactory.getLogger(UserBean.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "message", required = false) String 
			message, Model model)
	{
		int pageNumber = page != null ? page : 0;
		Page<User> pageUser = userService.findAllForPagination(pageNumber, 10);
		model.addAttribute("pageUser", pageUser);
		if (message!=null)
		{
			model.addAttribute("message", message);
		}
		return "/security/user/list";
	}

	@RequestMapping("/create")
	public ModelAndView create(User user) throws UnsupportedEncodingException
	{
		user = PasswordHelper.generatePassword(user);
		userRepository.save(user);
		Map<String,String> map = new HashMap<>();
		String message = "用户 " + user.getName() + " 创建成功!";
		map.put("message", message);
		return new ModelAndView(new RedirectView("list"), map);
	}

	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String edit(@PathVariable("id") String id)
	{
		User user = this.userRepository.findOne(Long.parseLong(id));
		String json=JSON.toJSONString(user);
		log.info("{}",json);
		return json;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edit(@Valid User user)
	{
		log.info("edit user!");
		this.userRepository.save(user);
		Map<String,String> map = new HashMap<>();
		String message = "用户 " + user.getName() + " 编辑成功!";
		map.put("message", message);
		return new ModelAndView(new RedirectView("list"), map);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable("id") String id, Model model)
	{
		log.info("delete successful!");
	}

}
