package com.idemia.restapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Transient
	public Person mergeUpdates(Person tobemerged) {
		this.firstName = (null != tobemerged.getFirstName() && !("".equals(tobemerged.getFirstName()))
				&& !(" ".equals(tobemerged.getFirstName())) ? tobemerged.getFirstName() : this.getFirstName());
		this.lastName = (null != tobemerged.getLastName() && !("".equals(tobemerged.getLastName()))
				&& !(" ".equals(tobemerged.getLastName())) ? tobemerged.getLastName() : this.getLastName());
		return this;
	}
}
