package com.authority.personregister.businessLogicClasses;

import com.authority.personregister.interfaces.SpokenLanguageInterface;

public class SpokenLanguage implements SpokenLanguageInterface {
  private String language;

  @Override
  public String getLanguage() {
    return language;
  }

  @Override
  public void setLanguage(String language) {
    this.language = language;
  }

}
