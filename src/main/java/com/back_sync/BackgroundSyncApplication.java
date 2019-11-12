package com.back_sync;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.back_sync.dao.UserRepository;
import com.back_sync.models.User;


@SpringBootApplication
public class BackgroundSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackgroundSyncApplication.class, args);
	}
	
	// Comment after first run, or remove this completely and add the test data directly to the database.
	/*@Bean
	CommandLineRunner start(UserRepository user_repo) {
		return args -> {
			user_repo.deleteAll();
			User user1 = new User("u1", "User1", "email1@email.com", "link_avatar1.jpg");
			User user2 = new User("u2", "User2", "email2@email.com", "link_avatar2.jpg");
			User user3 = new User("u3", "User3", "email3@email.com", "link_avatar3.jpg");
			User user4 = new User("u4", "User4", "email4@email.com", "link_avatar4.jpg");
			user_repo.save(user1);
			user_repo.save(user2);
			user_repo.save(user3);
			user_repo.save(user4);
			user_repo.findAll().forEach(System.out::println);
			
			
		};
	}*/
}
