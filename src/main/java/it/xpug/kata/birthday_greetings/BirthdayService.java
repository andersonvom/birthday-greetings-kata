package it.xpug.kata.birthday_greetings;

import java.time.LocalDate;
import java.util.List;
import javax.mail.MessagingException;

public class BirthdayService {

  private EmailService emailService;

  public BirthdayService(EmailService emailService) {
    this.emailService = emailService;
  }

  public void sendGreetings(List<Employee> employees, LocalDate date) {
    employees.stream().filter(employee -> employee.isBirthday(date)).forEach(this::sendEmail);
  }

  private void sendEmail(Employee employee) {
    String recipient = employee.getEmail();
    String body = "Happy Birthday, dear %NAME%".replace("%NAME%", employee.getFirstName());
    String subject = "Happy Birthday!";
    try {
      emailService.sendMessage("sender@here.com", subject, body, recipient);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }
}
