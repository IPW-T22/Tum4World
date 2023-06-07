
//ogni volta che cambia lo stato di una delle checkbox, invia una richiesta ajax a "/tum4world/iscrizione" di tipo POST con i parametri "attivita_id" (codice dell'attivita) e "iscrizione" (true o false)
//se la richiesta va a buon fine, aggiorna la pagina
//se la risposta è un errore, annulla il cambiamento di stato della checkbox e informa l'utente
function modificaIscrizione(id) {
    var attivita_id = "attivita_" + id;
    var iscrizione = document.getElementById(attivita_id).checked;
    console.log(attivita_id + " " + iscrizione);
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                console.log("ISCRIZIONE CAMBIATA CON SUCCESSO");
            }
            else {
                console.log("ERRORE NEL CAMBIO DELL'ISCRIZIONE");
                document.getElementById("changeErr").innerHTML = "L'operazione è fallita, si prega di riprovare più tardi.";
            }
        }
    }
    xhr.open("POST", "/tum4world/iscrizione", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    var data = "attivita_id=" + id + "&iscrizione=" + iscrizione;
    console.log("data: "+data);
    xhr.send(data);
}