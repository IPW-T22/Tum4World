var obj = JSON.parse("${pageContext.request.contextPath}");

document.addEventListener('DOMContentLoaded', function () {
    const chart = Highcharts.chart('container_donazioni', {
        chart: {
            type: 'histogram'
        },
        title: {
            text: 'Donazioni per mese'
        },
        xAxis: {
            categories: ['Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio', 'Settembre', 'Ottobre', 'Novembre', 'Dicembre']
        },
        yAxis: {
            title: {
                text: 'Euro'
            }
        },
        series: [

        ]
    });
});