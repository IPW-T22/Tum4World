<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<header>
    <h1>Tum4World</h1>
    <div>
        <ul>
            <li><a href="homepage">Home</a></li>
            <li><a href="chisiamo">Chi siamo</a></li>
            <li><a href="attivita">Attività</a></li>
            <li><a href="contatti">Contatti</a></li>
            <li><a href="signup">Sign-up</a></li>
            <li><a href="signin">Login</a></li>
            <%
                HttpSession session = request.getSession(false);
                String id = request.getParameter("id");
                if(session!=null || (id!=null )) //DOVREI CONTROLLARE CHE L'ID È VALIDO
                    out.print("<li><a href=\"logout\">Logout</a></li>");
            %>
        </ul>
    </div>
    <span><p>Citazione: </p></span>
</header>
