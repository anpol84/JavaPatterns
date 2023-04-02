package hello.test;

import org.junit.Test;
import org.springframework.scheduling.annotation.Async;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailServiceTest {
    private final Properties props = new Properties();
    private final String username = "polakovandrej327@mail.ru";
    private final String password =
            "qh6rik20tQQSVSaS3X4F";
    public EmailServiceTest() {
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mail.ru");
        props.put("mail.smtp.port", "587");


    }
    @Test
    public void sendEmail() throws MessagingException {
        String subject = "something";
        String text = "Some text";
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        PasswordAuthentication passwordAuthentication = new PasswordAuthentication(username, password);
                        return passwordAuthentication;
                    }
                });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("polakovandrej327@mail.ru"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("polakovandrej327@mail.ru"));
        message.setSubject(subject);
        message.setText(text);

        Transport.send(message);

        System.out.println("Message sent successfully ...");
    }
}
