//check if the field nome is empty
function ValidateName(nome){
    if (nome.value == ""){
        document.getElementById("nome").innerHTML = "<div id = \"errore\"> Campo obbligatorio</div>";
        return (false);
    }
    return (true);
}
//check if the field cognome is empty
function ValidateSurname(cognome){
    if (cognome.value == ""){
        document.getElementById("cognome").innerHTML = "<div id = \"errore\"> Campo obbligatorio</div>";
        return (false);
    }
    return (true);
}
//check if the field email is valid
function ValidateEmail(email){
    //check if the email address is valid
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email.value)){
        return (true);
    }
    //tell user that the email address is invalid, write to the page without alert
    document.getElementById("email").innerHTML = "<div id = \"errore\"> Indirizzo email invalido</div>";
    return (false);
}
//check if the field telefono is empty
function ValidatePhone(telefono){
    if (telefono.value == ""){
        document.getElementById("telefono").innerHTML = "<div id = \"errore\"> Campo obbligatorio</div>";
        return (false);
    }
    return (true);
}

//check if the field password is empty
function ValidatePassword(password){
    //check password length (8 characters), at least one number and one majuscule character and one character between !$?
    if (/^(?=.*[A-Z])(?=.*[0-9])(?=.*[!$?]).{8,}$/.test(password.value)){
        return (true);
    }
}

//check if the field conferma password is empty
function ValidateConfirmPassword(confermaPassword){
    //check if the confirm password is equal to password
    if (confermaPassword.value == document.getElementById("password").value){
        return (true);
    }
    //tell user that the confirm password is invalid, write to the page without alert
    document.getElementById("password_conferma").innerHTML = "<div id = \"errore\"> Le password non coincidono</div>";
    return (false);
}

//when the user click on the button "invia" call the function ValidateForm
function ValidateForm(){
    //get the value of the input text with id "nome"
    var nome = document.getElementById("nome");
    //get the value of the input text with id "cognome"
    var cognome = document.getElementById("cognome");
    //get the value of the input text with id "email"
    var email = document.getElementById("email");
    //get the value of the input text with id "telefono"
    var telefono = document.getElementById("telefono");
    //get the value of the input text with id "password"
    var password = document.getElementById("password");
    //get the value of the input text with id "conferma password"
    var confermaPassword = document.getElementById("conferma_password");
    //if all the input text are valid, send the form
    if (ValidateName(nome) && ValidateSurname(cognome) && ValidateEmail(email) && ValidatePhone(telefono) && ValidatePassword(password) && ValidateConfirmPassword(confermaPassword)){
        return true;//send form
    }
    else {
        event.preventDefault();
        return false;//do not send
    }
}
