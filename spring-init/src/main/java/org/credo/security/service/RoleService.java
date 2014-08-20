/**
 * <p>Copyright (c) 2014 ZhaoQian.All Rights Reserved.</p>
 * @author <a href="zhaoqianjava@foxmail.com">ZhaoQian</a>
 */
package org.credo.security.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.credo.repository.RoleRepository;
import org.credo.security.model.enums.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Credo
 * @date: 2014年8月20日
 */
@Service
public class RoleService
{
	@Autowired
	RoleRepository roleRepository;

	public List<String> queryAllPermissions()
	{
		List<String> permissions = new ArrayList<String>();
		for (Permission permission : Permission.values())
			permissions.add(permission.getAbbreviation());
		Collections.sort(permissions);
		return permissions;
	}
}
