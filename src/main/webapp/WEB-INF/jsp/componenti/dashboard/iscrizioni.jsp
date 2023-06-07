<%@ page import="com.github.ipwt22.tum4world.models.Attivita" session="false" %>
<jsp:useBean id="attivita" class="com.github.ipwt22.tum4world.models.Attivitas" scope="request"/>
<script src="${pageContext.request.contextPath}/js/changesub.js"></script>

<section id="iscrizioni">
    <h2>Iscrizioni</h2>
    <% for (int i = 0; i < attivita.getList().size(); i ++ ) {
        Attivita a = attivita.getList().get(i); %>
        <input type="checkbox" id="attivita_<%= i %>"
               <%= a.isIscritto()?"checked":"" %>>
        <label for="attivita_<%= i %>" class="attivita">
            <%= a.getTitolo() %>
            <img src="<%= a.getImmagine() %>"
                 alt="<%= a.getTitolo() %>">
        </label>
        <br/>
    <% } %>
</section>
<span id="changeErr" class="error"></span>