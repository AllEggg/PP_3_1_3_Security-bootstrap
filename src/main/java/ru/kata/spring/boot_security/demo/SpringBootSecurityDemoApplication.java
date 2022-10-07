package ru.kata.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.Set;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SpringBootSecurityDemoApplication.class, args);

		UserService userService = context.getBean(UserService.class);
		RoleService roleService = context.getBean(RoleService.class);

		if (userService.findByUsername("admin1") == null) {
			if (roleService.getRoleByName("ROLE_ADMIN") == null) {
				Role role = new Role("ROLE_ADMIN");
				roleService.saveRole(role);
			}
			Role role = roleService.getRoleByName("ROLE_ADMIN");
			User userAdmin = new User();
			userAdmin.setFirstName("admin1");
			userAdmin.setLastName("admin1");
			userAdmin.setEmail("admin1");
			userAdmin.setPassword("admin1");
			userAdmin.setAge(33);
			userAdmin.setRoles(Set.of(role));

			userService.saveUser(userAdmin);
		}
		if (userService.findByUsername("user1") == null) {
			if (roleService.getRoleByName("ROLE_USER") == null) {
				Role role = new Role("ROLE_USER");
				roleService.saveRole(role);
			}
			Role role = roleService.getRoleByName("ROLE_USER");
			User user = new User();
			user.setFirstName("user1");
			user.setLastName("user1");
			user.setEmail("user1");
			user.setPassword("user1");
			user.setAge(33);
			user.setRoles(Set.of(role));

			userService.saveUser(user);
		}
	}


}
