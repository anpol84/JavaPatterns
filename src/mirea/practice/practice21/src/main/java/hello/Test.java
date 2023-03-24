package hello;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws MessagingException {
        /*
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.mail.ru");
        mailSender.setPort(587);
        mailSender.setUsername("polakovandrej327@mail.ru");
        mailSender.setPassword("1yagFyGz358xnzYbHMa5");
        //1yagFyGz358xnzYbHMa5

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.host", "smtp.mail.ru");
        //props.put("mail.smtp.port", "587");
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(new InternetAddress("polakovandrej327@mail.ru"));
        helper.setSubject("test");
        helper.setText("test");

        mailSender.send(message);
        System.out.println("Email sent successfully.");
        */
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mail.ru");
        props.put("mail.smtp.port", "587");
        String username = "polakovandrej327@mail.ru";
        String password = "1yagFyGz358xnzYbHMa5";
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        PasswordAuthentication passwordAuthentication = new PasswordAuthentication(username, password);
                        return passwordAuthentication;
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("polakovandrej327@mail.ru"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("polakovandrej327@mail.ru"));
            message.setSubject("Test Subject");
            message.setText("Test Body");

            Transport.send(message);

            System.out.println("Message sent successfully ...");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
