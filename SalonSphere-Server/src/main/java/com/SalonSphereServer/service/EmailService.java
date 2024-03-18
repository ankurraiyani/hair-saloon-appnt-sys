package com.SalonSphereServer.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import com.SalonSphereServer.entity.Email;

@Component
public class EmailService {

    public boolean sendEmail(String subject , String message , String to1, String to2) {
        
        boolean f = false;
        
        String from = "krunal7022110@gmail.com";
        
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
//        System.out.println(properties);

//        Set Host
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", 465);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

//        Get the session object

        Session session = Session.getInstance(properties, new Authenticator() {

            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                // TODO Auto-generated method stub
                return new javax.mail.PasswordAuthentication("krunal7022110@gmail.com", "ypuo nmqi chwi lswb");
            }

        });

        session.setDebug(true);

//        Compose message
        MimeMessage mimeMessage = new MimeMessage(session);

        try {
//            Adding Sender
            mimeMessage.setFrom(from);

//            Adding Recipients
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to1));
            mimeMessage.setRecipient(Message.RecipientType.CC, new InternetAddress(to2));

//            Adding subject to message
            mimeMessage.setSubject(subject);

//            Adding Message Text
            mimeMessage.setText(message);

            Transport.send(mimeMessage);
            System.out.println("Sent Successfully...................");
            
            f = true;
            
            Email email = new Email();
            email.setTo(to1);
            email.setCc(to2);
            email.setSubject(subject);
            email.setMessage(message);
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return f;
        
    }

}
