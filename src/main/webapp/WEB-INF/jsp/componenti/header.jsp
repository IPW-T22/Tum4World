<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<header>
    <h1>Tum4World</h1>
    <div>
        <ul>
            <%
                HttpSession session = request.getSession(false);
                String token = request.getParameter("token");
            %>
            <li><a href="homepage">Home</a></li>
            <li><a href="chisiamo">Chi siamo</a></li>
            <li><a href="attivita">Attività</a></li>
            <li><a href="contatti">Contatti</a></li>
            <% if(session==null && (token==null || token.equals("null"))){ %>
                <li><a href="signup">Sign-up</a></li>
                <li><a href="login">Login</a></li>
            <% } %>

            <% if (session != null || (token != null && !token.equals("null"))) { //DOVREI CONTROLLARE CHE L'ID È VALIDO %>
                <li><a href="logout">Logout</a></li>
            <% } %>
        </ul>
    </div>
    <span><p>Citazione: </p></span>
</header>
