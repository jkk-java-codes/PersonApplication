package com.authority.personregister.interfaces;

import java.time.LocalDate;

public interface LifeEventDataInterface {

  LocalDate getDateOfBirth();

  void setDateOfBirth(LocalDate dateOfBirth);

  String getPlaceOfBirth();

  void setPlaceOfBirth(String placeOfBirth);

  LocalDate getDateOfDeath();

  void setDateOfDeath(LocalDate dateOfDeath);

  String getPlaceOfDeath();

  void setPlaceOfDeath(String placeOfDeath);

  void setLifeEventData(LocalDate date, String place, LifeEventType lifeEvent);

}
