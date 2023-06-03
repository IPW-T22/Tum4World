//check if the field nome is empty
function ValidateName(nome){
    console.log("name");
    if (nome.value == ""){
        document.getElementById("nomeErr").innerText = "Campo obbligatorio";
        return (false);
    }
    return (true);
}
//check if the field cognome is empty
function ValidateSurname(cognome){
    console.log("surname");
    if (cognome.value == ""){
        document.getElementById("cognomeErr").innerText = "Campo obbligatorio";
        return (false);
    }
    return (true);
}
//check if the field data_nascita is empty, if it isn't empty check if the age is greater than 18
function ValidateDate(data_nascita){
    console.log("date");
    if (data_nascita.value == "" || data_nascita.value == null){
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
function ValidateForm(){
    //get the value of the input text with id "nome"
    var nome = document.getElementById("nome");
    //get the value of the input text with id "cognome"
    var cognome = document.getElementById("cognome");
    //get the value of the input text with id "data_nascita"
    var data_nascita = document.getElementById("data_nascita");
    //get the value of the input text with id "email"
    var email = document.getElementById("email");
    //get the value of the input text with id "telefono"
    var telefono = document.getElementById("telefono");
    //get the value of the input text with id "password"
    var password = document.getElementById("password");
    //get the value of the input text with id "conferma password"
    var confermaPassword = document.getElementById("conferma_password");
    //for each field, create a variable that contains the result of the validation
    var nomeValido = ValidateName(nome);
    var cognomeValido = ValidateSurname(cognome);
    var data_nascitaValida = ValidateDate(data_nascita);
    var emailValida = ValidateEmail(email);
    var telefonoValido = ValidatePhone(telefono);
    var passwordValida = ValidatePassword(password);
    var confermaPasswordValida = ValidateConfirmPassword(confermaPassword);
    //if all the input text are valid, send the form
    if (nomeValido && cognomeValido && data_nascitaValida && emailValida && telefonoValido && passwordValida && confermaPasswordValida){
        return true;//send form
    }else{
        event.preventDefault();
        return false;//do not send
    }
}
