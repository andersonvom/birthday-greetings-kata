package it.xpug.kata.birthday_greetings;

import java.time.LocalDate;

public class BirthDate {

  private LocalDate date;

  BirthDate(LocalDate date) {
    this.date = date;
  }

  public boolean isBirthday(LocalDate otherDate) {
    return date.getDayOfYear() == otherDate.getDayOfYear();
  }
}
