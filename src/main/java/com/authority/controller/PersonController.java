package com.authority.controller;

import com.authority.personregister.businessLogicClasses.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
  private List<Person> persons = new ArrayList<>();

  public PersonController() {
    persons.add(new Person(1L, "Mikko", "Milli", "Mallikas"));
    persons.add(new Person(1L, "Matti", "Masa", "Mallikas"));
    persons.add(new Person(1L, "Maija", "Maippi", "Mallikas"));
    persons.add(new Person(1L, "Leena", "Lennu", "Mallikas"));

  }

  @GetMapping("/persons/{id}")
  public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
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

  private Person fetchPersonById(Long id) {
    return persons.stream()
        .filter(person -> person.getId().equals(id))
        .findFirst()
        .orElse(null);
  }
}
