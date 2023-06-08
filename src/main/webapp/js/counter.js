var xhr = new XMLHttpRequest();
xhr.open('GET', './contatori', true);
xhr.responseType = 'json';
xhr.onload = function () {
    console.log(xhr.status);
    console.log(xhr.response);
    //console.log(xhr.responseText);
    if (xhr.status === 200) {
        var data = xhr.response;
        /*console.log(data)
        data = JSON.parse(data);
        var cat = data.percorso;
        console.log(cat);*/
        console.log(data);
        var chart = Highcharts.chart('container_visite', {
            chart: {
                type: 'histogram'
            },
            title: {
                text: 'Visite'
            },
            xAxis: {
                categories: ['Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio','Agosto','Settembre','Ottobre','Novembre','Dicembre']
            },
            yAxis: {
                title: {
                    text: 'Visite'
                }
            },
            series: [{
                data: data
            }]
        });
    }
};
xhr.send();