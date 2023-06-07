<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html lang="it">
<head>
    <title>Tum4World - Lista attivita</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pubblico/paginaattivita.css">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">
</head>
<body>
    <jsp:include page="../componenti/header.jsp"/>
    <main>
        <div>
            <table>
                <tr>
                    <td>
                        <a href="attivita?nomeAttivita=attivita_1.jsp"><img src="${pageContext.request.contextPath}/images/food1.jpg" alt="Image 1"></a>
                        <p>Aiutaci a combattere la fame </p>
                    </td>
                    <td>
                        <a href="attivita?nomeAttivita=attivita_2.jsp"><img src="${pageContext.request.contextPath}/images/school1.jpg" alt="Image 2"></a>
                        <p>Attività di insegnamento nelle scuole</p>
                    </td>
                    <td>
                        <a href="attivita?nomeAttivita=attivita_3.jsp"><img src="${pageContext.request.contextPath}/images/medicine1.jpg" alt="Image 3"></a>
                        <p>Cura con noi i pazienti più distrutti</p>
                    </td>
                </tr>
            </table>
        </div>
    </main>
    <jsp:include page="../componenti/footer.jsp"/>
</body>
</html>
