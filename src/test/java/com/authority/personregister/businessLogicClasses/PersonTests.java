package com.authority.personregister.businessLogicClasses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.authority.personregister.interfaces.LifeEventType;

public class PersonTests {

  @Test
  public void testThatPersonReturnsFirstName() {
    Person testPerson = new Person("Maija", "Miina", "Malli");
    assertEquals("Maija", testPerson.getFirstName());
  }

  @Test
  void testSetFirstName() {
    Person person = new Person("Taija", "Tiina", "Malli");
    person.setFirstName("Jaana");
    assertEquals("Jaana", person.getFirstName());
  }

  @Test
  void testGetLastName() {
    Person person = new Person("Antti", "Meidän", "Mallikas");
    assertEquals("Mallikas", person.getLastName());
  }

  @Test
  void testSetLastName() {
    Person person = new Person("Anna", "Meille", "Malli");
    person.setLastName("Mallikas");
    assertEquals("Mallikas", person.getLastName());
  }

  @Test
  void testGetIdentityNumber() {
    Person person = new Person("01012001-0000");
    assertEquals("01012001-0000", person.getIdentityNumber());
  }

  @Test
  void testSetIdentityNumber() {
    Person person = new Person("01012001-0000");
    person.setIdentityNumber("01012001+0000");
    assertEquals("01012001+0000", person.getIdentityNumber());
  }

  @Test
  void testGetLifeEventData() {
    LifeEventData lifeInfo = new LifeEventData(LocalDate.of(1950, 1, 1), "Vantaa", LocalDate.of(2003, 12, 31),
        "Helsinki");
    Person person = new Person("01011950-0000", lifeInfo);
    assertEquals(lifeInfo, person.getLifeEventData());
  }

  @Test
  void testSetLifeEventData() {
    LifeEventData lifeInfo = new LifeEventData(LocalDate.of(1950, 1, 1), "Rauma", LocalDate.of(2003, 12, 31),
        "Turku");
    Person person = new Person("01011950-0001");
    person.setLifeEventData(lifeInfo);
    assertEquals(lifeInfo, person.getLifeEventData());
  }

  @Test
  public void testSetBirthEvent() {
    LifeEventData lifeInformation = new LifeEventData(null, null);
    LocalDate birthDate = LocalDate.of(1990, 1, 1);
    String birthPlace = "Raahe";
    lifeInformation.setLifeEventData(birthDate, birthPlace, LifeEventType.BIRTH);
    assertEquals(birthDate, lifeInformation.getDateOfBirth());
    assertEquals(birthPlace, lifeInformation.getPlaceOfBirth());
  }

  @Test
  public void testSetDeathEvent() {
    LifeEventData lifeInformation = new LifeEventData(null, null);
    LocalDate deathDate = LocalDate.of(2020, 12, 31);
    String deathPlace = "Kokkola";
    lifeInformation.setLifeEventData(deathDate, deathPlace, LifeEventType.DEATH);
    assertEquals(deathDate, lifeInformation.getDateOfDeath());
    assertEquals(deathPlace, lifeInformation.getPlaceOfDeath());
  }

  @Test
  public void testGetLanguage() {
    String language = "Finnish";
    SpokenLanguage spokenLanguage = new SpokenLanguage();
    spokenLanguage.setLanguage(language);
    assertEquals(language, spokenLanguage.getLanguage());
  }

  @Test
  public void testSetLanguage() {
    String language = "Swedish";
    SpokenLanguage spokenLanguage = new SpokenLanguage();
    spokenLanguage.setLanguage(language);
    assertEquals(language, spokenLanguage.getLanguage());
  }

  @Test
  public void testMaritalStatus() {
    Person person1 = new Person("Jussi", "Mallikas");
    Person person2 = new Person("Maija", "Mallikas");

    assertNull(person1.getSpouse());
    assertNull(person2.getSpouse());

    person1.setSpouse(person2);
    person2.setSpouse(person1);

    assertEquals(person2, person1.getSpouse());
    assertEquals(person1, person2.getSpouse());
  }

  @Test
  public void testChildParentRelationship() {
    Person parent = new Person("Jussi", "Mallikas");
    Person child1 = new Person("Anna", "Mallikas");
    Person child2 = new Person("Matti", "Mallikas");

    assertNull(parent.getChildren());

    List<Person> children = new ArrayList<>();
    children.add(child1);
    children.add(child2);

    parent.setChildren(children);

    assertEquals(children, parent.getChildren());
  }

  @Test
  public void testChildParentRelationshipTwoParents() {
    Person parent1 = new Person("Jussi", "Mallikas");
    Person parent2 = new Person("Leena", "Mallikas");
    Person child1 = new Person("Maija", "Mallikas");
    Person child2 = new Person("Matti", "Mallikas");

    assertNull(parent1.getChildren());
    assertNull(parent2.getChildren());

    List<Person> children = new ArrayList<>();
    children.add(child1);
    children.add(child2);

    parent1.setChildren(children);
    parent2.setChildren(children);

    assertEquals(children, parent1.getChildren());
    assertEquals(children, parent2.getChildren());
  }
}