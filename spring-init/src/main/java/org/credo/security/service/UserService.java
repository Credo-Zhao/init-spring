/**
 * <p>Copyright (c) 2014 ZhaoQian.All Rights Reserved.</p>
 * @author <a href="zhaoqianjava@foxmail.com">ZhaoQian</a>
 */
package org.credo.security.service;

import org.credo.repository.UserRepository;
import org.credo.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ZhaoQian
 * @date: 2014年8月13日
 */
@Service
public class UserService
{
	@Autowired
	UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public Page<User> findAllForPagination(int page, int size)
	{
		Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC, "id"));
		Page<User> users = userRepository.findAll(pageable);
		return users;
	}
}
