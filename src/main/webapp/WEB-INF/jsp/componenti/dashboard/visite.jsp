<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/privato/basic_amministratore.css">
<section id="visite" >
    <h2>Visite</h2>
    <span id="contatore_totale">Totale: </span>
    <div id="container_visite"></div>
    <button onclick="resetContatori()">RESET</button>
</section>