<%@ page import="com.github.ipwt22.tum4world.models.Utente" session="false" %>
<% Utente[] utenti = {new Utente(), new Utente(), new Utente()}; %>

<section id="simpatizzanti">
    <h2>Simpatizzanti</h2>
    <ul>
        <% for (int i = 0; i < utenti.length; i += 1) { %>
            <li><%= utenti[i].getNome() %> <%= utenti[i].getCognome() %> (@<%= utenti[i].getUsername()%>)</li>
        <% } %>
    </ul>
</section>