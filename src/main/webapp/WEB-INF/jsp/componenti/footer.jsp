<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/componenti/footer.css">
</head>
<footer>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/cookieScript.js"></script>
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
            <jsp:include page="../componenti/cookie_banner.jsp"/>
    <% } %>


    <div id="div_footer">
        <h4>Contatti</h4>
    </div>
</footer>
