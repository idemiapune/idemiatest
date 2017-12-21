package com.idemia.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonSrvc {

	@Autowired
	PersonRepository personRepository;

	public Person create(Person entity) {

		Person Person = personRepository.save(entity);

		return Person;
	}

	public Person read(Long id) {

		Person Person = personRepository.findOne(id);

		return Person;
	}

	public Iterable<Person> readAll() {

		Iterable<Person> PersonRecords = personRepository.findAll();
		return PersonRecords;
	}

	public Person update(Person tobemerged) {
		Person PersonOrig = personRepository.findOne(tobemerged.getId());
		Person Person = personRepository.save(PersonOrig.mergeUpdates(tobemerged));
		return Person;
	}

	public Boolean delete(Long id) {
		personRepository.delete(id);
		return true;
	}
}
