package ru.johnson.airblocknote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.johnson.airblocknote.model.User;
import ru.johnson.airblocknote.servise.UserService;

@SpringBootApplication
public class AirblocknoteApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(AirblocknoteApplication.class, args);

//		System.out.println("---------------------------------------------------");
//		Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println);
//		System.out.println("---------------------------------------------------");

		User user = new User("Vasya", "Vasya@mail.ru");
		User user2 = new User("Valera", "Valera@mail.ru");

		UserService userService = context.getBean(UserService.class);
		userService.createOrUpdate(user);
		userService.createOrUpdate(user2);

		User userNew = userService.getById(user.getId());
		User userNew2 = userService.getById(user2.getId());

		System.out.println(userNew);
		System.out.println(userNew2);
		System.out.println();
		userService.getAll().forEach(System.out::println);

		System.out.println();

		user2.setEmail("NewEmail@mail.ru");
		userService.createOrUpdate(user2);
		userService.getAll().forEach(System.out::println);
	}
}
