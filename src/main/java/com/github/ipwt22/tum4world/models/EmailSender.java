package com.github.ipwt22.tum4world.models;

//https://www.tutorialspoint.com/java/java_sending_email.htm

import java.util.*;
/*import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;*/

public class EmailSender {
    private String from = "tum4world@nessunonoluogoesistente.com";
    private String host = "localhost";
    private Properties properties = System.getProperties();

    //private Session;

    public EmailSender() {
        properties.setProperty("mail.smtp.host", host);
        //Session session = Session.getDefaultInstance(properties);
    }

    public void sendEmailContattaci(String nome, String cognome, String to, String motivoContatto, String dettagliRichiesta){
        String header = "Motivo del contatto: " + motivoContatto;
        String content = "Gentile " + nome + " " + cognome +
                ",\n grazie per averci contattato a causa della seguente richiesta: \n\n"
                + dettagliRichiesta +
                "\n Le faremo sapere al più presto. Cordiali saluti," +
                "\nTum4World";

        /*try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(header);

            // Now set the actual message
            message.setText(content);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }*/
        System.out.println("EMAIL INVIATA");
    }
}
