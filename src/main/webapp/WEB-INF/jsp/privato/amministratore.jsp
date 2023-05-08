<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tum4World - Amministratore</title>
</head>
<body>
    <jsp:include page="../componenti/header.jsp"/>

    <nav>
        <button id="bottone_utenti_registrati">Utenti Registrati</button>
        <button id="bottone_simpatizzanti">Simpatizzanti</button>
        <button id="bottone_aderenti">Aderenti</button>
        <button id="bottone_visite">Visite</button>
        <button id="bottone_donazioni">Donazioni</button>
    </nav>
    <jsp:include page="../componenti/dashboard/utenti_registrati.jsp"/>
    <jsp:include page="../componenti/dashboard/simpatizzanti.jsp"/>
    <jsp:include page="../componenti/dashboard/aderenti.jsp"/>
    <jsp:include page="../componenti/dashboard/visite.jsp"/>
    <jsp:include page="../componenti/dashboard/donazioni.jsp"/>

    <jsp:include page="../componenti/footer.jsp"/>
</body>
</html>
