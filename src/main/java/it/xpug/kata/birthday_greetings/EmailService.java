package it.xpug.kata.birthday_greetings;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

  private String host;
  private int port;
  private Session session;

  EmailService(String host, int port) {
    this.host = host;
    this.port = port;
    this.session = getSession();
  }

  public void sendMessage(String sender, String subject, String body, String recipient)
      throws MessagingException {
    Transport.send(getMessage(sender, subject, body, recipient));
  }

  private Session getSession() {
    Properties props = new Properties();
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", port);
    return Session.getInstance(props, null);
  }

  private Message getMessage(String sender, String subject, String body, String recipient)
      throws MessagingException {
    Message msg = new MimeMessage(session);
    msg.setFrom(new InternetAddress(sender));
    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
    msg.setSubject(subject);
    msg.setText(body);

    return msg;
  }
}
