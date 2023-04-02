package hello;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class EmailService {
    private final Properties props = new Properties();
    private final String username = "polakovandrej327@mail.ru";
    private final String password = "3CUub11dTYFkt9gEBxcT";
    public EmailService() {
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mail.ru");
        props.put("mail.smtp.port", "587");


    }
    @Async
    public void sendEmail(String subject, String text) throws MessagingException {
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
