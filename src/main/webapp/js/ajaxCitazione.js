/* ajaxCitazione.js */
caricaCitazione();

function caricaCitazione() {
    var xhr = new XMLHttpRequest();
    //console.log("aggiornato");
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            //console.log(xhr.responseText);
            //parse the response
            let data = JSON.parse(xhr.responseText);
            //scrivere nella sezione apposita la citazione
            document.getElementById("citazione").innerText = data.testo + " cit. " + data.autore;
        }
    }
    xhr.open('GET', './citazione', true);
    xhr.send(null);
}

setInterval(caricaCitazione, 20*1000);
