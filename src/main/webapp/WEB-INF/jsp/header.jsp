<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9"><![endif]-->
<!--[if gt IE 8]><!--><html class="no-js"><!--<![endif]-->
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>
		CloudSole - Database
	</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width">

	<script src="/resources/assets/javascripts/1.3.0/adminflare-demo-init.min.js" type="text/javascript"></script>

	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700" rel="stylesheet" type="text/css">
	<script type="text/javascript">
		// Include Bootstrap stylesheet 
		document.write('<link href="/resources/assets/css/' + DEMO_ADMINFLARE_VERSION + '/' + DEMO_CURRENT_THEME + '/bootstrap.min.css" media="all" rel="stylesheet" type="text/css" id="bootstrap-css">');
		// Include AdminFlare stylesheet 
		document.write('<link href="/resources/assets/css/' + DEMO_ADMINFLARE_VERSION + '/' + DEMO_CURRENT_THEME + '/adminflare.min.css" media="all" rel="stylesheet" type="text/css" id="adminflare-css">');
	</script>
	
	<script src="/resources/assets/javascripts/1.3.0/modernizr-jquery.min.js" type="text/javascript"></script>
	<script src="/resources/assets/javascripts/1.3.0/bootstrap.min.js" type="text/javascript"></script>
	<script src="/resources/assets/javascripts/1.3.0/adminflare.min.js" type="text/javascript"></script>
	
	<style type="text/css">
			/* ======================================================================= */
		/* Server Statistics */
		.well.widget-pie-charts .box {
			margin-bottom: -20px;
		}

		/* ======================================================================= */
		/* Why AdminFlare */
		#why-adminflare ul {
			position: relative;
			padding: 0 10px;
			margin: 0 -10px;
		}

		#why-adminflare ul:nth-child(2n) {
			background: rgba(0, 0, 0, 0.02);
		}

		#why-adminflare li {
			padding: 8px 10px;
			list-style: none;
			font-size: 14px;
			padding-left: 23px;
		}

		#why-adminflare li i {
			color: #666;
			font-size: 14px;
			margin: 3px 0 0 -23px;
			position: absolute;
		}


		/* ======================================================================= */
		/* Supported Browsers */
		#supported-browsers header { color: #666; display: block; font-size: 14px; }
			
		#supported-browsers header strong { font-size: 18px; }

		#supported-browsers .span10 { margin-bottom: -15px; text-align: center; }

		#supported-browsers .span10 div {
			margin-bottom: 15px;
			margin-right: 15px;
			display: inline-block;
			width: 120px;
		}

		#supported-browsers .span10 div:last-child { margin-right: 0; }

		#supported-browsers .span10 img { height: 40px; width: 40px; }

		#supported-browsers .span10 span { line-height: 40px; font-size: 14px; font-weight: 600; }
		
		@media (max-width: 767px) {
			#supported-browsers header { text-align: center; margin-bottom: 20px; }
		}

		/* ======================================================================= */
		/* Status panel */
		.status-example { line-height: 0; position:relative; top: 22px }
		
		.box { padding-bottom: 0; }

		.box > p { margin-bottom: 20px; }

		#popovers li, #tooltips li {
			display: block;
			float: left;
			list-style: none;
			margin-right: 20px;
		}
		
		.adminflare > div { margin-bottom: 20px; }
	</style>

	<script type="text/javascript">
	$(document).ready(function () {
		$('a[rel=tooltip]').tooltip();

		// Easy Pie Charts
		var easyPieChartDefaults = {
			animate: 20000,
			scaleColor: false,
			lineWidth: 12,
			lineCap: 'square',
			size: 100,
			trackColor: '#e5e5e5'
		}
		$('#easy-pie-chart-1').easyPieChart($.extend({}, easyPieChartDefaults, {
			barColor: '#3da0ea'
		}));
		$('#easy-pie-chart-2').easyPieChart($.extend({}, easyPieChartDefaults, {
			barColor: '#e7912a'
		}));
		$('#easy-pie-chart-3').easyPieChart($.extend({}, easyPieChartDefaults, {
			barColor: '#bacf0b'
		}));
		$('#easy-pie-chart-4').easyPieChart($.extend({}, easyPieChartDefaults, {
			barColor: '#4ec9ce'
		}));
		$('#easy-pie-chart-5').easyPieChart($.extend({}, easyPieChartDefaults, {
			barColor: '#ec7337'
		}));
		$('#easy-pie-chart-6').easyPieChart($.extend({}, easyPieChartDefaults, {
			barColor: '#f377ab'
		}));
		// Visits Chart
		var visitsChartData = [{
			// Visits
			label: 'Open Opportunity',
			data: [
				${OpenOppGraph}
			]
		}, {
			// Returning Visits
			label: 'Closed Opportunity',
			data: [
				${ClosedOppGraph}
			],
			filledPoints: true
		}];
		$('#visits-chart').simplePlot(visitsChartData, {
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
				tickDecimals: 1
			},
			yaxis: {
				tickSize: 10
			}
		}, {
			height: 205,
			tooltipText: "y + ' opportunities at ' + x + '.00h'"
		});
		// Comments Tab
		$('.comment-remove').click(function () {
			bootbox.confirm("Are you sure?", function (result) {
				alert("Confirm result: " + result);
			});
			return false;
		});
		// New Users Tab
		$('#tab-users a').tooltip();
	});
		$(document).ready(function () {
			prettyPrint();

			/* Tooltips
				================================================== */
			$('a[rel=tooltip]').tooltip();


			/* Popovers
				================================================== */
			$('a[rel=popover]').popover().click(function () {
				return false
			});


			/* Butons
				================================================== */
			$("#loading-state-btn").click(function () {
				$(this).button('loading');
			});


			/* Bootstrap-colorpicker
				================================================== */
			$("#colorpicker").colorpicker();
			$("#colorpicker-rgb").colorpicker();
			$("#colorpicker-component").colorpicker();


			/* Bootstrap-datepicker
				================================================== */
			$("#datepicker").datepicker();
			$("#datepicker-component").datepicker();
			$("#datepicker-limited").datepicker();


			/* Bootstrap-timepicker
				================================================== */
			$('.timepicker-default').timepicker({
				defaultTime: 'value'
			});

			$('.timepicker-1').timepicker({
				minuteStep: 1,
				template: 'modal',
				showSeconds: true,
				showMeridian: false,
				defaultTime: 'value'
			});


			/* Notifications
				================================================== */
			$('#notify').click(function () {
				$('.top-right').notify({
					message: {
						text: 'Aw yeah, It works!'
					},
					type: 'adminflare'
				}).show()
			});


			/* WYSIWYG-Editor
				================================================== */
			$('#wysihtml5').wysihtml5({
				"stylesheets": []
			});


			/* Form validations
				================================================== */
			$("input,select,textarea", '#validate-form').not("[type=submit]").jqBootstrapValidation();


			/* Styled form elements
				================================================== */
			// Initializing checkboxes
			$('#checkbox-toggle').on('click', function () {
				$('#myCheckbox').checkbox('toggle');
			});

			$('#checkbox-disable').on('click', function () {
				$('#myCheckbox').checkbox('disable');
			});

			$('#checkbox-enable').on('click', function () {
				$('#myCheckbox').checkbox('enable');
			});

			// Initializing comboboxes
			$('#myCombobox').on('changed', function (evt, data) {
				console.log(data);
			});
	
			$('#combobox-logItem').on('click', function () {
				console.log($('#myCombobox').combobox('selectedItem'));
			});
	
			$('#combobox-setByIndex').on('click', function () {
				$('#myCombobox').combobox('selectByIndex', '1');
			});
	
			$('#combobox-setByText').on('click', function () {
				$('#myCombobox').combobox('selectByText', 'Item Three');
			});
	
			$('#combobox-setBySelector').on('click', function () {
				$('#myCombobox').combobox('selectBySelector', 'li[data-fizz=buzz]');
			});
	
			$('#combobox-setByValue').on('click', function () {
				$('#myCombobox').combobox('selectByValue', '1');
			});
	
			$('#combobox-enable').on('click', function () {
				$('#myCombobox').combobox('enable');
			});
	
			$('#combobox-disable').on('click', function () {
				$('#myCombobox').combobox('disable');
			});


			// Initializing search input
			$('#MySearch').on('searched', function (e, text) {
				alert('Searched: ' + text);
			});

			$('#search-enable').click(function () {
				$('#MySearch').search('enable');
			});

			$('#search-disable').click(function () {
				$('#MySearch').search('disable');
			});

			// Initializing spinner
			$('#MySpinner').spinner();
			$('#spinner-enable').click(function () {
				$('#MySpinner').spinner('enable');
			});

			$('#spinner-disable').click(function () {
				$('#MySpinner').spinner('disable');
			});

			$('#spinner-log').click(function () {
				console.log("Spinner value: ", $('#MySpinner').spinner('value'));
			});

			// Initializing radio
			$('#radio-disable').on('click', function () {
				$('#myRadio').radio('disable');
			});

			$('#radio-enable').on('click', function () {
				$('#myRadio').radio('enable');
			});

			// Initializing select
			$('#mySelect').on('changed', function (evt, data) {
				console.log(data);
			});

			$('#select-logItem').on('click', function () {
				console.log($('#mySelect').select('selectedItem'));
			});

			$('#select-setByIndex').on('click', function () {
				$('#mySelect').select('selectByIndex', '1');
			});

			$('#select-setByText').on('click', function () {
				$('#mySelect').select('selectByText', 'Item Three');
			});

			$('#select-setBySelector').on('click', function () {
				$('#mySelect').select('selectBySelector', 'li[data-fizz=buzz]');
			});

			$('#select-setByValue').on('click', function () {
				$('#mySelect').select('selectByValue', '1');
			});

			$('#select-enable').on('click', function () {
				$('#mySelect').select('enable');
			});

			$('#select-disable').on('click', function () {
				$('#mySelect').select('disable');
			});


			/* Datagrid
				================================================== */
			var dataSource = new StaticDataSource({
				columns: [
					{
						property: 'toponymName',
						label: 'Name',
						sortable: true
					},
					{
						property: 'countrycode',
						label: 'Country',
						sortable: true
					},
					{
						property: 'population',
						label: 'Population',
						sortable: true
					},
					{
						property: 'fcodeName',
						label: 'Type',
						sortable: true
					}
				],
				data: sampleData.geonames,
				delay: 250
			});
	
			$('#MyGrid').datagrid({
				dataSource: dataSource,
				stretchHeight: true
			});
	
			$('#datagrid-reload').on('click', function () {
				$('#MyGrid').datagrid('reload');
			});


			/* Wizard
				================================================== */
			$('#myWizard').on('change', function (e, data) {
				console.log('change');
				if (data.step === 3 && data.direction === 'next') {
					// return e.preventDefault();
				}
			});

			$('#myWizard').on('changed', function (e, data) {
				console.log('changed');
			});

			$('#myWizard').on('finished', function (e, data) {
				console.log('finished');
			});

			$('#wizard-prev').on('click', function () {
				$('#myWizard').wizard('previous');
			});

			$('#wizard-next').on('click', function () {
				$('#myWizard').wizard('next', 'foo');
			});

			$('#wizard-logItem').on('click', function () {
				var item = $('#myWizard').wizard('selectedItem');
				console.log(item.step);
			});
			

			/* Toggle buttons
				================================================== */
			$('#normal-toggle-button').toggles({on: true});
			$('#text-toggle-button').toggles({text:{on:'YES',off:'NO'}});

			
			/* Auto-resizing textarea
				================================================== */
			$("#autoresize").autosize();


			/* Inline editable
				================================================== */
			
			//enable / disable
			$('#enable').click(function () {
				$('#user .editable').editable('toggleDisabled');
			});

			//editables 
			$('#username').editable({
				type: 'text',
				pk: 1,
				name: 'username',
				title: 'Enter username'
			});

			$('#firstname').editable({
				validate: function (value) {
					if ($.trim(value) == '') return 'This field is required';
				}
			});

			$('#lastname').editable();

			$('#sex').editable({
				prepend: "not selected",
				source: [{
					value: 1,
					text: 'Male'
				}, {
					value: 2,
					text: 'Female'
				}],
				display: function (value, sourceData) {
					var colors = {
						"": "gray",
						1: "green",
						2: "blue"
					},
					elem = $.grep(sourceData, function (o) {
						return o.value == value;
					});
					if (elem.length) {
						$(this).text(elem[0].text).css("color", colors[value]);
					}
					else {
						$(this).empty();
					}
				}
			});

			$('#status').editable();
			$('#dob').editable();

			$('#comments').editable({
				showbuttons: true
			});

			$('#note').editable();

			$('#pencil').click(function (e) {
				e.stopPropagation();
				e.preventDefault();
				$('#note').editable('toggle');
			});

			$('#fruits').editable({
				pk: 1,
				limit: 3,
				source: [{
					value: 1,
					text: 'banana'
				}, {
					value: 2,
					text: 'peach'
				}, {
					value: 3,
					text: 'apple'
				}, {
					value: 4,
					text: 'watermelon'
				}, {
					value: 5,
					text: 'orange'
				}]
			});

			$('#address').editable({
				value: {
					city: "Moscow",
					street: "Lenina",
					building: "12"
				},
				validate: function (value) {
					if (value.city == '') return 'city is required!';
				},
				display: function (value) {
					if (!value) {
						$(this).empty();
						return;
					}
					var html = '<b>' + $('<div>').text(value.city).html() + '</b>, ' + $('<div>').text(value.street).html		() + ' st., bld. ' + $('<div>').text(value.building).html();
					$(this).html(html);
				}
			});


			/* Dialog boxes
				================================================== */
			$('#bootbox-alert').click(function () {
				bootbox.alert("Hello world!", function () {
					alert('Hello world callback');
				});
			});

			$('#bootbox-confirm').click(function () {
				bootbox.confirm("Are you sure?", function (result) {
					alert("Confirm result: " + result);
				});
			});

			$('#bootbox-prompt').click(function () {
				bootbox.prompt("What is your name?", function (result) {
					if (result === null) {
						alert("Prompt dismissed");
					}
					else {
						alert("Hi, " + result + "!");
					}
				});
			});

			$('#bootbox-custom').click(function () {
				bootbox.dialog("I am a custom dialog", [{
					"label": "Success!",
					"class": "btn-green",
					"callback": function () {
						alert("great success");
					}
				}, {
					"label": "Danger!",
					"class": "btn-orange",
					"callback": function () {
						alert("uh oh, look out!");
					}
				}, {
					"label": "Click ME!",
					"class": "btn-primary",
					"callback": function () {
						alert("Primary button");
					}
				}, {
					"label": "Just a button..."
				}]);
			});


			/* Clickovers
				================================================== */
			$('[rel="clickover"]').clickover();

			$('#auto-close-co').clickover({
				auto_close: 15 * 1000
			});

			$('#no-global-co').clickover({
				global_close: false
			});

			$('#shown-co').clickover({
				onShown: function () {
					alert("Hello from clickover");
				}
			});

			$('#no-esc').clickover({
				placement: 'top',
				esc_close: 0
			});
		});
	</script>
	
