/**
 * <p>Copyright (c) 2014 ZhaoQian.All Rights Reserved.</p>
 * @author <a href="zhaoqianjava@foxmail.com">ZhaoQian</a>
 */
package org.zhaoqian.security.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zhaoqian.repository.RoleRepository;
import org.zhaoqian.security.model.Role;
import org.zhaoqian.security.model.enums.Permission;
import org.zhaoqian.security.service.RoleService;

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
		List<String> permissionList = roleService.queryAllPermissions();
		model.addAttribute("permissionList", permissionList);
		return "/security/role/list";
	}

	@ModelAttribute
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String initCreate(Model model)
	{
		List<Permission> permissions = new ArrayList<Permission>();
		for (Permission permission : Permission.values())
		{
			permissions.add(permission);
		}
		Collections.sort(permissions);
		model.addAttribute("permissions", permissions);
		return "/security/role/list";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String submitCreate(Model model, HttpServletRequest request)
	{
		String name = request.getParameter("roleName");
		String desc = request.getParameter("roleDesc");
		String permissionStr = request.getParameter("permissionStr");
		Role role=new Role();
		role.setName(name);
		role.setDescription(desc);
		String[] permissionArray= permissionStr.split(",");
		role.setPermissions(Arrays.asList(permissionArray));
		roleRepository.save(role);
		return "redirect:/security/role/list";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String initEdit(@PathVariable("id") String id, Model model){
		Role role = roleRepository.findOne(Long.parseLong(id));
		model.addAttribute("role",role);
		List<Permission> permissions = new ArrayList<Permission>();
		for (Permission permission : Permission.values())
		{
			permissions.add(permission);
		}
		Collections.sort(permissions);
		model.addAttribute("permissions", permissions);
		return "/security/role/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String submitEdit(Model model, HttpServletRequest request){
		
		String id=request.getParameter("id");
		String name = request.getParameter("roleName");
		String desc = request.getParameter("roleDesc");
		String permissionStr = request.getParameter("permissionStr");
		
		Role role=this.roleRepository.findOne(Long.parseLong(id));
		
		role.setName(name);
		role.setDescription(desc);
		String[] permissionArray= permissionStr.split(",");
		List<String> list=Arrays.asList(permissionArray);
		
		role.setPermissions(new ArrayList<>(list));
		this.roleRepository.save(role);
		return "redirect:/security/role/list";
	}
}
