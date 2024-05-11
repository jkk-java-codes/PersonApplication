package com.authority.controller;

import com.authority.personregister.businessLogicClasses.Person;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
  @GetMapping("/persons/{id}")
  public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
    Person person = fetchPersonById(id);

    // Check if person exists
    if (person != null) {
      return new ResponseEntity<>(person, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  private Person fetchPersonById(Long id) {
    if (id == 1) {
      Person person = new Person();
      person.setFirstName("Mikko");
      person.setMiddleName("Milli");
      person.setLastName("Mallikas");
      return person;
    } else {
      return null;
    }
  }
}
