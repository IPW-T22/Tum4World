var xhr = new XMLHttpRequest();
xhr.open('GET', '/tum4world/contatori', true);
xhr.responseType = 'json';
xhr.onload = function () {
    if (xhr.status === 200) {
        var data = xhr.response;
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

/*document.addEventListener('DOMContentLoaded', function () {
    const chart = Highcharts.chart('container_visite', {
        chart: {
            type: 'histogram'
        },
        title: {
            text: 'Fruit Consumption'
        },
        xAxis: {
            categories: ['Apples', 'Bananas', 'Oranges']
        },
        yAxis: {
            title: {
                text: 'Fruit eaten'
            }
        },
        series: [{
            name: 'Jane',
            data: [5, 7, 3]
        }]
    });
});*/