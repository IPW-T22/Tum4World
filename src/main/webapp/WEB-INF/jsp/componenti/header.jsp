<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<header>
    <h1>Tum4World</h1>
    <div>
        <ul>
            <%
                HttpSession session = request.getSession(false);
                String id = request.getParameter("id");
            %>
            <li><a href="homepage?id=<%= id %>">Home</a></li>
            <li><a href="chisiamo?id=<%= id %>">Chi siamo</a></li>
            <li><a href="attivita?id=<%= id %>">Attività</a></li>
            <li><a href="contatti?id=<%= id %>">Contatti</a></li>
            <%
                if(session==null && (id==null || id.equals("null"))){
                    out.println("<li><a href=\"signup?id="+ id +"\">Sign-up</a></li>");
                    out.println("<li><a href=\"signin?id="+ id +"\">Login</a></li>");
                }
                if(session!=null || (id!=null && !id.equals("null") )) //DOVREI CONTROLLARE CHE L'ID È VALIDO
                    out.print("<li><a href=\"logout?id="+ id +"\">Logout</a></li>");
            %>
        </ul>
    </div>
    <span><p>Citazione: </p></span>
</header>
