<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/privato/basic_amministratore.css">
<section id="donazione" >
    <h2>Donazione</h2>
    <form method="post" action="donazioni">
        <input name="euro" id="euro" type="number">
        <label for="euro">€</label>
        <input type="submit" value="Dona">
    </form>
</section>