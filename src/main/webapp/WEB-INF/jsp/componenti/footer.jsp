<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<footer>

    <%
        if(request.getParameter("cookieAccepted")==null)
            out.println("<div id=\"\"> <p>Messaggio Cookie</p> <span><button id=\"decline\">Decline</button> <button id=\"accept\">Accept</button></span> </div>");
    %>

    <div>
        <h4>Contatti</h4>

    </div>
</footer>
