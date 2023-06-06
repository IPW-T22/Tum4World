<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>

<head>
    <title>Tum4World - Simpatizzante</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/privato/basic_amministratore.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/privato/simpatizzante.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/gestoreDashboardSimpAder.js"></script>
</head>
<body>
    <jsp:include page="../componenti/header.jsp"/>

    <div>
        <nav>
            <br>
            <br>
            <button id="bottone_dati_personali" onclick="mostraDatiPersonali()">Dati Personali</button>
            <button id="bottone_iscrizioni" onclick="mostraIscrizioni()">Iscrizioni</button>
            <button id="bottone_elimina_profilo" onclick="mostraEliminaProfilo()">Elimina Profilo</button>
        </nav>
        <jsp:include page="../componenti/dashboard/dati_personali.jsp"/>
        <jsp:include page="../componenti/dashboard/iscrizioni.jsp"/>
        <jsp:include page="../componenti/dashboard/elimina_profilo.jsp"/>

        <section id="elimina_profilo">

        </section>
    </div>
    <jsp:include page="../componenti/footer.jsp"/>
</body>
</html>
