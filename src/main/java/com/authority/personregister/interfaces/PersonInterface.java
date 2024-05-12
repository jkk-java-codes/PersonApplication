package com.authority.personregister.interfaces;

import java.util.List;
import java.util.UUID;

import com.authority.personregister.businessLogicClasses.LifeEventData;
import com.authority.personregister.businessLogicClasses.Person;

public interface PersonInterface {
  UUID getId();

  void setId(UUID id);

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

  String getSpokenLanguage();

  void setSpokenLanguage(String spokenLanguage);

  List<Person> getChildren();

  void setChildren(List<Person> children);

  Person getSpouse();

  void setSpouse(Person spouse);

}