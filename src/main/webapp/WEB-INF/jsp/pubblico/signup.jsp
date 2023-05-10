<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html lang="it">
<head>
    <title>Tum4World - Sign Up</title>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="/images/favicon.ico">
</head>
<body>
    <jsp:include page="../componenti/header.jsp"/>
    <main>
        <h1>Registrazione:</h1>
        <div>
            <form action="signup" method="post">
                <span>
                    <label for="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" >
                </span>
                <br>
                <span>
                    <label for="cognome">Cognome:</label>
                    <input type="text" id="cognome" name="cognome" >
                </span>
                <br>
                <span>
                    <label for="data_nascita">Data di nascita (GG/MM/AAAA):</label>
                    <input type="date" id="data_nascita" name="data_nascita" >
                </span>
                <br>
                <span>
                    <label for="email">Indirizzo email:</label>
                    <input type="email" id="email" name="email" >
                </span>
                <br>
                <span>
                    <label for="telefono">Numero di telefono:</label>
                    <input type="tel" id="telefono" name="telefono" >
                </span>
                <br>
                <span>
                    <label>Tipo di registrazione:</label>
                    <input type="radio" id="simpatizzante" name="tipo_registrazione" value="SIMPATIZZANTE" checked>
                    <label for="simpatizzante">Simpatizzante</label>
                    <input type="radio" id="aderente" name="tipo_registrazione" value="ADERENTE" >
                    <label for="aderente">Aderente</label>
                </span>
                <br>
                <span>
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username">
                </span>
                <br>
                <span>
                    <label for="password">Password (8 caratteri, prima lettera dei nomi propri, almeno un numero, un carattere maiuscolo e un carattere tra $, ! e ?):</label>
                    <input type="password" id="password" name="password" >
                </span>
                <br>
                <span>
                    <label for="password_conferma">Conferma password:</label>
                    <input type="password" id="password_conferma" name="password_conferma" >
                </span>
                <br>
                <span>
                    <button type="submit">Registrati</button>
                    <button type="reset">Reset</button>
                </span>
                <%
                    if(request.getParameter("error")!=null) {
                        out.print("<p>Errore username già esistente</p>");
                    }
                %>
            </form>
        </div>
    </main>
    <jsp:include page="../componenti/footer.jsp"/>
</body>
</html>