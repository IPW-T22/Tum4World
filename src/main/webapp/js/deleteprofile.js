async function eliminaProfilo()
{
    await fetch('./logout',{ //zucchero sintattico delle promise
        method: 'DELETE'
    })
    window.location = "./homepage";
}