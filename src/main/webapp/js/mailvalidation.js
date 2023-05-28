function ValidateEmail(mail)
{
    //check if the email address is valid
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(myForm.emailAddr.value))
    {
        return (true);
    }
    //tell user that the email address is invalid, write to the page without alert
    document.getElementById("email").innerHTML = "<div id = \"errore\"> Indirizzo email invalido</div>";
    return (false);
}
