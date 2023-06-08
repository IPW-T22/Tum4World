function visite() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', './contatori', true);
    xhr.responseType = 'json';
    xhr.onreadystatechange = function () {
        console.log(xhr.status);
        console.log(xhr.response);
        //console.log(xhr.responseText);
        if (xhr.status === 200) {
            var visite = xhr.response;
            var arcat = [];
            var arval = [];
            for (let i in visite) {
                arcat[i] = visite[i].nome;
                arval[i] = visite[i].visite;
            }
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