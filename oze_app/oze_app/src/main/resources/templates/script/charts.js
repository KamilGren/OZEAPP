$.ajax({
url: 'heatPumpCharts',
success: function(result) {
var temperatures = JSON.parse(result).temperatures;
var heatingEfficiencies = JSON.parse(result).heatingEfficiencies;

drawLineChart(temperatures, heatingEfficiencies);
}
})


function drawLineChart(temperatures, heatingEfficiencies) {
    Highcharts.chart('container', {
    chart: {
    type: 'line',
    width: 500
    },
    title: {
    text: 'Line chart'
    },
    xAxis: {
    categories: temperatures
    },
    tooltip: {
    formatter: function() {
    return '<strong>' + this.x + ': </strong>' + this.y;
    },
    series: [{
    heatingEfficiencies
    }]
    }),

    }
}