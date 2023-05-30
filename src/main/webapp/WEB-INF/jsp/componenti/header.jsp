<%@ page import="com.github.ipwt22.tum4world.helpers.UtenteHelper" %>
<%@ page import="com.github.ipwt22.tum4world.helpers.DatabaseHelper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%
    HttpSession session = request.getSession(false);
    String token;
    boolean isTokenInvalid;
    if(session!=null)
        token = (String)session.getAttribute("token");
    else
        token = (String)request.getParameter("token");
    System.out.println("header: " + token);
    isTokenInvalid = (token==null) || (token.equals("")) || (UtenteHelper.fromToken(DatabaseHelper.getConnection(), token)==null);
%>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/componenti/header.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
</head>
<h1 id="titolo_sito">Tum4World</h1>
<div id="div_header">
    <ul>
        <li><a href="${pageContext.request.contextPath}/">Home</a></li>
        <li><a href="chisiamo">Chi siamo</a></li>
        <li><a href="attivita">Attività</a></li>
        <li><a href="contatti">Contatti</a></li>
        <% if(isTokenInvalid){ %>
            <li><a href="signup">Sign-up</a></li>
            <li><a href="login">Login</a></li>
        <% }else{ %>
            <li><a href="logout">Logout</a></li>
            <li><a href="dashboard">Dashboard</a></li>
        <% } %>
    </ul>
    <span id="citazione"><p></p></span>
</div>
