/**
 * <p>Copyright (c) 2014 ZhaoQian.All Rights Reserved.</p>
 * @author <a href="zhaoqianjava@foxmail.com">ZhaoQian</a>
 */
package org.zhaoqian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zhaoqian.security.model.Role;

/**
 *
 * @author ZhaoQian
 * @date: 2014年8月3日
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>
{

}
