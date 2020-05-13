package it.xpug.kata.birthday_greetings;

import java.time.LocalDate;
import java.util.Objects;

public class BirthDate {

  private LocalDate date;

  BirthDate(LocalDate date) {
    this.date = date;
  }

  public boolean isBirthday(LocalDate otherDate) {
    return date.getDayOfYear() == otherDate.getDayOfYear();
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
