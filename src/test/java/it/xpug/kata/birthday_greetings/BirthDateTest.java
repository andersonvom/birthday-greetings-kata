package it.xpug.kata.birthday_greetings;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
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

  @Test
  void isLeapBirthdate() {
    BirthDate birthDate = new BirthDate(LocalDate.parse("2004-02-29"));
    LocalDate feb29 = LocalDate.parse("2004-02-29");
    LocalDate feb28 = LocalDate.parse("2004-02-28");

    assertThat(birthDate.isBirthday(feb29), equalTo(true));
    assertThat(birthDate.isBirthday(feb28), equalTo(false));
  }

  @Test
  void isBirthday_notLeapYearFeb28() {
    BirthDate birthDate = new BirthDate(LocalDate.parse("2004-02-29"));
    LocalDate date = LocalDate.parse("2005-02-28");

    assertThat(birthDate.isBirthday(date), equalTo(true));
  }
}
