/* script.js */
function caricaCitazione() {
    fetch('/getcitazioneinjson')
        .then(response => response.json())
        .then(data => {
            const citazioneElement = document.getElementById('citazione');
            citazioneElement.textContent = data.citazione; // Supponendo che il campo del JSON che contiene la citazione si chiami "citazione"
        })
        .catch(error => {
            console.error('Si è verificato un errore durante il recupero della citazione:', error);
        });
}

setInterval(caricaCitazione, 20*1000);

console.log("ciao");