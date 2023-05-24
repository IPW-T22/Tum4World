<%@ page import="com.github.ipwt22.tum4world.helpers.UtenteHelper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/componenti/footer.css">
</head>
<footer>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/cookieScript.js"></script>
    <%
        String cookieAcceptedVal = UtenteHelper.get_value_from_cookie("cookieAccepted", request);
        if(cookieAcceptedVal==null){
    %>
            <jsp:include page="../componenti/cookie_banner.jsp"/>
    <% } %>


    <div id="div_footer">
        <h4>Contatti</h4>
    </div>
</footer>
