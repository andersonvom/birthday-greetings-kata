package it.xpug.kata.birthday_greetings;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class Main {

  public static void main(String[] args) throws IOException {
    String host = "localhost";
    int port = 25;
    EmailService emailService = new EmailService(host, port);
    BirthdayService service = new BirthdayService(emailService);
    String employeeDataFile = "employee_data.txt";
    List<Employee> employees = EmployeeParser.parse(employeeDataFile);
    service.sendGreetings(employees, LocalDate.now());
  }
}
