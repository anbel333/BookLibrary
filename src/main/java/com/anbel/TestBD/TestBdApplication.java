package com.anbel.TestBD;

import com.anbel.TestBD.entity.Book;
import com.anbel.TestBD.entity.ERole;
import com.anbel.TestBD.entity.Role;
import com.anbel.TestBD.entity.Users;
import com.anbel.TestBD.repository.RoleRepository;
import com.anbel.TestBD.service.BookService;
import com.anbel.TestBD.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TestBdApplication implements CommandLineRunner {
	@Autowired
	public RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestBdApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role roleUser = new Role(ERole.ROLE_USER);
		Role roleAdmin = new Role(ERole.ROLE_ADMIN);
		Role roleModerator = new Role(ERole.ROLE_MODERATOR);

		roleRepository.save(roleUser);
		roleRepository.save(roleAdmin);
		roleRepository.save(roleModerator);
	}
}
