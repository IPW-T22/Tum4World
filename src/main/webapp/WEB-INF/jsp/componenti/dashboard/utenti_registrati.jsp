<%@ page import="com.github.ipwt22.tum4world.models.Utente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<jsp:useBean id="utenti" class="com.github.ipwt22.tum4world.models.Utenti" scope="request"/>
<section id="utenti_registrati">
    <h2>Utenti Registrati</h2>
    <ul>
        <% for(Utente u : utenti.getList()) { %>
        <li><%= u.getNome() %> <%= u.getCognome() %> (@<%= u.getUsername()%>)</li>
        <% } %>
    </ul>
</section>