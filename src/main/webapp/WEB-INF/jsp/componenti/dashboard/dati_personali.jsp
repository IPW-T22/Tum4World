<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<jsp:useBean id="utente" class="com.github.ipwt22.tum4world.models.Utente" scope="request"/>
<section id="dati_personali">
    <h2>Dati Personali</h2>
    Nome: <span id="nome"><%= utente.getNome()%></span><br/>
    Cognome: <span id="cognome"><%= utente.getCognome()%></span><br/>
    Data di nascita: <span id="data_nascita"><%= utente.getDataDiNascita()%></span><br/>
    Email: <span id="email"><%= utente.getEmail()%></span><br/>
    Telefono: <span id="telefono"><%= utente.getTelefono()%></span><br/>
    Ruolo: <span id="ruolo"><%= utente.getRuolo()%></span><br/>
    Username: <span id="username"><%= utente.getUsername()%></span><br/>
</section>