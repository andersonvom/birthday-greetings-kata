package it.xpug.kata.birthday_greetings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class BirthDateTest {
  @Test
  void isSameDate() {
    BirthDate birthDate = new BirthDate(LocalDate.parse("2001-01-24"));

    LocalDate sameDay = LocalDate.parse("2001-01-24");
    LocalDate notSameDay = LocalDate.parse("1789-01-25");
    LocalDate notSameMonth = LocalDate.parse("1789-02-25");

    assertTrue("same", birthDate.isBirthday(sameDay));
    assertFalse("not same day", birthDate.isBirthday(notSameDay));
    assertFalse("not same month", birthDate.isBirthday(notSameMonth));
  }
}
