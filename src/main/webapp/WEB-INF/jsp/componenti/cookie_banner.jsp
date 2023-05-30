<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/componenti/cookie_banner.css">
</head>
<div id = "div_cookie_banner">
    <h2>Questo sito utilizza cookie e tecnologie simili</h2>
    <p id="message"> Grazie per aver visitato il nostro sito! Desideriamo informarti che utilizziamo solo cookie essenziali per garantire il corretto funzionamento del sito e offrirti un'esperienza ottimale, nel rispetto delle disposizioni dell'EU GPDR. Non utilizziamo altri tipi di cookie che potrebbero tracciare le tue attività senza il tuo consenso. Grazie per la tua fiducia e buona navigazione! </p>
    <p id="message">Per maggiori informazioni visita: <a href="https://gdpr.eu/cookies/">Cookies, the GDPR, and the ePrivacy Directive</a></p>
    <span id="pannello_pulsanti"><button id = "accept_cookie" onclick = "acceptCookie()"> Accept </button> <button id = "decline_cookie" onclick = "declineCookie()"> Decline </button> </span>
</div>