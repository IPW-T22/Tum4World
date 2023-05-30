<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html lang="it">
<head>
    <title>Tum4World - Home page</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pubblico/homepage.css">
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
        <p>Tum4word è un'associazione che si dedica alla solidarietà e al volontariato in paesi poveri. Da anni, lavoriamo per migliorare la vita delle persone che vivono in comunità svantaggiate, fornendo supporto e risorse per soddisfare le loro esigenze. Grazie al nostro impegno costante e alla collaborazione con le comunità locali, siamo riusciti a realizzare molti progetti di successo, tra cui la costruzione di scuole e ospedali, la fornitura di acqua potabile, la promozione dell'agricoltura sostenibile e la lotta contro la povertà. Se vuoi fare la differenza nel mondo e contribuire a una causa importante, unisciti a noi e diventa parte della nostra comunità di volontari.</p>
            Vuoi scaricare il volantino della nostra associazione?
        <div>
            <a href="${pageContext.request.contextPath}/pdf/volantino.pdf" download><button>Clicca qui</button></a>
        </div>
    </main>
    <jsp:include page="../componenti/footer.jsp"/>
</body>
</html>
