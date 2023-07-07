function visite()
{
    var xhr = new XMLHttpRequest();
    var urlOfRequest = "./contatori";
    var urlParams = new URLSearchParams(window.location.search);
    var token = urlParams.get("token");
    if(token!=null){
        urlOfRequest += "?token=" + token;
    }
    console.log("visite: " + urlOfRequest);
    xhr.open('GET', urlOfRequest, true);
    xhr.responseType = 'json';
    xhr.onreadystatechange = function () {
        console.log(xhr.status);
        console.log(xhr.response);
        //console.log(xhr.responseText);
        if (xhr.status === 200) {
            let sumContatore = 0;
            let j = 0;
            var visite = xhr.response;
            var arcat = [];
            var arval = [];
            for (let i in visite) {
                if(isAPage(visite[i].nome)) {
                    arcat[j] = visite[i].nome;
                    arval[j] = visite[i].visite;
                    sumContatore = sumContatore + visite[i].visite;
                    ++j;
                }
            }
            document.getElementById("contatore_totale").innerHTML = "Totale: " + sumContatore;
            /*console.log(data)
            data = JSON.parse(data);
            var cat = data.percorso;
            console.log(cat);*/
            console.log(visite);
            var chart = Highcharts.chart('container_visite', {
                chart: {
                    type: 'histogram'
                },
                title: {
                    text: 'Visite'
                },
                xAxis: {
                    categories: arcat
                },
                yAxis: {
                    title: {
                        text: 'Visite'
                    }
                },
                series: [{
                    data: arval
                }]
            });
        }
    };
    xhr.send();
}

function isAPage(pagina)
{
    if(pagina=="Tum4world" || pagina=="Login" || pagina=="Dashboard" || pagina=="Iscrizione" || pagina=="Homepage" || pagina=="Signup" || pagina=="Registrazioneconfermata" || pagina=="Contatti" || pagina=="Attivita" || pagina=="Chisiamo" || pagina=="Invioconfermato")
        return true;
    return false;
}

async function resetContatori()
{
    await fetch('./contatori',{ //zucchero sintattico delle promise
        method: 'DELETE'
    })
    visite();
}