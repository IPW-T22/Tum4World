<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html lang="it">
<head>
    <title>Tum4World - Login</title>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="/images/favicon.ico">
</head>
<body>
    <jsp:include page="../componenti/header.jsp"/>
    <main>
        <h1>Login</h1>
        <div>
            <form action="signin" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" >
                <br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="hashPassword" >
                <br>
                <button type="submit">Login</button>
                <button type="reset">Reset</button>
                <%
                    if(request.getParameter("error")!=null) {
                        out.print("<p>Errore username o password errata</p>");
                    }
                %>
            </form>
        </div>
    </main>
    <jsp:include page="../componenti/footer.jsp"/>
</body>
</html>
