package it.xpug.kata.birthday_greetings;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class Main {

  public static void main(String[] args)
      throws AddressException, IOException, ParseException, MessagingException {
    String host = "localhost";
    int port = 25;
    EmailService emailService = new EmailService(host, port);
    BirthdayService service = new BirthdayService(emailService);
    service.sendGreetings("employee_data.txt", LocalDate.now());
  }
}
