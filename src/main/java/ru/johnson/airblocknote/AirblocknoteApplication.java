package ru.johnson.airblocknote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.johnson.airblocknote.model.Note;
import ru.johnson.airblocknote.model.NoteEntity;
import ru.johnson.airblocknote.servise.AppService;
import ru.johnson.airblocknote.servise.UserService;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class AirblocknoteApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(AirblocknoteApplication.class, args);

//		System.out.println("---------------------------------------------------");
//		Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println);
//		System.out.println("---------------------------------------------------");

//		User user = new User("Vasya", "Vasya@mail.ru");
//		User user2 = new User("Valera", "Valera@mail.ru");

		UserService userService = context.getBean(UserService.class);
		AppService appService = context.getBean(AppService.class);

//		userService.createOrUpdate(user);
//		userService.createOrUpdate(user2);

		userService.getAll().forEach(System.out::println);

		System.out.println();

		Note note = new Note(100000,true);
		Note note2 = new Note(100000,true);
		NoteEntity noteEntity = new NoteEntity(true, "Desc Entity One", note);
		NoteEntity noteEntity2 = new NoteEntity(true, "Desc Entity Two", note);
		note.setNoteEntities(new ArrayList<>());
		note.addNoteEntity(noteEntity);
		note.addNoteEntity(noteEntity2);

		appService.greateOrUpdate(note);
		appService.greateOrUpdate(note2);

		appService.getAllNotes().forEach(System.out::println);
	}
}
