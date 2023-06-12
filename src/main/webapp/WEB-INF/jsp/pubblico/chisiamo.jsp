<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html lang="it">
<head>
    <title>Tum4World - Chi Siamo</title>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pubblico/chisiamo.css">
</head>
<body>
    <jsp:include page="../componenti/header.jsp"/>
    <main>
        <div>
            <img src="${pageContext.request.contextPath}/images/logo.jpg" alt="Logo dell'associazione">
        </div>
        <h1>Chi siamo?</h1>
        <p>Tum4Word è un’associazione di volontariato che si concentra sull'istruzione e la salute nei paesi in via di sviluppo, offrendo supporto medico e programmi educativi per bambini e adulti, in paesi povere e in via di sviluppo.</p>

        <h2>Chi sono i nostri fondatori e quale è la nostra storia?</h2>
        <p>Tum4Word è stata fondata da due attivisti francesi, Marie e Pierre, 53 anni fa e ora è portata avanti dai figli.</p>
        <p>L'associazione nasce con lo scopo di fornire aiuti umanitari in zone di guerra, a seguito del conflitto del 1970 </p> <%-- ispirato a medici senza frontiere --%>
        <p>L'associazione negli anni a fornito supporto umanitario, cibo ed aiutato a costruire scuole in zone povere, e devastate da guerre e carestie</p>
        <div>
            <span>
                <img src="${pageContext.request.contextPath}/images/fondatore_1.jpg" alt="fondatore_1" />
                <img src="${pageContext.request.contextPath}/images/fondatore_2.jpg" alt="fondatore_2" />
            </span>
        </div>

        <h2>Quali sono le nostre sedi?</h2>
        <p>L'organizzazione ha sede a Parigi e ha aperto filiali in diversi paesi africani, tra cui Senegal, Camerun, e Costa d'Avorio.</p>
        <div>
            <div>
                <img src="${pageContext.request.contextPath}/images/sede1.jpg" alt="sede_1">
            </div>
            <div>
                <img src="${pageContext.request.contextPath}/images/sede2.jpg" alt="sede_2">
            </div>
            <div>
                <img src="${pageContext.request.contextPath}/images/sede3.jpg" alt="sede_3">
            </div>
        </div>

        <h2>Che riconoscimenti abbiamo ottenuto?</h2>
        <p>L'associazione a ricevuto numerosi premi per il suo operatto nel combattere la povertà e le malattie.</p>
        <p>L'associazione ha inoltre ottenuto il nobel per la pace a per l'aiuto fornito in zone di guerra.</p><%-- ispirato a medici senza frontiere --%>
        

        <h2>Quali obbiettivi ci poniamo?</h2>
        <p>l'associazione si pone l'obbittivo di continuare la sua opera di solidarietà, e di favorire lo sviluppo sostenibile nelle zone in cui opera. </p>
    </main>
    <jsp:include page="../componenti/footer.jsp"/>
</body>
</html>
