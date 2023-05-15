<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html lang="it">
<head>
    <title>Tum4World - Lista attivita</title>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="/images/favicon.ico">
</head>
<body>
    <jsp:include page="../componenti/header.jsp"/>
    <%
        String id = request.getParameter("id");
    %>
    <main>
        <div>
            <table>
                <tr>
                    <td>
                        <a href="attivita?nomeAttivita=attivita_1.jsp&id=<%= id %>"><img src="image1.jpg" alt="Image 1"></a>
                        <p>Description of Image 1</p>
                    </td>
                    <td>
                        <a href="attivita?nomeAttivita=attivita_2.jsp&id=<%= id %>"><img src="image2.jpg" alt="Image 2"></a>
                        <p>Description of Image 2</p>
                    </td>
                    <td>
                        <a href="attivita?nomeAttivita=attivita_3.jsp&id=<%= id %>"><img src="image3.jpg" alt="Image 3"></a>
                        <p>Description of Image 3</p>
                    </td>
                </tr>
            </table>
        </div>
    </main>
    <jsp:include page="../componenti/footer.jsp"/>
</body>
</html>
