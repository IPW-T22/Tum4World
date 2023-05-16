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
            <%
                if(session==null && (token==null || token.equals("null"))){
                    out.println("<li><a href=\"signup?token="+ token +"\">Sign-up</a></li>");
                    out.println("<li><a href=\"signin?token="+ token +"\">Login</a></li>");
                }
                if(session!=null || (token!=null && !token.equals("null") )) //DOVREI CONTROLLARE CHE L'ID È VALIDO
                    out.print("<li><a href=\"logout?token="+ token +"\">Logout</a></li>");
            %>
        </ul>
    </div>
    <span><p>Citazione: </p></span>
</header>