</head>
<body>
	<!-- Main navigation bar
		================================================== -->
	<header class="navbar navbar-fixed-top" id="main-navbar">
		<div class="navbar-inner">
			<div class="container">
				<a class="logo" href="#"><img alt="Af_logo" src="/resources/assets/images/af-logo.png"></a>
				
				<a class="btn nav-button collapsed" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-reorder"></span>
				</a>

				<div class="nav-collapse collapse">
					<ul class="nav">
						<li><a href="#">Home</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">More<i class=" icon-caret-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="/about">About</a></li>
								<li><a href="/email">Email</a></li>
							</ul>
						</li>
						<li class="divider-vertical"></li>
					</ul>
					<form class="navbar-search pull-left" method="POST" action="/db/search">
						<input type="text" name="seachquery" class="search-query" placeholder="Search" style="width: 120px">
					</form>
					<ul class="nav pull-right">
						<li class="separator"></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle usermenu" data-toggle="dropdown">
								<img alt="Avatar" src="/resources/assets/images/avatar.png">
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Profile</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="index.html">Sign In</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<!-- / Main navigation bar -->
	
	<!-- Left navigation panel
		================================================== -->
	<nav id="left-panel">
		<div id="left-panel-content">
			<ul>
				<li>
					<a href="/dashboard"><span class="icon-dashboard"></span>Dashboard</a>
				</li>	
				<li>
					<a href="/db"><span class="icon-th-large"></span>Table</a>
				</li>
				<li>
					<a href="/api"><span class="icon-reorder"></span>API</a>
				</li>
				<li>
					<a href="/db/query"><span class="icon-edit"></span>Query</a>
				</li>
				
				<li>
					<a href="/quartz"><span class="icon-reorder"></span>Quartz</a>
				</li>
				
				<li>
					<a href="/file"><span class="icon-file-alt"></span>Files</a>
				</li>
				<li>
					<a href="/dbconf"><span class="icon-cog"></span>Database</a> 
				</li>	
			</ul>
		</div>
		<div class="icon-caret-down"></div>
		<div class="icon-caret-up"></div>
	</nav>   