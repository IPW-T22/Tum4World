function ValidateName(nome){
    //console.log("name");
    console.log(nome.value);
    //check if the field nome is empty
    if (nome.value == "" || nome.value == null){
        document.getElementById("nomeErr").innerText = "Campo obbligatorio";
        return (false);
    }
    return (true);
}
//check if the field cognome is empty
function ValidateSurname(cognome){
    //console.log("surname");
    if (cognome.value == "" || cognome.value == null){
        document.getElementById("cognomeErr").innerText = "Campo obbligatorio";
        return (false);
    }
    return (true);
}
//check if the field data_nascita is empty, if it isn't empty check if the age is greater than 18
function ValidateDate(data_nascita){
    //console.log("date");
    console.log(data_nascita.value);
    if (data_nascita.value == "" || data_nascita.value === null){
        document.getElementById("data_nascitaErr").innerText = "Campo obbligatorio";
        return (false);
    }
    else{
        var today = new Date();
        var birthDate = new Date(data_nascita.value);
        var age = today.getFullYear() - birthDate.getFullYear();
        var m = today.getMonth() - birthDate.getMonth();
        if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())){   
            age--;
        }
        if (age < 18){
            document.getElementById("data_nascitaErr").innerText = "Devi avere almeno 18 anni per registrarti";
            return (false);
        }
    }
    return (true);
}
//check if the field email is valid
function ValidateEmail(email){
    console.log("mail");
    //check if the email address is valid
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email.value)){
        return (true);
    }
    if (email.value == ""){
        document.getElementById("emailErr").innerText = "Campo obbligatorio";
    }else{
        //tell user that the email address is invalid, write to the page without alert
        document.getElementById("emailErr").innerText = "Indirizzo email non valido";
    }
    return (false);
}
//check if the field telefono is empty
function ValidatePhone(telefono){
    console.log("phone");
    if (telefono.value == ""){
        document.getElementById("telefonoErr").innerText = "Campo obbligatorio";
        return (false);
    }
    return (true);
}

//check if the field username is empty
function ValidateUsername(username){
    console.log("username");
    if (username.value == ""){
        document.getElementById("usernameErr").innerText = "Campo obbligatorio";
        return (false);
    }
    return (true);
}

//check if the field password is empty
function ValidatePassword(password){
    console.log("psw");
    //check password length (8 characters), at least one number and one majuscule character and one character between !$?
    if (/^(?=.*[A-Z])(?=.*[0-9])(?=.*[!$?]).{8,}$/.test(password.value)){
        return (true);
    }
    else{
        if (password.value == ""){
            document.getElementById("passwordErr").innerText = "Campo obbligatorio";
        }else{
            //tell user that the password is invalid, write to the page without alert
            document.getElementById("passwordErr").innerText = "La password deve contenere 8 caratteri, con almeno un numero, una lettera maiuscola e un carattere tra ! $ ?";
        }
        return (false);
    }
}

//check if the field conferma password is empty
function ValidateConfirmPassword(confermaPassword){
    console.log("repsw");
    //check if the confirm password is equal to password
    if (confermaPassword.value == document.getElementById("password").value){
        return (true);
    }
    //tell user that the confirm password is invalid, write to the page without alert
    document.getElementById("password_confermaErr").innerText = "Le password non coincidono";
    return (false);
}

//when the user click on the button "invia" call the function ValidateForm
function ValidateForm(ev){
    //ev.preventDefault();
    //get the value of the input text with id "nome"
    let nome = document.getElementById("nome");
    //get the value of the input text with id "cognome"
    let cognome = document.getElementById("cognome");
    //get the value of the input text with id "data_nascita"
    let data_nascita = document.getElementById("data_nascita");
    //get the value of the input text with id "email"
    let email = document.getElementById("email");
    //get the value of the input text with id "telefono"
    let telefono = document.getElementById("telefono");
    //get the value of the input text with id "password"
    let password = document.getElementById("password");
    //get the value of the input text with id "conferma password"
    let confermaPassword = document.getElementById("password_conferma");
    let username = document.getElementById("username");
    //controllo che i campi siano tutti validi
    let nomeValido = ValidateName(nome);
    let cognomeValido = ValidateSurname(cognome);
    let data_nascitaValida = ValidateDate(data_nascita);
    let emailValida = ValidateEmail(email);
    let telefonoValido = ValidatePhone(telefono);
    let usernameValido = ValidateUsername(username);
    let passwordValida = ValidatePassword(password);
    let confermaPasswordValida = ValidateConfirmPassword(confermaPassword);
    if (nomeValido){
        document.getElementById("nomeErr").innerText = "";
    }
    if (cognomeValido) {
        document.getElementById("cognomeErr").innerText = "";
    }
    if (data_nascitaValida){
        document.getElementById("data_nascitaErr").innerText = "";
    }
    if (emailValida) {
        document.getElementById("emailErr").innerText = "";
    }
    if (telefonoValido){
        document.getElementById("telefonoErr").innerText = "";
    }
    if (usernameValido){
        document.getElementById("usernameErr").innerText = "";
    }
    if (passwordValida){
        document.getElementById("passwordErr").innerText = "";
    }
    if (confermaPasswordValida){
        document.getElementById("password_confermaErr").innerText = "";
    }
    console.log(nomeValido);
    console.log(cognomeValido);
    console.log(data_nascitaValida);
    console.log(emailValida);
    console.log(telefonoValido);
    console.log(usernameValido);
    console.log(password.value);
    console.log(passwordValida);
    console.log(confermaPassword.value);
    console.log(confermaPasswordValida);
    //if all the input text are valid, send the form
    if (nomeValido && cognomeValido && data_nascitaValida && emailValida && telefonoValido && passwordValida && confermaPasswordValida){
        return true;//send form
    }else{
        ev.preventDefault();
        return false;//do not send
    }
}