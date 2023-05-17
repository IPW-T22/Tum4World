<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html lang="it">
<head>
    <title>Tum4World - Login</title>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="/images/favicon.ico">
    <link rel="stylesheet" href="CSS/pubblico/login.css">
</head>
<body>
    <jsp:include page="../componenti/header.jsp"/>
    <main>
        <h1>Login</h1>
        <div>
            <form action="login" method="post">
                <span>
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" >
                </span>
                <br>
                <span>
                    <label for="password">Password:</label>
                    <br>
                    <input type="password" id="password" name="hashPassword" >
                </span>
                <br>
                <span>
                    <button type="submit">Login</button>
                    <br>
                    <button type="reset">Reset</button>
                </span>
                <%
                    if(request.getParameter("error")!=null) {
                        out.print("<p>T22: Errore username o password errata</p>");
                    }
                %>
            </form>
        </div>
    </main>
    <jsp:include page="../componenti/footer.jsp"/>
</body>
</html>
