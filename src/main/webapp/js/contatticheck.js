//write a function that check that the input text with id "nome" isn't empty
function ValidateName(nome){
    if (nome.value == "")
    {
        document.getElementById("nome").innerHTML = "<div id = \"errore\"> Campo obbligatorio</div>";
        return (false);
    }
    return (true);
}

//write a function that check that the input text with id "cognome" isn't empty
function ValidateSurname(cognome){
    if (cognome.value == "")
    {
        document.getElementById("cognome").innerHTML = "<div id = \"errore\"> Campo obbligatorio</div>";
        return (false);
    }
    return (true);
}

//write a function that check that the input text with id "email" is valid
function ValidateEmail(email){
    //check if the email address is valid
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email.value))
    {
        return (true);
    }
    else{
        if (email.value == "")
        {
            //tell user that the email address is empty, write to the page without alert
            document.getElementById("email").innerHTML = "<div id = \"errore\"> Campo obbligatorio</div>";
            return (false);
        }
    }
    //tell user that the email address is invalid, write to the page without alert
    document.getElementById("email").innerHTML = "<div id = \"errore\"> Indirizzo email invalido</div>";
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
    //if all the input text are valid, send the form
    if (ValidateName(nome) && ValidateSurname(cognome) && ValidateEmail(email))
    {
        return true;//send form
    }
    else {
        event.preventDefault();
        return false;//do not send
    }
}
//when the users submit the form call the function ValidateForm
document.getElementById("invia").addEventListener("click", ValidateForm);