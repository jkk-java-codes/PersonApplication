package com.authority.personregister.interfaces;

import java.util.List;

import com.authority.personregister.businessLogicClasses.LifeEventData;
import com.authority.personregister.businessLogicClasses.Person;

public interface PersonInterface {
  Long getId();

  String getFirstName();

  void setFirstName(String firstName);

  String getMiddleName();

  void setMiddleName(String middleName);

  String getLastName();

  void setLastName(String lastName);

  String getIdentityNumber();

  void setIdentityNumber(String identityNumber);

  LifeEventData getLifeEventData();

  void setLifeEventData(LifeEventData lifeEventData);

  String getCitizenship();

  void setCitizenship(String citizenship);

  List<Person> getChildren();

  void setChildren(List<Person> children);

  Person getSpouse();

  void setSpouse(Person spouse);

  String getSpokenLanguage();

  void setSpokenLanguage(String spokenLanguage);
}