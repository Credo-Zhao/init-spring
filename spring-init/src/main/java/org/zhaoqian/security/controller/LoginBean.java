package org.zhaoqian.security.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zhaoqian.security.model.User;
import org.zhaoqian.security.shiro.support.JpaRealmRepository;

/**
 * @author ZhaoQian
 * @date: 2014年7月29日
 */
@Controller
public class LoginBean
{
	private static final Logger log = LoggerFactory.getLogger(LoginBean.class);
	
	@Autowired
	JpaRealmRepository jpaRealmRepository;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login()
	{
		Subject subject=SecurityUtils.getSubject();
		if(subject.isAuthenticated()){
			return "redirect:/home";
		}
		return "/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request)
	{
		Subject subject=SecurityUtils.getSubject();
		if(subject.isAuthenticated()||subject.isRemembered()){
			return "redirect:/home";
		}
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String loginKaptchaCode = request.getParameter("code");

		Session shiroSession = subject.getSession();
		Object kaptchaCode = shiroSession.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

		if (kaptchaCode!=null && !StringUtils.equalsIgnoreCase(loginKaptchaCode, kaptchaCode.toString()))
		{
			model.addAttribute("message", "验证码错误!");
			return "/login";
		}

		UsernamePasswordToken token = new UsernamePasswordToken(username, password, false, request.getRemoteHost());
		try
		{
			subject.login(token);
			User user = jpaRealmRepository.findUserByName(username);
			user.setLastLogin(new Date());
			user = jpaRealmRepository.mergeUser(user);

			return "redirect:/home";
		} catch (UnknownAccountException uae)
		{
			model.addAttribute("message", "Unknown User!");
			log.info("Unknown User!");
		} catch (IncorrectCredentialsException ice)
		{
			model.addAttribute("message", "Incorrect Password!");
			log.info("Incorrect Password!");
		} catch (LockedAccountException lae)
		{
			model.addAttribute("message", "User Locked!");
			log.info("User Locked!");
		} catch (AuthenticationException ae)
		{
			model.addAttribute("message", "Authentication Failed!");
			log.info("Authentication Failed!");
		} 
		return "/login";
	}
}
