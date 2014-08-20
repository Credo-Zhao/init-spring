/**
 * <p>Copyright (c) 2014 ZhaoQian.All Rights Reserved.</p>
 * @author <a href="zhaoqianjava@foxmail.com">ZhaoQian</a>
 */
package org.credo.security.controller;

import java.util.List;

import javax.validation.Valid;

import org.credo.repository.RoleRepository;
import org.credo.security.model.Role;
import org.credo.security.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Credo
 * @date: 2014年8月20日
 */
@Controller
@RequestMapping("/security/role")
public class RoleBean
{
	private static final Logger log = LoggerFactory.getLogger(UserBean.class);

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	RoleService roleService;

	@RequestMapping("/list")
	public String list(Model model)
	{
		List<Role> roleList = roleRepository.findAll();
		model.addAttribute("roleList", roleList);
		List<String> permissionList=roleService.queryAllPermissions();
		model.addAttribute("permissionList", permissionList);
		return "/security/role/list";
	}

	@ModelAttribute
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public Role initCreate()
	{
		Role role = new Role();
		return role;
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String submitCreate(@Valid Role role, Model model)
	{
		roleRepository.save(role);
		return "redirect:/role/list";
	}
}
