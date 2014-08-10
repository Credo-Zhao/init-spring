/**
 * <p>Copyright (c) 2014 ZhaoQian.All Rights Reserved.</p>
 * @author <a href="zhaoqianjava@foxmail.com">ZhaoQian</a>
 */
package org.credo.repository;

import org.credo.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ZhaoQian
 * @date: 2014年8月3日
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>
{

}
