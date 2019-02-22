package com.firstJavaspringwar.vivek.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firstJavaspringwar.vivek.model.Person;
import com.firstJavaspringwar.vivek.service.PersonService;

@RestController
public class PersonController {
    @Autowired
	PersonService personService;
	
    @RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@RequestParam String name, @RequestParam String country) {
		
		Person oPerson=new Person();
				oPerson.setName(name);
				oPerson.setCountry(country);
			System.out.println("parson "+oPerson);	
				this.personService.addPerson(oPerson);		
		return "Person created ";
		
	}
	
    @RequestMapping(value= "/person/{id}", method = RequestMethod.GET)
	public String getParson(@PathVariable("id") Integer id) {
		        System.out.println(id);
		System.out.println(this.personService);
				Person o=this.personService.getPersonById(id);
              System.out.println("o"+o.toString());
		return "Person got ";
		
	}
	
	
	
}
