<%@ page import="com.github.ipwt22.tum4world.models.Utente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<jsp:useBean id="aderenti" class="com.github.ipwt22.tum4world.models.Utenti" scope="request"/>
<section id="aderenti">
    <h2>Aderenti</h2>
    <ul>
        <% for(Utente u : aderenti.getList()) { %>
        <li><%= u.getNome() %> <%= u.getCognome() %> (@<%= u.getUsername()%>)</li>
        <% } %>
    </ul>
</section>