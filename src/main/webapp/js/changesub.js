//ogni volta che cambia lo stato di una delle checkbox, invia una richiesta ajax a "/tum4world/iscrizione" di tipo POST con i parametri "attivita_id" (codice dell'attivita) e "iscrizione" (true o false)
//se la richiesta va a buon fine, aggiorna la pagina
//se la risposta è un errore, annulla il cambiamento di stato della checkbox e informa l'utente
$(document).ready(function() {
    $("input:checkbox").change(function() {
        var attivita_id = $(this).attr("id");
        var iscrizione = $(this).is(":checked");
        $.ajax({
            url: "/tum4world/iscrizione",
            type: "POST",
            data: "attivita_id=" + attivita_id + "&iscrizione=" + iscrizione,
            success: function() {
                location.reload();
            },
            error: function() {
                $(this).prop("checked", !iscrizione);
                document.getElementById("changeErr").innerHTML = "L'operazione è fallita, si prega di riprovare più tardi.";
            }
        });
    });
}
);
