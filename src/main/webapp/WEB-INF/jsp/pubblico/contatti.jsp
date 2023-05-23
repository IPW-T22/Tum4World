<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Tum4World - Contattaci</title>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pubblico/contatti.css">
</head>
<body>
    <jsp:include page="../componenti/header.jsp"/>
    <main>
        <div>
            <h1>Contattaci</h1>
        </div>
        <div>
            <p>Indirizzo e-mail associazione: tum4world@nessunonoluogoesistente.com</p>
            <p>Numero telefono associazione: 5(325)779-72-14</p>
        </div>
        <div>
            <form action="contatti" method="post">
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" >
                <br>
                <label for="cognome">Cognome:</label>
                <input type="text" id="cognome" name="cognome" >
                <br>

                <label for="email">Indirizzo email:</label>
                <input type="email" id="email" name="email" >
                <br>

                <label for="motivo_contatto">Motivo di contatto:</label>
                <select id="motivo_contatto" name="motivo_contatto" >
                    <option value="">-- Seleziona un motivo --</option>
                    <option value="Richiesta di informazioni">Richiesta di informazioni</option>
                    <option value="Supporto tecnico">Supporto tecnico</option>
                    <option value="Segnalazione di problema">Segnalazione di problema</option>
                    <option value="Altro">Altro</option>
                </select>
                <br>

                <label for="dettagli_richiesta">Dettagli della richiesta:</label>
                <textarea id="dettagli_richiesta" name="dettagli_richiesta"></textarea>
                <br>

                <button type="submit">Invia</button>
                <button type="reset">Reset</button>
            </form>
        </div>
    </main>
    <jsp:include page="../componenti/footer.jsp"/>
</body>
</html>
