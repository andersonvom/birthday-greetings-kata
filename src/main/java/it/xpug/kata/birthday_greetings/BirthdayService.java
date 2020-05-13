package it.xpug.kata.birthday_greetings;

import java.time.LocalDate;
import java.util.List;
import javax.mail.MessagingException;

public class BirthdayService {

  public static final String SENDER = "sender@here.com";
  public static final String SUBJECT = "Happy Birthday!";
  private EmailService emailService;

  public BirthdayService(EmailService emailService) {
    this.emailService = emailService;
  }

  public void sendGreetings(List<Employee> employees, LocalDate date) {
    employees.stream().filter(employee -> employee.isBirthday(date)).forEach(this::sendEmail);
  }

  private void sendEmail(Employee employee) {
    try {
      emailService.sendMessage(SENDER, SUBJECT, getBody(employee), employee.getEmail());
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }

  private String getBody(Employee employee) {
    return "Happy Birthday, dear %NAME%".replace("%NAME%", employee.getFirstName());
  }
}
