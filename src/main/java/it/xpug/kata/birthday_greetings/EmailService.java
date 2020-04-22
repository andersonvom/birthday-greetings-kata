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

  EmailService(String host, int port) {
    this.host = host;
    this.port = port;
  }

  public void sendMessage(String sender, String subject, String body, String recipient)
      throws MessagingException {
    // Create a mail session
    java.util.Properties props = new java.util.Properties();
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", port);
    Session session = Session.getInstance(props, null);

    // Construct the message
    Message msg = new MimeMessage(session);
    msg.setFrom(new InternetAddress(sender));
    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
    msg.setSubject(subject);
    msg.setText(body);

    // Send the message
    Transport.send(msg);
  }
}
