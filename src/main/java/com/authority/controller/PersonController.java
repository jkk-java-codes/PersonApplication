package com.authority.controller;

import com.authority.personregister.businessLogicClasses.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PersonController {
  private List<Person> persons = new ArrayList<>();

  // these hardcoded for demo and test purposes only, since no db connection yet
  public PersonController() {
    persons = new ArrayList<>();

    persons
        .add(new Person(UUID.randomUUID(), "Mikko", "Mika", "Mallikas", "01022003-1234", null, null, null, null, null));
    persons.add(new Person(UUID.randomUUID(), "Matti", "Marko", "Mallikas", null, null, null, null, null, null));
    persons.add(new Person(UUID.randomUUID(), "Maija", "Mirka", "Mallikas", null, null, null, null, null, null));
    persons.add(new Person(UUID.randomUUID(), "Leena", "Liisa", "Mallikas", null, null, null, null, null, null));
    persons.add(
        new Person(UUID.randomUUID(), "Taija", "Tiina", "Tahdikas", "02032004-2345", null, null, null, null, null));
  }

  @GetMapping("/person/{id}")
  public ResponseEntity<Person> getPerson(@PathVariable("id") UUID id) {
    Person person = fetchPersonById(id);
    return person != null ? new ResponseEntity<>(person, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
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

  private boolean matchesName(Person person, String name) {
    if (name == null) {
      return true;
    }
    String fullName = person.getFirstName() + " " + person.getLastName();
    return person.getFirstName().toLowerCase().contains(name.toLowerCase()) ||
        person.getLastName().toLowerCase().contains(name.toLowerCase()) ||
        fullName.toLowerCase().contains(name.toLowerCase());
  }

  private boolean matchesIdentityNumber(Person person, String identityNumber) {
    if (identityNumber == null) {
      return true;
    }
    if (person.getIdentityNumber() == null) {
      return false;
    }
    System.out.println("Comparing identity number: " + person.getIdentityNumber() + " with " + identityNumber);
    return person.getIdentityNumber().equalsIgnoreCase(identityNumber);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Person>> searchPersons(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String identityNumber) {

    List<Person> result = persons.stream()
        .filter(person -> matchesName(person, name) && matchesIdentityNumber(person, identityNumber))
        .collect(Collectors.toList());

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping("/person")
  public ResponseEntity<Person> createPerson(@RequestBody Person person) {
    UUID id = UUID.randomUUID();
    person.setId(id);
    persons.add(person);
    return new ResponseEntity<>(person, HttpStatus.CREATED);
  }

  @PutMapping("/person/{id}")
  public ResponseEntity<Person> updatePerson(@PathVariable("id") UUID id, @RequestBody Person updatedPerson) {
    Person existingPerson = fetchPersonById(id);
    if (existingPerson != null) {
      existingPerson.setFirstName(updatedPerson.getFirstName());
      existingPerson.setLastName(updatedPerson.getLastName());

      return new ResponseEntity<>(existingPerson, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/person/{id}")
  public ResponseEntity<Void> deletePerson(@PathVariable("id") UUID id) {
    Person personToBeRemoved = fetchPersonById(id);
    if (personToBeRemoved != null) {
      persons.remove(personToBeRemoved);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}