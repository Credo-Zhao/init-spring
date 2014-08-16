/**
 * <p>Copyright (c) 2014 ZhaoQian.All Rights Reserved.</p>
 * @author <a href="zhaoqianjava@foxmail.com">ZhaoQian</a>
 */
package org.credo.security.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.codec.Base64;
import org.credo.repository.UserRepository;
import org.credo.security.model.User;
import org.credo.security.service.UserService;
import org.credo.security.shiro.authc.PasswordHelper;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
			throws UnsupportedEncodingException
	{
		int pageNumber = page != null ? page : 0;
		Page<User> pageUser = userService.findAllForPagination(pageNumber, 10);
		model.addAttribute("pageUser", pageUser);
		if (message!=null)
		{
			log.info(Base64.decodeToString(message));
			model.addAttribute("message", Base64.decodeToString(message));
		}
		return "/security/user/list";
	}

	@RequestMapping("/create")
	public ModelAndView create(User user) throws UnsupportedEncodingException
	{
		user = PasswordHelper.generatePassword(user);
		userRepository.save(user);
		Map<String,String> map = new HashMap<>();
		String str = "用户" + user.getName() + "创建成功!";
		map.put("message", Base64.encodeToString(str.getBytes()));
		return new ModelAndView(new RedirectView("list"), map);
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public void edit(@PathVariable("id") String id, Model model)
	{
		User user = this.userRepository.findOne(Long.parseLong(id));
		model.addAttribute(user);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable("id") String id, Model model)
	{
		log.info("delete successful!");
	}

}
