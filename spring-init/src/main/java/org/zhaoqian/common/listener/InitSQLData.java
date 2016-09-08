package org.zhaoqian.common.listener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.shiro.crypto.hash.Sha512Hash;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zhaoqian.model.Person;
import org.zhaoqian.repository.PersonRepository;
import org.zhaoqian.repository.RoleRepository;
import org.zhaoqian.repository.UserRepository;
import org.zhaoqian.security.model.Role;
import org.zhaoqian.security.model.User;

/**
 * 初始化SQL数据,数据库不限.登录账户为 zhaoqianjava@foxmail.com 密码123
 * 
 * @author Credo
 * @date: 2014年8月12日
 */
public class InitSQLData implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        WebApplicationContext webApplicationContext =
                WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        PersonRepository personRepository = webApplicationContext.getBean(PersonRepository.class);
        personRepository.deleteAll();

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String chars = "abcdefghijklmnopqrstuvwxyz";
            String name = String.valueOf(chars.charAt((int) (Math.random() * 26)));
            Person person = new Person();
            person.setName(name);
            person.setAge((i % 100) + 1);
            personList.add(person);
        }
        personRepository.save(personList);

        UserRepository userRepository = webApplicationContext.getBean(UserRepository.class);
        userRepository.deleteAll();

        User user = new User();
        user.setName("zhaoqianjava@foxmail.com");
        byte[] passwordSalt = UUID.randomUUID().toString().getBytes();
        user.setPasswordSalt(passwordSalt);
        user.setPassword("123");
        String passwordHash =
                new Sha512Hash(user.getPassword(), user.getName() + new String(passwordSalt), 99)
                        .toString();
        user.setPasswordHash(passwordHash);

        RoleRepository roleRepository = webApplicationContext.getBean(RoleRepository.class);
        roleRepository.deleteAll();
        Set<Role> roleSet = new HashSet<>();
        Role role = new Role();
        role.setName("admin");
        role.setDescription("管理员");

        List<String> permissisonList = new ArrayList<>();
        permissisonList.add("user:view");
        permissisonList.add("role:view");
        role.setPermissions(permissisonList);
        roleSet.add(roleRepository.save(role));
        user.setRoles(roleSet);
        userRepository.save(user);


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}

}
