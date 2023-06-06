<%@ page import="com.github.ipwt22.tum4world.models.Utente" session="false" %>
<jsp:useBean id="simpatizzanti" class="com.github.ipwt22.tum4world.models.Utenti" scope="request"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/privato/basic_amministratore.css">
<section id="simpatizzanti">
    <h2>Simpatizzanti</h2>
    <ul>
        <% for(Utente u : simpatizzanti.getList()) { %>
            <li><%= u.getNome() %> <%= u.getCognome() %> (@<%= u.getUsername()%>)</li>
        <% } %>
    </ul>
</section>