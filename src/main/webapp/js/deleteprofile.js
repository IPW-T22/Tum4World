async function eliminaProfilo()
{
    await fetch('/tum4world/logout',{ //zucchero sintattico delle promise
        method: 'DELETE'
    })
    window.location = "/tum4world/homepage";
}