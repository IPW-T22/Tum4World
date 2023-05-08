<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Tum4World - Simpatizzante</title>
</head>
<body>
    <jsp:include page="../componenti/header.jsp"/>

    <div>
        <nav>
            <button id="bottone_dati_personali">Dati Personali</button>
            <button id="bottone_iscrizioni">Iscrizioni</button>
            <button id="bottone_elimina_profilo">Elimina Profilo</button>
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
