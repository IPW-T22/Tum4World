<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tum4World - Aderente</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/privato/aderente.css">
</head>
<body>
    <jsp:include page="../componenti/header.jsp"/>

    <nav>
        <br>
        <br>
        <button id="bottone_dati_personali">Dati Personali</button>
        <button id="bottone_iscrizioni">Iscrizioni</button>
        <button id="bottone_elimina_profilo">Elimina Profilo</button>
        <button id="bottone_donazione">Donazione</button>
    </nav>
    <jsp:include page="../componenti/dashboard/dati_personali.jsp"/>
    <jsp:include page="../componenti/dashboard/iscrizioni.jsp"/>
    <jsp:include page="../componenti/dashboard/elimina_profilo.jsp"/>
    <jsp:include page="../componenti/dashboard/donazione.jsp"/>

    <jsp:include page="../componenti/footer.jsp"/>
</body>
</html>
