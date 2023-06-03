/* script.js */
caricaCitazione();

function caricaCitazione() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            //console.log(xhr.responseText);
            //parse the response
            let data = JSON.parse(xhr.responseText);
            //scrivere nella sezione apposita la citazione
            document.getElementById("citazione").innerText = data.testo + " cit. " + data.autore;
        }
    }
    xhr.open('GET', '/tum4world/citazione', true);
    xhr.send(null);
}

setInterval(caricaCitazione, 20*1000);

//console.log("ciao");