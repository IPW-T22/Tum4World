var xhr = new XMLHttpRequest();
xhr.open('GET', './donazioni', true);
xhr.responseType = 'json';
xhr.onload = function () {
    if (xhr.status === 200) {
        var data = xhr.response;
        var chart = Highcharts.chart('container_donazioni', {
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
                data: data
            }]
        });
    }
};
xhr.send();
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