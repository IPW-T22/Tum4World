package com.github.ipwt22.tum4world.controllers;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;


//https://www.tutorialspoint.com/java/java_sending_email.htm
@WebServlet(name = "contatti", value = "/contatti")
public class ContattiController extends HttpServlet {

    private String from = "tum4world@nessunonoluogoesistente.com";
    private String host = "localhost";
    private Session session = null;
    private Properties properties = System.getProperties();

    @Override
    public void init() throws ServletException {
        super.init();
        properties.setProperty("mail.smtp.host", host);
        session = Session.getDefaultInstance(properties);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/pubblico/contatti.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        String motivoContatto = request.getParameter("motivo_contatto");
        String dettagliRichiesta = request.getParameter("dettagli_richiesta");

        sendEmailContattaci(nome, cognome, email, motivoContatto, dettagliRichiesta);

        response.sendRedirect("invioconfermato");
    }

    private void sendEmailContattaci(String nome, String cognome, String to, String motivoContatto, String dettagliRichiesta){
        String header = "Motivo del contatto: " + motivoContatto;
        String content = "Gentile " + nome + " " + cognome +
                ",\n grazie per averci contattato a causa della seguente richiesta: \n\n"
                + dettagliRichiesta +
                "\n Le faremo sapere al più presto. Cordiali saluti," +
                "\nTum4World";

        try {
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
        }
        System.out.println("EMAIL INVIATA");
    }
}