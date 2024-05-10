package com.authority.personregister.businessLogicClasses;

import java.util.List;

import com.authority.personregister.interfaces.PersonInterface;

public class Person implements PersonInterface {
  private String firstName;
  private String middleName;
  private String lastName;
  private String identityNumber;
  private LifeEventData lifeEventData;
  private String citizenship;
  private List<Person> children;
  private Person spouse;
  private String spokenLanguage;

  public Person() {
  }

  public Person(List<Person> children) {
    this.children = children;
  }

  public Person(String identityNumber) {
    this.identityNumber = identityNumber;
  }

  public Person(String identityNumber, LifeEventData lifeEventData) {
    this.identityNumber = identityNumber;
    this.lifeEventData = lifeEventData;
  }

  public Person(String firstName, String lastName) {
    validateName(firstName, lastName);

    this.firstName = firstName;
    this.lastName = lastName;
    this.children = null; // Added null initialization
  }

  public Person(String firstName, String middleName, String lastName) {
    validateName(firstName, middleName, lastName);

    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.children = null;
  }

  public Person(String identityNumber, LifeEventData lifeEventData, String citizenship,
      String spokenLanguage) {
    this.identityNumber = identityNumber;
    this.lifeEventData = lifeEventData;
    this.citizenship = citizenship;
    this.spokenLanguage = spokenLanguage;
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  @Override
  public void setFirstName(String firstName) {
    validateStringInput(firstName);
    this.firstName = firstName;
  }

  @Override
  public String getMiddleName() {
    return middleName;
  }

  @Override
  public void setMiddleName(String middleName) {
    validateStringInput(middleName);
    this.middleName = middleName;
  }

  @Override
  public String getLastName() {
    return lastName;
  }

  @Override
  public void setLastName(String lastName) {
    validateStringInput(lastName);
    this.lastName = lastName;
  }

  @Override
  public String getIdentityNumber() {
    return identityNumber;
  }

  @Override
  public void setIdentityNumber(String identityNumber) {
    validateStringInput(identityNumber);
    this.identityNumber = identityNumber;
  }

  @Override
  public LifeEventData getLifeEventData() {
    return lifeEventData;
  }

  @Override
  public void setLifeEventData(LifeEventData lifeEventData) {
    this.lifeEventData = lifeEventData;
  }

  public String getCitizenship() {
    return citizenship;
  }

  public void setCitizenship(String citizenship) {
    validateStringInput(citizenship);
    this.citizenship = citizenship;
  }

  public String getSpokenLanguage() {
    return spokenLanguage;
  }

  public void setSpokenLanguage(String spokenLanguage) {
    validateStringInput(spokenLanguage);
    this.spokenLanguage = spokenLanguage;
  }

  public List<Person> getChildren() {
    return children;
  }

  public void setChildren(List<Person> children) {
    this.children = children;
  }

  public Person getSpouse() {
    return spouse;
  }

  public void setSpouse(Person spouse) {
    this.spouse = spouse;
  }

  private void validateName(String firstName, String lastName) {
    if (firstName.isEmpty() || lastName.isEmpty()) {
      throw new IllegalArgumentException("First name and last name cannot be empty.");
    }
  }

  private void validateName(String firstName, String middleName, String lastName) {
    if (firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty()) {
      throw new IllegalArgumentException("First name or middlename or last name cannot be empty.");
    }
  }

  private void validateStringInput(String value) {
    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException("Value cannot be null or empty.");
    }
  }
}