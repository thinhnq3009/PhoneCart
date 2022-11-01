package eco.phonecart.app.email;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class MailSender {

    // = "gshipcerulpdhuuy"
    String usernameEmail;
    String passwordEmail;

    public MailSender(String usernameEmail, String passwordEmail) {
        this.usernameEmail = usernameEmail;
        this.passwordEmail = passwordEmail;
    }

    public boolean send(String to, String subject, String content) throws Exception {

        final String username = usernameEmail;
        final String password = passwordEmail;

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject(subject);

            message.setContent(content, "text/html");

            Transport.send(message);

            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new Exception();
        }

    }

    public boolean send(String to, String subject, String content, File file) throws Exception {

        final String username = usernameEmail;
        final String password = passwordEmail;

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject(subject);

            Multipart multipart = new MimeMultipart();

            if (content != null) {
                MimeBodyPart bodyPartContent = new MimeBodyPart();
                bodyPartContent.setContent(content, "text/html");
                multipart.addBodyPart(bodyPartContent);
            }

            if (file != null) {
                MimeBodyPart bodyPartFile = new MimeBodyPart();
                bodyPartFile.attachFile(file);
                multipart.addBodyPart(bodyPartFile);
            }

            message.setContent(multipart);

            Transport.send(message);

            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new Exception();
        }

    }
}
