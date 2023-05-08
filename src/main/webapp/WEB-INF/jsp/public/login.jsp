<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html lang="it">
<head>
    <title>Tum4World - Login</title>
    <meta charset="UTF-8">
</head>
<body>
    <jsp:include page="../components/header.jsp"/>
    <main>
        <h1>Login</h1>
        <div>
            <form action="signin" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" >
                <br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" >
                <br>
                <button type="submit">Login</button>
                <button type="reset">Reset</button>
            </form>
        </div>
    </main>
    <jsp:include page="../components/footer.jsp"/>
</body>
</html>
