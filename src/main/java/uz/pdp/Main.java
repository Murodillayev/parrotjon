package uz.pdp;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws MessagingException, IOException {
        
//        try {
//            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
//            api.registerBot(new ParrotBot());
//
//        } catch (TelegramApiException e) {
//            throw new RuntimeException(e);
//        }

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        String from = "olmospro1978@gmail.com";
        String to = "olmosapple1978@gmail.com";
        String password = "pxxd dqso uvvp auqg";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Assalomu alaykum");
//        message.setContent("<h1 style='color:red'>Muhammadkomil</h1>", "text/html");
//        message.setText("Hello World");


        MimeBodyPart filePart = new MimeBodyPart();
        MimeBodyPart fileText = new MimeBodyPart();

        filePart.attachFile(new File("src/main/resources/test.txt"));
        fileText.setText("This is a test file");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(filePart);
        multipart.addBodyPart(fileText);

        message.setContent(multipart);
        Transport.send(message);
        System.out.println("Sent message successfully");
    }
}
