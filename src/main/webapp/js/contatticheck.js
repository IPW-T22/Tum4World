// Funzione per controllare la validità dell'indirizzo email
function validaEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
}

// Funzione per controllare la compilazione dei campi
function controllaCampi() {
    // Recupero dei valori dei campi
    const nomeCognome = document.getElementById('nome-cognome').value;
    const email = document.getElementById('email').value;
    const motivoContatto = document.getElementById('motivo-contatto').value;

    // Controllo validità indirizzo email
    if (!validaEmail(email)) {
        alert("Inserisci un indirizzo email valido.");
        return false;
    }

    // Controllo compilazione campi
    if (nomeCognome.trim() === '' || motivoContatto === '') {
        alert("Compila tutti i campi richiesti.");
        return false;
    }

    // Tutti i controlli sono passati, il form può essere inviato
    return true;
}

// Funzione per ripulire tutti i campi del form
function resetCampi() {
    document.getElementById('nome-cognome').value = '';
    document.getElementById('email').value = '';
    document.getElementById('motivo-contatto').value = '';
    document.getElementById('dettagli-richiesta').value = '';
}

// Gestore dell'evento di invio del form
function inviaForm(event) {
    event.preventDefault(); // Evita l'invio del form

    if (controllaCampi()) {
        // Qui puoi inserire il codice per inviare il form al server o eseguire altre azioni
        alert("Form inviato correttamente!");
        resetCampi();
    }
}

// Gestore dell'evento di reset del form
function resetForm(event) {
    event.preventDefault(); // Evita il reset del form di default
    resetCampi();
}

// Aggiunta degli event listener ai pulsanti
document.getElementById('invia').addEventListener('click', inviaForm);
document.getElementById('reset').addEventListener('click', resetForm);
