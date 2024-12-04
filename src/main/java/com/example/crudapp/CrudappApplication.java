package com.example.crudapp;

import com.example.crudapp.entity.Person;
import com.example.crudapp.repository.PersonDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PersonDAO dao){
		return runner -> {
			saveData(dao);
			getData(dao);
			getAllData(dao);
			updateData(dao);
		};
	}

	public void saveData(PersonDAO dao){
		Person obj1 = new Person("jojo", "Ruksiam");
		dao.save(obj1);
		System.out.println("Insert Complete");
	}

	public void deleteData(PersonDAO dao){
		int id = 2;
		dao.delete(id);
		System.out.println("Delete Complete");
	}

	public void getData(PersonDAO dao){
		int id=1;
		Person person = dao.get(id);
		System.out.println(person);
	}

	public void getAllData(PersonDAO dao){
		List<Person> persons = dao.getAll();
		for (Person person: persons){
			System.out.println(person);
		}
	}

	public void updateData(PersonDAO dao){
		int id=4;
		Person person = dao.get(id);
		person.setFname("charlie");
		person.setLname("Chaplin");
		dao.update(person);
		System.out.println("Update Complete");
	}
}
