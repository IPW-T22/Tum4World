function nascondiTutto()
{
    document.getElementById("dati_personali").style.display = "none";
    document.getElementById("iscrizioni").style.display = "none";
    document.getElementById("elimina_profilo").style.display = "none";
    if(document.getElementById("donazione")!=null)
        document.getElementById("donazione").style.display = "none"; //solo per aderente ma non per simpatizzante
}
function mostraDatiPersonali()
{
    nascondiTutto();
    document.getElementById("dati_personali").style.display = "block";
}

function mostraIscrizioni()
{
    nascondiTutto();
    document.getElementById("iscrizioni").style.display = "block";
}

function mostraEliminaProfilo()
{
    nascondiTutto();
    document.getElementById("elimina_profilo").style.display = "block";
}

function mostraPannelloDonazione()
{
    nascondiTutto();
    document.getElementById("donazione").style.display = "block";
}
