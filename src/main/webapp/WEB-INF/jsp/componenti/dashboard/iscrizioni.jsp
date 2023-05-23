<%@ page import="com.github.ipwt22.tum4world.models.Attivita" %>
<%@ page import="com.github.ipwt22.tum4world.models.Utente" %>
<jsp:useBean id="utente" class="com.github.ipwt22.tum4world.models.Utente" scope="request"/>
<% Attivita[] attivita = {new Attivita(), new Attivita(), new Attivita()}; %>

<section id="iscrizioni">
    <h2>Iscrizioni</h2>
    <% for (int i = 0; i < attivita.length; i += 1) { %>
    <input type="checkbox" id="attivita_<%= i %>"
           checked="<%= Utente.iscritto(utente, attivita[i])%>">
    <label for="attivita_<%= i %>" class="attivita">
        <%= attivita[i].getNome() %>
        <img src="<%= attivita[i].getUrlImmagine() %>"
             alt="<%= attivita[i].getNome() %>">
    </label>
    <br/>
    <% } %>
</section>