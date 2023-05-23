<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%
    HttpSession session = request.getSession(false);
    String token = request.getParameter("token");
%>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/componenti/header.css">
</head>
<header>

    <div id="div_header">
        <h1 id="titolo_sito">Tum4World</h1>
        <ul>
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="chisiamo">Chi siamo</a></li>
            <li><a href="attivita">Attività</a></li>
            <li><a href="contatti">Contatti</a></li>
            <% if(session==null && (token==null || token.equals(""))){ %>
                <li><a href="signup">Sign-up</a></li>
                <li><a href="login">Login</a></li>
            <% } %>

            <% if (session != null || (token != null && !token.equals(""))) { //DOVREI CONTROLLARE CHE L'ID È VALIDO %>
                <li><a href="logout">Logout</a></li>
                <li><a href="dashboard">Dashboard</a></li>
            <% } %>
        </ul>
        <span><p>Citazione: </p></span>
    </div>
</header>
