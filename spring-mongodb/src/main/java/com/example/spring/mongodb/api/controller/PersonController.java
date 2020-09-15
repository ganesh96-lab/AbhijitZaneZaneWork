package com.example.spring.mongodb.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.mongodb.api.model.Person;
import com.example.spring.mongodb.api.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping("/create")
	public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		
		Person p = personService.create(firstName, lastName, age); 
		return p.toString();
	}
	 
	@GetMapping("/get")
	public Person getPerson(@RequestParam String firstName) {
		return personService.getByFirstName(firstName);
	}
	@GetMapping("/getAll")
	public List<Person> getAll(){
		
		return personService.getAll();
	}
	@PutMapping("/update")
	public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
	
		Person p =  personService.update(firstName, lastName, age);
		return p.toString();
	}
	@DeleteMapping("/delete")
	public String delete(@RequestParam String firstName) {
		personService.delete(firstName);
		return "Deleted"+firstName;
	}
	@DeleteMapping("/deleteAll")
	public String deleteAll(){
		personService.deleteAll();
		return "Deleted all records";
	}
} 
