package com.frugals.Sprimngjpa;

import com.frugals.Sprimngjpa.entity.User;
import com.frugals.Sprimngjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SprimngjpaApplication {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SprimngjpaApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(){
		return args -> {

			System.out.print("<<<<<<<<<<<<<Cleaning MongoDatabase>>>>>>>>>>>>>>");
			userRepository.deleteAll();

			for(int i=0;i<5;i++){
				User user=	userRepository.save(new User(i,"Test",String.valueOf(i+12)));

				System.out.println("<<<<<<<<<<<<<Adding User >>>>>>>>>>>>>>");
				System.out.println("***"+user.toString()+"***");
			}

			System.out.println("<<<<<<<<<<<<<Get All  User >>>>>>>>>>>>>>");
			List<User> alluser=userRepository.findAll();
			alluser.forEach(item -> System.out.println(item));

			alluser.clear();

			System.out.println("<<<<<<<<<<<<<Find User By Name >>>>>>>>>>>>>>");
		    alluser=userRepository.findByName("Test");
			alluser.forEach(item -> System.out.println(item));

			System.out.println("Executed");

		};
	}
}
