package it.xpug.kata.birthday_greetings;

import static org.junit.Assert.assertEquals;

import com.dumbster.smtp.SimpleSmtpServer;
import com.dumbster.smtp.SmtpMessage;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AcceptanceTest {

  private static final int NONSTANDARD_PORT = 9999;
  private static final String HOST = "localhost";
  private BirthdayService birthdayService;
  private EmailService emailService;
  private SimpleSmtpServer mailServer;

  @Before
  public void setUp() throws Exception {
    mailServer = SimpleSmtpServer.start(NONSTANDARD_PORT);
    emailService = new EmailService(HOST, NONSTANDARD_PORT);
    birthdayService = new BirthdayService(emailService);
  }

  @After
  public void tearDown() throws Exception {
    mailServer.stop();
    Thread.sleep(200);
  }

  @Test
  public void willSendGreetings_whenItsSomebodysBirthday() throws Exception {

    birthdayService.sendGreetings(List.of(), LocalDate.parse("2008-10-08"));

    assertEquals("message not sent?", 1, mailServer.getReceivedEmails().size());
    SmtpMessage message = (SmtpMessage) mailServer.getReceivedEmails().get(0);
    assertEquals("Happy Birthday, dear John", message.getBody());
    assertEquals("Happy Birthday!", message.getHeaderValue("Subject"));
    List<String> recipients = message.getHeaderValues("To");
    assertEquals(1, recipients.size());
    assertEquals("john.doe@foobar.com", recipients.get(0));
  }

  @Test
  public void willNotSendEmailsWhenNobodysBirthday() throws Exception {
    birthdayService.sendGreetings(List.of(), LocalDate.parse("2008/01/01"));

    assertEquals("what? messages?", 0, mailServer.getReceivedEmails().size());
  }
}
