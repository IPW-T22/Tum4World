<%@ page import="com.github.ipwt22.tum4world.models.Utente" %>
<% Utente[] utenti = {new Utente(), new Utente(), new Utente()}; %>

<section id="utenti_registrati">
    <h2>Utenti Registrati</h2>
    <ul>
        <% for (int i = 0; i < utenti.length; i += 1) { %>
            <li><%= utenti[i].getNome() %> <%= utenti[i].getCognome() %> (@<%= utenti[i].getUsername()%>)</li>
        <% } %>
    </ul>
</section>