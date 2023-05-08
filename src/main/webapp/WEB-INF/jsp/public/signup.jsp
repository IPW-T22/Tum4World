<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html lang="it">
<head>
    <title>Tum4World - Sign in</title>
    <meta charset="UTF-8">
</head>
<body>
    <jsp:include page="../components/header.jsp"/>
    <main>
        <h1>Registrazione:</h1>
        <div>
            <form action="signup" method="post">
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" >
                <br>
                <label for="cognome">Cognome:</label>
                <input type="text" id="cognome" name="cognome" >
                <br>
                <label for="data_nascita">Data di nascita (GG/MM/AAAA):</label>
                <input type="text" id="data_nascita" name="data_nascita" >
                <br>
                <label for="email">Indirizzo email:</label>
                <input type="email" id="email" name="email" >
                <br>
                <label for="telefono">Numero di telefono:</label>
                <input type="tel" id="telefono" name="telefono" >
                <br>
                <label>Tipo di registrazione:</label>
                <input type="radio" id="simpatizzante" name="tipo_registrazione" value="simpatizzante" checked>
                <label for="simpatizzante">Simpatizzante</label>
                <input type="radio" id="aderente" name="tipo_registrazione" value="aderente" >
                <label for="aderente">Aderente</label>
                <br>
                <label for="username">Username:</label>
                <input type="text" id="username" name="username">
                <br>
                <label for="password">Password (8 caratteri, prima lettera dei nomi propri, almeno un numero, un carattere maiuscolo e un carattere tra $, ! e ?):</label>
                <input type="password" id="password" name="password" >
                <br>
                <label for="password_conferma">Conferma password:</label>
                <input type="password" id="password_conferma" name="password_conferma" >
                <br>
                <button type="submit">Registrati</button>
                <button type="reset">Reset</button>
            </form>
        </div>
    </main>
    <jsp:include page="../components/footer.jsp"/>
</body>
</html>
