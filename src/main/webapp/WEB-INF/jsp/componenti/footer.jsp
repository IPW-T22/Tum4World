<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<footer>
    <script type="text/javascript"> <%@ include file="../../../js/cookieScript.js" %> </script>
    <%
        String cookieAcceptedVal = null;
        Cookie[] cookies =  request.getCookies();
        if(cookies!=null && cookies.length!=0)
            for(Cookie c : cookies){
                String nameCookie = c.getName();
                if(nameCookie.equals("cookieAccepted"))
                    cookieAcceptedVal = c.getValue();
            }
        if(cookieAcceptedVal==null){
    %>
            <%@ include file="cookie_banner.html" %>
    <% } %>


    <div>
        <br>
        <h4>Contatti</h4>

    </div>
</footer>
