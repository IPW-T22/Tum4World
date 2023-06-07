function EliminaProfilo(){
    var r = confirm("Sei sicuro di voler eliminare il tuo profilo?");
    if (r == true) {
        $.ajax({
            url: "/tum4world/logout",
            type: "DELETE",
            success: function (data) {
                window.location.href = "login.jsp";
            },
            error: function (xhr, status, error) {
                document.getElementById("elimina_profilo_error").innerText = xhr.responseText;
            }
        });
    }
}