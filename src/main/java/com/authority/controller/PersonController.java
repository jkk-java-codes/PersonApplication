package com.authority.controller;

import com.authority.personregister.businessLogicClasses.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class PersonController {
  private List<Person> persons = new ArrayList<>();

  // these hardcoded for demo and test purposes only, since no db connection yet
  public PersonController() {
    persons = new ArrayList<>();

    persons.add(new Person(UUID.randomUUID(), "Mikko", "Mika", "Mallikas", null, null, null, null, null, null));
    persons.add(new Person(UUID.randomUUID(), "Matti", "Marko", "Mallikas", null, null, null, null, null, null));
    persons.add(new Person(UUID.randomUUID(), "Maija", "Mirka", "Mallikas", null, null, null, null, null, null));
    persons.add(new Person(UUID.randomUUID(), "Leena", "Liisa", "Mallikas", null, null, null, null, null, null));
    persons.add(new Person(UUID.randomUUID(), "Taija", "Tiina", "Tahdikas", null, null, null, null, null, null));
  }

  @GetMapping("/person/{id}")
  public ResponseEntity<Person> getPerson(@PathVariable("id") UUID id) {
    Person person = fetchPersonById(id);

    if (person != null) {
      return new ResponseEntity<>(person, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/persons")
  public ResponseEntity<List<Person>> getAllpersons() {
    return new ResponseEntity<>(persons, HttpStatus.OK);
  }

  private Person fetchPersonById(UUID id) {
    return persons.stream()
        .filter(person -> person.getId().equals(id))
        .findFirst()
        .orElse(null);
  }
}