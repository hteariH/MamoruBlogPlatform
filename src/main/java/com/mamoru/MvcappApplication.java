package com.mamoru;

import com.mamoru.model.Note;
import com.mamoru.model.Tag;
import com.mamoru.repository.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

@SpringBootApplication
public class MvcappApplication{
	private static final Logger logger = LoggerFactory.getLogger(MvcappApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(MvcappApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(NoteRepository noteRepository1){
		return args -> {
			Tag tag1 = new Tag("sport");
			Tag tag2 = new Tag("it");
			Tag tag3 = new Tag("books");

			noteRepository1.save(new ArrayList<Note>(){{
				add(new Note("text1",new HashSet<Tag>(){{
					add(tag1);
					add(tag2);
				}}));

				add(new Note("text2", new HashSet<Tag>(){{
					add(tag1);
					add(tag3);
				}}));

			}});

			for(Note note: noteRepository1.findAll()){
				logger.info(note.toString());
			}
			noteRepository1.findAll().forEach(x-> logger.info(x.toString()));
		};
	}
}
