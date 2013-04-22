<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9"><![endif]-->
<!--[if gt IE 8]><!--><html class="no-js"><!--<![endif]-->
<jsp:include page="header.jsp"/>
<script type="text/javascript">
		$(document).ready(function () {
			prettyPrint();

			/* Easy Pie Chart
				================================================== */
			$('#easy-pie-chart').easyPieChart({
				animate: 2000,
				scaleColor: false,
				lineWidth: 12,
				lineCap: 'square',
				size: 100,
				trackColor: '#e5e5e5',
				barColor: '#3da0ea'
			});

			/* Simple Plot Plugin
				================================================== */
			var visitsChartData = [{
				// Visits
				label: 'Visits',
				data: [
					[6, 1300],
					[7, 1600],
					[8, 1900],
					[9, 2100],
					[10, 2500],
					[11, 2200],
					[12, 2000],
					[13, 1950],
					[14, 1900],
					[15, 2000]
				]
			}, {
				// Returning Visits
				label: 'Returning Visits',
				data: [
					[6, 500],
					[7, 600],
					[8, 550],
					[9, 600],
					[10, 800],
					[11, 900],
					[12, 800],
					[13, 850],
					[14, 830],
					[15, 1000]
				],
				filledPoints: true
			}];
			$('#visits-line-chart').simplePlot(visitsChartData, {
				series: {
					points: {
						show: true,
						radius: 5
					},
					lines: {
						show: true
					}
				},
				xaxis: {
					tickDecimals: 2
				},
				yaxis: {
					tickSize: 1000
				}
			}, {
				tooltipText: "y + ' visitors at ' + x + '.00h'"
			});
			$('#visits-bar-chart').simplePlot(visitsChartData, {
				series: {
					bars: {
						show: true,
						barWidth: .9,
						align: 'center'
					}
				},
				xaxis: {
					tickDecimals: 2
				},
				yaxis: {
					tickSize: 1000
				}
			}, {
				tooltipText: "y + ' visitors at ' + x + '.00h'"
			});
			var donutChartData = [{
				label: "Series1",
				data: 50
			}, {
				label: "Series2",
				data: 30
			}, {
				label: "Series3",
				data: 90
			}, {
				label: "Series4",
				data: 70
			}, {
				label: "Series5",
				data: 80
			}, {
				label: "Series6",
				data: 110
			}, {
				label: "Series9",
				data: 90
			}];
			$('#donut-chart').simplePlot(donutChartData, {
				series: {
					pie: {
						show: true,
						radius: 1,
						innerRadius: 0.5,
						label: {
							show: true,
							radius: 3 / 4,
							formatter: function (label, series) {
								return '<div style="font-size:14px;text-	align:center;padding:2px;color:white;">' + 		Math.round(series.percent) + '%</div>';
							},
							background: {
								opacity: 0
							}
						}
					}
				},
			});
		});
	</script>

<body>
			
		<!-- Line Chart example
			================================================== -->
		<section class="row-fluid">
			<h3 class="box-header">
				Line Chart example
			</h3>
			<div class="box">
					<div id="visits-line-chart"></div>
			</div>
		</section>
		<!-- / Line Chart example -->
		
		<!-- Bar Chart example
			================================================== -->
		<section class="row-fluid">
			<h3 class="box-header">
				Bar Chart example
			</h3>
			<div class="box">
					<div id="visits-bar-chart"></div>
			</div>
		</section>
		<!-- / Bar Chart example -->
		
		<!-- Donut Chart Example
			================================================== -->
		<section class="row-fluid">
			<h3 class="box-header">
				Donut Chart Example
			</h3>
			<div class="box">
					<div id="donut-chart"></div>
			</div>
		</section>
		<!-- / Donut Chart Example -->


<jsp:include page="footer.jsp"/>