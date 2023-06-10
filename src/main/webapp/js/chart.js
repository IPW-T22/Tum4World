function donazioni() {
    var xhlr = new XMLHttpRequest();
    var urlOfRequest = "./donazioni";
    var urlParams = new URLSearchParams(window.location.search);
    var token = urlParams.get("token");
    if(token!=null){
        urlOfRequest += "?token=" + token;
    }
    console.log("donazioni: " + urlOfRequest);
    xhlr.open('GET', urlOfRequest, true);
    xhlr.responseType = 'json';
    xhlr.onload = function () {
        if (xhlr.status === 200) {
            var data = xhlr.response;
            var chart = Highcharts.chart('container_donazioni', {
                chart: {
                    type: 'histogram'
                },
                title: {
                    text: 'Donazioni'
                },
                xAxis: {
                    categories: ['Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio', 'Agosto', 'Settembre', 'Ottobre', 'Novembre', 'Dicembre']
                },
                yAxis: {
                    title: {
                        text: 'Euro'
                    }
                },
                series: [{
                    data: data
                }]
            });
        }
    };
    xhlr.send();
}
/*
document.addEventListener('DOMContentLoaded', function () {
    const chart = Highcharts.chart('container_donazioni', {
        chart: {
            type: 'histogram'
        },
        title: {
            text: 'Donazioni'
        },
        xAxis: {
            categories: ['Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio','Agosto','Settembre','Ottobre','Novembre','Dicembre']
        },
        yAxis: {
            title: {
                text: 'Euro'
            }
        },
        series: [{
            name: 'Jane',
            data: [5, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        }]
    });
});*/