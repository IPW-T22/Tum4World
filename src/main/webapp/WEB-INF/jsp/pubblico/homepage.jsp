<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html lang="it">
<head>
    <title>Tum4World - Home page</title>
    <meta charset="UTF-8">
    <!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pubblico/homepage.css"> -->
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">
</head>
<body>
    <jsp:include page="../componenti/header.jsp"/>
    <main>
        <div>
            <img src="${pageContext.request.contextPath}/images/logo.jpg" alt="Logo dell'associazione">
        <h1>Benvenuti nell'Associazione Tum4World</h1>
        <div>
            <img id="im1" src="${pageContext.request.contextPath}/images/immagine_rappresentativa.jpg" alt="Immagine rappresentativa dell'associazione">
        </div>
        <p>Tum4World è un'associazione no-profit che si occupa di promuovere lo sviluppo sostenibile e la tutela dell'ambiente a livello globale. Attraverso progetti di sensibilizzazione, raccolta fondi e collaborazioni internazionali, Tum4World mira a creare una cultura di responsabilità ambientale e a contribuire alla salvaguardia del nostro pianeta per le future generazioni. L'associazione organizza inoltre eventi e iniziative per coinvolgere la comunità locale e diffondere la consapevolezza sull'importanza di adottare comportamenti e stili di vita eco-sostenibili.</p>
            Vuoi scaricare il volantino della nostra associazione?
        <div>
            <a href="${pageContext.request.contextPath}/pdf/volantino.pdf" download><button>Clicca qui</button></a>
        </div>
    </main>
    <jsp:include page="../componenti/footer.jsp"/>
</body>
</html>
