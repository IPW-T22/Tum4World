<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html lang="it">
<head>
    <title>Tum4World - Sign Up</title>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pubblico/signup.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/signupcheck.js"></script>
</head>
<body>
<jsp:include page="../componenti/header.jsp"/>
<main>
    <h1>Registrazione:</h1>
    <div>
        <form action="signup" method="post" id="myform">
            <span>
                    <label for="nome">Nome:</label>
                    <br>
                    <input type="text" id="nome" name="nome" >
                    <br>
                    <span id="nomeErr" class="error"></span>
                </span>
            <br>
            <span>
                    <label for="cognome">Cognome:</label>
                    <br>
                    <input type="text" id="cognome" name="cognome" >
                    <br>
                    <span id="cognomeErr" class="error"></span>
                </span>
            <br>
            <span>
                    <label for="data_nascita">Data di nascita (GG/MM/AAAA):</label>
                    <br>
                    <input type="date" id="data_nascita" name="data_nascita" >
                    <br>
                    <span id="data_nascitaErr" class="error"></span>
                </span>
            <br>
            <span>
                    <label for="email">Indirizzo email:</label>
                    <br>
                    <input type="email" id="email" name="email" >
                    <br>
                    <span id="emailErr" class="error"></span>
                </span>
            <br>
            <span>
                    <label for="telefono">Numero di telefono:</label>
                    <br>
                    <input type="tel" id="telefono" name="telefono" >
                    <br>
                    <span id="telefonoErr" class="error"></span>
                </span>
            <br>
            <span>
                    <label>Tipo di registrazione:</label>
                    <br>
                    <input id="bt1" type="radio" id="simpatizzante" name="tipo_registrazione" value="SIMPATIZZANTE" checked>
                    <label for="simpatizzante">Simpatizzante</label>
                    <input id="bt1" type="radio" id="aderente" name="tipo_registrazione" value="ADERENTE" >
                    <label for="aderente">Aderente</label>
                    <br>
                </span>
            <br>
            <span>
                    <label for="username">Username:</label>
                    <br>
                    <input type="text" id="username" name="username">
                    <br>
                    <span id="usernameErr" class="error"></span>
                </span>
            <br>
            <span>
                    <label for="password">Password (8 caratteri, prima lettera dei nomi propri, almeno un numero, un carattere maiuscolo e un carattere tra $, ! e ?):</label>
                    <br>
                    <input type="password" id="password" name="password" >
                    <br>
                    <span id="passwordErr" class="error"></span>
                </span>
            <br>
            <span>
                    <label for="password_conferma">Conferma password:</label>
                    <br>
                    <input type="password" id="password_conferma" name="password_conferma" >
                    <br>
                    <span id="password_confermaErr" class="error"></span>
                </span>
            <br>
            <span>
                    <button type="submit">Registrati</button>
                    <button type="reset">Reset</button>
                </span>
            <%
                if(request.getParameter("error")!=null) {
                out.print("<p>T22: Errore username già esistente</p>");
                }
            %>
        </form>
    </div>
</main>
<script>

    let form = document.getElementById("myform");
    form.addEventListener("submit", ValidateForm);

</script>
<jsp:include page="../componenti/footer.jsp"/>
</body>
</html>
