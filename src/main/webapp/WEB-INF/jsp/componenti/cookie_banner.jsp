<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/componenti/cookie_banner.css">
</head>
<div id = "div_cookie_banner">
    <p id="message"> Messaggio Cookie </p>
    <span id="pannello_pulsanti"><button id = "decline_cookie" onclick = "declineCookie()"> Decline </button> <button id = "accept_cookie" onclick = "acceptCookie()"> Accept </button></span>
</div>