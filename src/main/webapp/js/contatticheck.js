//write a function that check that the input text with id "nome" isn't empty
function ValidateName(nome){
    if (nome.value == "")
    {
        //console.log("no name");
        //document.getElementById("nomeErr").innerText = "Campo obbligatorio";
        return (false);
    }
    return (true);
}

//write a function that check that the input text with id "cognome" isn't empty
function ValidateSurname(cognome){
    if (cognome.value == "")
    {
        //document.getElementById("cognomeErr").innerText = "Campo obbligatorio";
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
            //document.getElementById("emailErr").innerText = "Campo obbligatorio";
            return (false);
        }
    }
    //tell user that the email address is invalid, write to the page without alert
    document.getElementById("emailErr").innerText = "Indirizzo email invalido";
    return (false);
}

//check if the select with id "motivo_contatto" is valid
function ValidateSelect(){
    var motivo_contatto = document.getElementById("motivo_contatto");
    if (motivo_contatto.value == "")
    {
        //document.getElementById("selectErr").innerHTML = "Selezionare un motivo";
        return (false);
    }
    return (true);
}

//when the user click on the button "invia" call the function ValidateForm
function ValidateForm(){
    console.log("starting validation");
    //get the value of the input text with id "nome"
    var nome = document.getElementById("nome");
    //get the value of the input text with id "cognome"
    var cognome = document.getElementById("cognome");
    //get the value of the input text with id "email"
    var email = document.getElementById("email");
    //get the value of the select with id "motivo_contatto"
    var select = document.getElementById("motivo_contatto");
    var nomebool = ValidateName(nome);
    var cognomebool = ValidateSurname(cognome);
    var emailbool = ValidateEmail(email);
    var selectbool = ValidateSelect();
    if (nomebool){
        document.getElementById("nomeErr").innerText = "";
    }
    if (cognomebool){
        document.getElementById("cognomeErr").innerText = "";
    }
    if (emailbool){
        document.getElementById("emailErr").innerText = "";
    }
    if (selectbool){
        document.getElementById("selectErr").innerText = "";
    }
    //if all the input text are valid, send the form
    if (nomebool && cognomebool && emailbool && selectbool)
    {
        console.log("true");
        return true;//send form
    }
    else {
        console.log("false");
        if (!nomebool)
        {
            //tell user that the name is invalid, write to the page without alert
            document.getElementById("nomeErr").innerText = "Campo obbligatorio";
        }
        if (!cognomebool)
        {
            //tell user that the surname is invalid, write to the page without alert
            document.getElementById("cognomeErr").innerText = "Campo obbligatorio";
        }
        if (!emailbool)
        {
            //tell user that the email address is invalid, write to the page without alert
            document.getElementById("emailErr").innerText = "Indirizzo email invalido";
        }
        if (!selectbool)
        {
            //tell user that the select is invalid, write to the page without alert
            document.getElementById("selectErr").innerHTML = "Selezionare un motivo";
        }
        //event.preventDefault();
        return false;//do not send
    }
}
//when the users submit the form call the function ValidateForm
/*document.getElementById("invia").addEventListener("click", ValidateForm);*/