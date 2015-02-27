/**
 * <p>Copyright (c) 2014 ZhaoQian.All Rights Reserved.</p>
 * @author <a href="zhaoqianjava@foxmail.com">ZhaoQian</a>
 */
package org.zhaoqian.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zhaoqian.repository.UserRepository;
import org.zhaoqian.security.model.User;

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
