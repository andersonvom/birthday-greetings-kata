package it.xpug.kata.birthday_greetings;

import java.time.LocalDate;
import java.util.Objects;

public class BirthDate {

  public static final int FEB_29 = 60;
  public static final int FEB_28 = 59;
  private LocalDate date;

  BirthDate(LocalDate date) {
    this.date = date;
  }

  public boolean isBirthday(LocalDate currentDate) {
    if(date.getDayOfYear() == FEB_29 && !currentDate.isLeapYear()) {
      return currentDate.getDayOfYear() == FEB_28;
    }

    return date.getDayOfYear() == currentDate.getDayOfYear();
  }

  @Override
  public boolean equals(Object o) {
    return date.equals(((BirthDate) o).date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date);
  }
}
