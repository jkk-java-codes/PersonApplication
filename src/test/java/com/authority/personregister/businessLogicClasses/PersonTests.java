package com.authority.personregister.businessLogicClasses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonTests {

  @Test
  public void testThatPersonReturnsFirstName() {
    Person testPerson = new Person(UUID.randomUUID(), "Maija", "Miina", "Mallikas", null, null, null, null, null, null);
    assertEquals("Maija", testPerson.getFirstName());
  }

  @Test
  void testSetFirstName() {
    Person person = new Person(UUID.randomUUID(), "Taija", "Tiina", "Tahdikas", null, null, null, null, null, null);
    person.setFirstName("Jaana");
    assertEquals("Jaana", person.getFirstName());
  }

  @Test
  void testGetLastName() {
    Person person = new Person(UUID.randomUUID(), "Antti", "Meidän", "Mallikas", null, null, null, null, null, null);
    assertEquals("Mallikas", person.getLastName());
  }

  @Test
  void testSetLastName() {
    Person person = new Person(UUID.randomUUID(), "Anna", "Meille", "Malli", null, null, null, null, null, null);
    person.setLastName("Mallikas");
    assertEquals("Mallikas", person.getLastName());
  }

  @Test
  void testGetIdentityNumber() {
    Person person = new Person(UUID.randomUUID(), null, null, null, "01012001-0000", null, null, null, null, null);
    assertEquals("01012001-0000", person.getIdentityNumber());
  }

  @Test
  void testSetIdentityNumber() {
    Person person = new Person(UUID.randomUUID(), null, null, null, "01012001-0000", null, null, null, null, null);
    person.setIdentityNumber("01012001+0000");
    assertEquals("01012001+0000", person.getIdentityNumber());
  }

  @Test
  void testGetLifeEventData() {
    LocalDate birthDate = LocalDate.of(1990, 1, 1);
    LocalDate deathDate = LocalDate.of(2050, 12, 31);
    LifeEventData lifeInfo = new LifeEventData(birthDate, deathDate);
    Person person = new Person(UUID.randomUUID(), null, null, null, null, lifeInfo, null, null, null, null);
    assertEquals(lifeInfo, person.getLifeEventData());
  }

  @Test
  void testSetLifeEventData() {
    LocalDate birthDate = LocalDate.of(1990, 1, 1);
    LocalDate deathDate = LocalDate.of(2050, 12, 31);
    LifeEventData lifeInfo = new LifeEventData(birthDate, deathDate);
    Person person = new Person(UUID.randomUUID(), null, null, null, null, null, null, null, null, null);
    person.setLifeEventData(lifeInfo);
    assertEquals(lifeInfo, person.getLifeEventData());
  }

  @Test
  public void testGetCitizenship() {
    String citizenship = "Finnish";
    Person person = new Person(UUID.randomUUID(), null, null, null, null, null, citizenship, null, null, null);
    assertEquals(citizenship, person.getCitizenship());
  }

  @Test
  public void testSetCitizenship() {
    String citizenship = "Swedish";
    Person person = new Person(UUID.randomUUID(), null, null, null, null, null, null, null, null, null);
    person.setCitizenship(citizenship);
    assertEquals(citizenship, person.getCitizenship());
  }

  @Test
  public void testGetSpokenLanguage() {
    String spokenLanguage = "English";
    Person person = new Person(UUID.randomUUID(), null, null, null, null, null, null, spokenLanguage, null, null);
    assertEquals(spokenLanguage, person.getSpokenLanguage());
  }

  @Test
  public void testSetSpokenLanguage() {
    String spokenLanguage = "French";
    Person person = new Person(UUID.randomUUID(), null, null, null, null, null, null, null, null, null);
    person.setSpokenLanguage(spokenLanguage);
    assertEquals(spokenLanguage, person.getSpokenLanguage());
  }

  @Test
  public void testGetChildren() {
    List<Person> children = new ArrayList<>();
    Person child1 = new Person(UUID.randomUUID(), null, null, null, null, null, null, null, null, null);
    Person child2 = new Person(UUID.randomUUID(), null, null, null, null, null, null, null, null, null);
    children.add(child1);
    children.add(child2);

    Person person = new Person(UUID.randomUUID(), null, null, null, null, null, null, null, children, null);
    assertEquals(children, person.getChildren());
  }

  @Test
  public void testSetChildren() {
    List<Person> children = new ArrayList<>();

    Person child1 = new Person(UUID.randomUUID(), null, null, null, null, null, null, null, null, null);
    Person child2 = new Person(UUID.randomUUID(), null, null, null, null, null, null, null, null, null);
    children.add(child1);
    children.add(child2);

    Person person = new Person(UUID.randomUUID(), null, null, null, null, null, null, null, null, null);
    person.setChildren(children);
    assertEquals(children, person.getChildren());
  }

  @Test
  public void testGetSpouse() {
    Person spouse = new Person(UUID.randomUUID(), null, null, null, null, null, null, null, null, null);
    Person person = new Person(UUID.randomUUID(), null, null, null, null, null, null, null, null, spouse);
    assertEquals(spouse, person.getSpouse());
  }

  @Test
  public void testSetSpouse() {
    Person spouse = new Person(UUID.randomUUID(), null, null, null, null, null, null, null, null, null);
    Person person = new Person(UUID.randomUUID(), null, null, null, null, null, null, null, null, null);
    person.setSpouse(spouse);
    assertEquals(spouse, person.getSpouse());
  }

  @Test
  public void testSetEmptyFirstNameThrowsException() {
    Person person = new Person();
    try {
      person.setFirstName("");
    } catch (IllegalArgumentException e) {
      assertEquals("Value cannot be null or empty.", e.getMessage());
    }
  }

  @Test
  public void testSetEmptyLastNameThrowsException() {
    Person person = new Person();
    try {
      person.setLastName("");
    } catch (IllegalArgumentException e) {
      assertEquals("Value cannot be null or empty.", e.getMessage());
    }
  }

  @Test
  public void testSetEmptyIdentityNumberThrowsException() {
    Person person = new Person();
    try {
      person.setIdentityNumber("");
    } catch (IllegalArgumentException e) {
      assertEquals("Value cannot be null or empty.", e.getMessage());
    }
  }

  @Test
  public void testSetNullFirstNameThrowsException() {
    Person person = new Person();
    try {
      person.setFirstName(null);
    } catch (IllegalArgumentException e) {
      assertEquals("Value cannot be null or empty.", e.getMessage());
    }
  }

  @Test
  public void testSetNullLastNameThrowsException() {
    Person person = new Person();
    try {
      person.setLastName(null);
    } catch (IllegalArgumentException e) {
      assertEquals("Value cannot be null or empty.", e.getMessage());
    }
  }

  @Test
  public void testSetNullIdentityNumberThrowsException() {
    Person person = new Person();
    try {
      person.setIdentityNumber(null);
    } catch (IllegalArgumentException e) {
      assertEquals("Value cannot be null or empty.", e.getMessage());
    }
  }
}