package com.github.ipwt22.tum4world.models;

//https://www.tutorialspoint.com/java/java_sending_email.htm

import java.util.*;
/*import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;*/

public class EmailSender {
    private String from = "tum4world@nessunonoluogoesistente.com";
    private String to = null;
    private String host = "localhost";
    private Properties properties = System.getProperties();

    //private Session;

    public EmailSender() {
        properties.setProperty("mail.smtp.host", host);
        //Session session = Session.getDefaultInstance(properties);
    }

    public void sendEmail(String to, String header, String message){
        this.to = to;
        /*try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }*/
        System.out.println("EMAIL INVIATA");
    }
}
