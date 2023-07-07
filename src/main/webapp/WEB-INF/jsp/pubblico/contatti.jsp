<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Tum4World - Contattaci</title>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pubblico/contatti.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/contatticheck.js"></script>
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
            <form action="contatti?token=<%out.println(request.getParameter("token")); %>" method="post" onsubmit="return ValidateForm();">
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" >
                <span id="nomeErr" class="error"></span>
                <br>
                <label for="cognome">Cognome:</label>
                <input type="text" id="cognome" name="cognome" >
                <span id="cognomeErr" class="error"></span>
                <br>

                <label for="email">Indirizzo email:</label>
                <input type="email" id="email" name="email" >
                <span id="emailErr" class="error"></span>
                <br>

                <label for="motivo_contatto">Motivo di contatto:</label>
                <select id="motivo_contatto" name="motivo_contatto" >
                    <option value="">-- Seleziona un motivo --</option>
                    <option value="Richiesta di informazioni">Richiesta di informazioni</option>
                    <option value="Supporto tecnico">Supporto tecnico</option>
                    <option value="Segnalazione di problema">Segnalazione di problema</option>
                    <option value="Altro">Altro</option>
                </select>
                <span id="selectErr" class="error"></span>
                <br>

                <label for="dettagli_richiesta">Dettagli della richiesta:</label>
                <textarea id="dettagli_richiesta" name="dettagli_richiesta"></textarea>
                <br>

                <button type="submit" id="invia">Invia</button>
                <button type="reset">Reset</button>
            </form>
        </div>
    </main>
    <jsp:include page="../componenti/footer.jsp"/>
</body>
</html>
