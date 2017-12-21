package com.idemia.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	PersonSrvc personSrvc;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Person> create(@RequestBody Person inputentity){
		ResponseEntity<Person> personResponse;
		Person person = personSrvc.create(inputentity);
		personResponse = new ResponseEntity<Person>(person, null, HttpStatus.CREATED);
		return personResponse;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> read(@PathVariable(value="id")Long id){
		ResponseEntity<Person> personResponse;
		Person person = personSrvc.read(id);
		personResponse = new ResponseEntity<Person>(person, null, HttpStatus.OK);
		return personResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<Person>> readAll(){
		ResponseEntity<Iterable<Person>> personResponse;
		Iterable<Person> appUserRecords = personSrvc.readAll();
		personResponse = new ResponseEntity<Iterable<Person>>(appUserRecords, null, HttpStatus.OK);
		return personResponse;
	}
	
	
	
	@RequestMapping(method = RequestMethod.PATCH)
	public ResponseEntity<Person> update(@RequestBody Person tobemerged){
		ResponseEntity<Person> personResponse;
		Person person = personSrvc.update(tobemerged);
		personResponse = new ResponseEntity<Person>(person, null, HttpStatus.CREATED);
		return personResponse;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Person> delete(@PathVariable(value="id")Long id){
		ResponseEntity<Person> personResponse;
		Boolean isdeleted = personSrvc.delete(id);
		if (isdeleted) {
			personResponse = new ResponseEntity<Person>(null, null, HttpStatus.OK);
		}else {
			personResponse = new ResponseEntity<Person>(null, null, HttpStatus.NOT_FOUND);
		}
		return personResponse;
	}
}
