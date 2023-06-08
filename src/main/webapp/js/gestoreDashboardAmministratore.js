function nascondiTutto()
{
    document.getElementById("utenti_registrati").style.display = "none";
    document.getElementById("simpatizzanti").style.display = "none";
    document.getElementById("aderenti").style.display = "none";
    document.getElementById("visite").style.display = "none";
    document.getElementById("donazioni").style.display = "none";
}
function mostraUtentiRegistrati()
{
    nascondiTutto();
    document.getElementById("utenti_registrati").style.display = "block";
}

function mostraSimpatizzanti()
{
    nascondiTutto();
    document.getElementById("simpatizzanti").style.display = "block";
}

function mostraAderenti()
{
    nascondiTutto();
    document.getElementById("aderenti").style.display = "block";
}

function mostraVisite()
{
    nascondiTutto();
    document.getElementById("visite").style.display = "block";
    visite();
}

function mostraDonazioni()
{
    nascondiTutto();
    document.getElementById("donazioni").style.display = "block";
    donazioni();
}