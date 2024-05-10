package com.authority.personregister.businessLogicClasses;

import java.time.LocalDate;

import com.authority.personregister.interfaces.LifeEventDataInterface;
import com.authority.personregister.interfaces.LifeEventType;

public class LifeEventData implements LifeEventDataInterface {

    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private LocalDate dateOfDeath;
    private String placeOfDeath;

    public LifeEventData(LocalDate dateOfDeath, String placeOfDeath) {
        this.dateOfDeath = dateOfDeath;
        this.placeOfDeath = placeOfDeath;
    }

    public LifeEventData(LocalDate dateOfBirth, String placeOfBirth, LocalDate dateOfDeath, String placeOfDeath) {
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.placeOfDeath = placeOfDeath;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }

    @Override
    public void setLifeEventData(LocalDate date, String place, LifeEventType lifeEvent) {
        if (lifeEvent == LifeEventType.BIRTH) {
            this.dateOfBirth = date;
            this.placeOfBirth = place;
        } else if (lifeEvent == LifeEventType.DEATH) {
            this.dateOfDeath = date;
            this.placeOfDeath = place;
        }
    }

}
