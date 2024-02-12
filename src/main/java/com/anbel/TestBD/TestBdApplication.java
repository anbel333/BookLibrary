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
	public BookService bookService;
	@Autowired
	public UsersService usersService;
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


		Users users1 = new Users();
		users1.setFullName("Шурик Городецкий");
		users1.setEmail("shurik@");


		Users users2 = new Users();
		users2.setFullName("Некитос Сика");
		users2.setEmail("sika@");

//		usersService.saveUsers(users1);
//		usersService.saveUsers(users2);


		Book book1 = new Book();
		book1.setAuthor("Вася пупкин");
		book1.setRating(2.5);
		book1.setTitle("Басни питушарские");
//		book1.setUsers(users1);

		Book book2 = new Book();
		book2.setTitle("Трицератопсы");
		book2.setAuthor("Кащей");
		book2.setRating(5.0);
//		book2.setUsers(users2);

		Book book3 = new Book();
		book3.setTitle("Война и мир");
		book3.setAuthor("Лев Толстой");
		book3.setRating(3.3);
//		book3.setUsers(users1);

		bookService.saveBook(book1);
		bookService.saveBook(book2);
		bookService.saveBook(book3);

	}
}
