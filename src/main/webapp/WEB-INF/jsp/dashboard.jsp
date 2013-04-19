<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9"><![endif]-->
<!--[if gt IE 8]><!--><html class="no-js"><!--<![endif]-->
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>
		AdminFlare - Dashboard
	</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width">

	<script src="/resources/assets/javascripts/1.2.1/adminflare-demo-init.min.js" type="text/javascript"></script>

	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700" rel="stylesheet" type="text/css">
	<script type="text/javascript">
		// Include Bootstrap stylesheet 
		document.write('<link href="/resources/assets/css/' + DEMO_ADMINFLARE_VERSION + '/' + DEMO_CURRENT_THEME + '/bootstrap.min.css" media="all" rel="stylesheet" type="text/css" id="bootstrap-css">');
		// Include AdminFlare stylesheet 
		document.write('<link href="/resources/assets/css/' + DEMO_ADMINFLARE_VERSION + '/' + DEMO_CURRENT_THEME + '/adminflare.min.css" media="all" rel="stylesheet" type="text/css" id="adminflare-css">');
	</script>
	
	<script src="/resources/assets/javascripts/1.2.1/modernizr-jquery.min.js" type="text/javascript"></script>
	<script src="/resources/assets/javascripts/1.2.1/adminflare-demo.min.js" type="text/javascript"></script>
	<script src="/resources/assets/javascripts/1.2.1/bootstrap.min.js" type="text/javascript"></script>
	<script src="/resources/assets/javascripts/1.2.1/adminflare.min.js" type="text/javascript"></script>

	<style type="text/css">
		/* ======================================================================= */
		/* Server Statistics */
		.well.widget-pie-charts .box {
			margin-bottom: -40px;
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
	</style>
	
	<script type="text/javascript">
		$(document).ready(function () {
			$('a[rel=tooltip]').tooltip();

			// Easy Pie Charts
			var easyPieChartDefaults = {
				animate: 2000,
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
					tickDecimals: 2
				},
				yaxis: {
					tickSize: 1000
				}
			}, {
				height: 205,
				tooltipText: "y + ' visitors at ' + x + '.00h'"
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
	</script>
</head>
<body>
<script type="text/javascript">demoSetBodyLayout();</script>
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
						<li class="active"><a href="#">Home</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <i class=" icon-caret-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li class="nav-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul>
						</li>
						<li class="divider-vertical"></li>
					</ul>
					<form class="navbar-search pull-left" action="" _lpchecked="1">
						<input type="text" class="search-query" placeholder="Search" style="width: 120px">
					</form>
					<ul class="nav pull-right">
						<li>
							<ul class="messages">
								<li>
									<a href="#"><i class="icon-warning-sign"></i> 2<span class="		responsive-text"> alerts</span></a>
								</li>
								<li>
									<a href="#"><i class="icon-envelope"></i> 25<span class="		responsive-text"> new messages</span></a>
								</li>
							</ul>
						</li>
						<li class="separator"></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle usermenu" data-toggle="dropdown">
								<img alt="Avatar" src="/resources/assets/images/avatar.png">
								<span>&nbsp;&nbsp;Admin</span>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Profile</a>
								</li>
								<li>
									<a href="#">Settings</a>
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
				<li class="active">
					<a href="dashboard.html"><span class="icon-dashboard"></span>Dashboard</a>
				</li>
				<li>
					<a href="layout.html"><span class="icon-th-large"></span>Layout</a>
				</li>
				<li>
					<a href="typography.html"><span class="icon-font"></span>Typography</a>
				</li>
				<li>
					<a href="forms.html"><span class="icon-edit"></span>Forms</a>
				</li>
				<li>
					<a href="tables.html"><span class="icon-table"></span>Tables</a>
				</li>
				
				<li>
					<a href="components.html"><span class="icon-inbox"></span>Components</a>
				</li>
				<li>
					<a href="javascript.html"><span class="icon-cog"></span>JavaScript</a>
				</li>
				<li class="lp-dropdown">
					<a href="#" class="lp-dropdown-toggle" id="extras-dropdown"><span class="icon-reorder"></span>Extras</a>
					<ul class="lp-dropdown-menu" data-dropdown-owner="extras-dropdown">
						<li>
							<a tabindex="-1" href="extras-icons.html"><span class="icon-coffee"></span>Icons</a>
						</li>
						<li>
							<a tabindex="-1" href="extras-charts.html"><span class="icon-bar-chart"></span>Charts</a>
						</li>
						<li>
							<a tabindex="-1" href="extras-widgets.html"><span class="icon-star"></span>Widgets</a>
						</li>
					</ul>
				</li>
				<li class="lp-dropdown">
					<a href="#" class="lp-dropdown-toggle" id="pages-dropdown"><span class="icon-file-alt"></span>Pages</a>
					<ul class="lp-dropdown-menu simple" data-dropdown-owner="pages-dropdown">
						<li>
							<a tabindex="-1" href="index.html"><i class="icon-signin"></i>&nbsp;&nbsp;Sign In</a>
						</li>
						<li>
							<a tabindex="-1" href="pages-signup.html"><i class="icon-check"></i>&nbsp;&nbsp;Sign Up</a>
						</li>
						<li>
							<a tabindex="-1" href="pages-messages.html"><i class="icon-envelope-alt"></i>&nbsp;&nbsp;Messages</a>
						</li>
						<li>
							<a tabindex="-1" href="pages-stream.html"><i class="icon-leaf"></i>&nbsp;&nbsp;Stream</a>
						</li>
						<li>
							<a tabindex="-1" href="pages-pricing.html"><i class="icon-money"></i>&nbsp;&nbsp;Pricing</a>
						</li>
						<li>
							<a tabindex="-1" href="pages-invoice.html"><i class="icon-pencil"></i>&nbsp;&nbsp;Invoice</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="icon-caret-down"></div>
		<div class="icon-caret-up"></div>
	</nav>
	<!-- / Left navigation panel -->
	
	<!-- Page content
		================================================== -->
	<section class="container">

		<!-- Server statistics
			================================================== -->
		<section class="well row-fluid widget-pie-charts">
			<h3 class="box-header">
				Server statictics
			</h3>
			<div class="box no-border non-collapsible">
				
				<div class="span2 pie-chart">
					<div id="easy-pie-chart-1" data-percent="58">
						58%
					</div>
					<div class="caption">
						New Visits
					</div>
				</div>
				
				<div class="span2 pie-chart">
					<div id="easy-pie-chart-2" data-percent="43">
						43%
					</div>
					<div class="caption">
						Bounce Rate
					</div>
				</div>

				<div class="span2 pie-chart">
					<div id="easy-pie-chart-3" data-percent="91">
						91%
					</div>
					<div class="caption">
						Server Load
					</div>
				</div>

				<div class="span2 pie-chart">
					<div id="easy-pie-chart-4" data-percent="82">
						752MB
					</div>
					<div class="caption">
						Used RAM
					</div>
				</div>

				<div class="span2 pie-chart">
					<div id="easy-pie-chart-5" data-percent="35">
						35%
					</div>
					<div class="caption">
						Processor Load
					</div>
				</div>

				<div class="span2 pie-chart">
					<div id="easy-pie-chart-6" data-percent="77">
						1.5TB
					</div>
					<div class="caption">
						Bandwidth
					</div>
				</div>
			</div>
		</section>
		<!-- / Server statistics -->

		<!-- ================================================== -->
		<section class="row-fluid">
		
			<!-- Daily visits chart
				================================================== -->
			<div class="span8">
				<h3 class="box-header">
					<i class="icon-home"></i>
					Daily visits chart
				</h3>

				<div class="box">
					<div id="visits-chart"></div>
				</div>
			</div>
			<!-- / Daily visits chart -->
			
			<!-- Daily statistics
				================================================== -->
			<div id="counters" class="span4">
				<h3 class="box-header">
					<i class="icon-signal"></i>
					Daily statistics
				</h3>
				<div class="box no-border no-padding widget-statistics">
				
					<div class="rounded-borders">
						<div class="counter small">
							<span>
							897
							</span>
						</div>
						<div class="counter-label">
							Visits Today
						</div>
					</div>
					
					<div class="rounded-borders">
						<div class="counter small">
							<span>
							563
							</span>
						</div>
						<div class="counter-label">
							Unique Visits
						</div>
					</div>
					
					<div class="rounded-borders">
						<div class="counter small">
							<span>
							65
							</span>
						</div>
						<div class="counter-label">
							Posts
						</div>
					</div>
					
					<div class="rounded-borders">
						<div class="counter small">
							<span>
							865
							</span>
						</div>
						<div class="counter-label">
							Total Comments
						</div>
					</div>
					
					<div class="rounded-borders">
						<div class="counter small">
							<span>
							14
							</span>
						</div>
						<div class="counter-label">
							Pending Comments
						</div>
					</div>
					
					<div class="rounded-borders">
						<div class="counter small">
							<span>
							11
							</span>
						</div>
						<div class="counter-label">
							Support Requests
						</div>
					</div>
				</div>
			</div>
			<!-- / Daily statistics -->
		</section>

		<!--=============================================================-->
		<section class="row-fluid">
			
			<!-- Support tickets
				================================================== -->
			<div class="span6">
				<h3 class="box-header">
					<i class="icon-bullhorn"></i>
					Support tickets
				</h3>
				<div class="box widget-support-tickets">
					<div class="ticket">
						<span class="label label-success">Completed</span>
						<a href="#" title="">Server unavaible<span>[#201798]</span></a>
						<img src="/resources/assets/images/avatar.png" alt="Avatar">
						<span class="opened-by">
							Opened by <a href="#" title="">First User</a> <br>
							Jan 28, 2012 10:24
						</span>
					</div>

					<div class="ticket">
						<span class="label label-warning">Pending</span>
						<a href="#" title="">Mobile App Problem<span>[#201797]</span></a>
						<img src="/resources/assets/images/avatar.png" alt="Avatar">
						<span class="opened-by">
							Opened by <a href="#">Second User</a> <br>
							Jan 28, 2012 10:24
						</span>
					</div>

					<div class="ticket">
						<span class="label label-info">In progress</span>
						<a href="#" title="">
							<i class="icon-warning-sign text-error"></i>PayPal issue<span>[#201796]</span>
						</a>
						<img src="/resources/assets/images/avatar.png" alt="Avatar">
						<span class="opened-by">
							Opened by <a href="#">Third User</a> <br>
							Jan 28, 2012 10:24
						</span>
					</div>

					<div class="ticket">
						<span class="label label-important">Rejected</span>
						<a href="#" title="">IE7 problem<span>[#201795]</span></a>
						<img src="/resources/assets/images/avatar.png" alt="Avatar">
						<span class="opened-by">
							Opened by <a href="#">Fourth User</a> <br>
							Jan 28, 2012 10:24
						</span>
					</div>

					<div class="ticket">
						<span class="label label-success">Completed</span>
						<a href="#" title="">Server unavaible<span>[#201794]</span></a>
						<img src="/resources/assets/images/avatar.png" alt="Avatar">
						<span class="opened-by">
							Opened by <a href="#">Fifth User</a> <br>
							Jan 28, 2012 10:24
						</span>
					</div>

					<div class="widget-actions">
						<a href="#" class="btn btn-mini" title="">Show more</a>
					</div>
				</div>
			</div>
			<!-- / Support tickets -->

			<!-- Last activity
				================================================== -->
			<div class="span6">
				<h3 class="box-header">
					<i class="icon-time"></i>
					Last activity
				</h3>
				<div class="box">
					<div class="tabbable">
					
						<!-- Tabs
							================================================== -->
						<ul class="nav nav-tabs box-wide">
						
							<li class="active">
								<a href="#tab-comments" data-toggle="tab">Comments</a>
							</li>
							
							<li>
								<a href="#tab-threads" data-toggle="tab">Threads</a>
							</li>
							
							<li>
								<a href="#tab-users" data-toggle="tab">Users</a>
							</li>
						</ul>
						<!-- / Tabs -->
						
						<!-- Tabs content
							================================================== -->
						<div class="tab-content box-wide box-no-bottom-padding">
						
							<!-- Recent comments tab content -->
							<div class="tab-pane fade in widget-comments active" id="tab-comments">
									
								<div class="comment">
									<img src="/resources/assets/images/avatar.png" alt="">
									<div class="content">
										<span class="commented-by">
											<a href="#" title="">First User</a> commented on <a href="#" title="">Article Name</a>
										</span>
										Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
										tempor incididunt ut labore.
										<span class="actions">
											<a href="#"><i class="icon-pencil"></i>Edit</a>
											<a href="#" class="comment-remove"><i class="icon-trash"></i>Remove</a>
											<span class="pull-right">2 hours ago</span>
										</span>
									</div>
								</div>
			
								<div class="comment">
									<img src="/resources/assets/images/avatar.png" alt="">
									<div class="content">
										<span class="commented-by">
											<a href="#" title="">Second User</a> commented on <a href="#" title="">Article Name</a>
										</span>
										Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
										tempor incididunt ut labore.
										<span class="actions">
											<a href="#"><i class="icon-pencil"></i>Edit</a>
											<a href="#" class="comment-remove"><i class="icon-trash"></i>Remove</a>
											<span class="pull-right">2 hours ago</span>
										</span>
									</div>
								</div>
			
								<div class="comment">
									<img src="/resources/assets/images/avatar.png" alt="">
									<div class="content">
										<span class="commented-by">
											<a href="#" title="">Third User</a> commented on <a href="#" title="">Article Name</a>
										</span>
										Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
										tempor incididunt ut labore.
										<span class="actions">
											<a href="#"><i class="icon-pencil"></i>Edit</a>
											<a href="#" class="comment-remove"><i class="icon-trash"></i>Remove</a>
											<span class="pull-right">2 hours ago</span>
										</span>
									</div>
								</div>
			
								<div class="comment">
									<img src="/resources/assets/images/avatar.png" alt="">
									<div class="content">
										<span class="commented-by">
											<a href="#" title="">Fourth User</a> commented on <a href="#" title="">Article Name</a>
										</span>
										Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
										tempor incididunt ut labore.
										<span class="actions">
											<a href="#"><i class="icon-pencil"></i>Edit</a>
											<a href="#" class="comment-remove"><i class="icon-trash"></i>Remove</a>
											<span class="pull-right">2 hours ago</span>
										</span>
									</div>
								</div>
			
								<div class="widget-actions">
									<a href="#" class="btn btn-mini" title="">Show more</a>
								</div>
							</div>
							<!-- / Recent comments tab content-->
							
							<!-- Recent threads tab content -->
							<div class="tab-pane fade widget-threads" id="tab-threads">
							
								<div class="thread">
									<img src="/resources/assets/images/avatar.png" alt="">
									<div class="content">
										<span>14h</span>
										<div>
											<a href="#">Lorem ipsum dolor sit amet</a><br>
											asked by <a href="#" title="">First User</a> in <a href="#" title="">Forum name</a>
										</div>
									</div>
								</div>
			
								<div class="thread">
									<img src="/resources/assets/images/avatar.png" alt="">
									<div class="content">
										<span>14h</span>
										<div>
											<a href="#">Lorem ipsum dolor sit amet</a><br>
											asked by <a href="#" title="">Second User</a> in <a href="#" title="">Forum name</a>
										</div>
									</div>
								</div>
			
								<div class="thread">
									<img src="/resources/assets/images/avatar.png" alt="">
									<div class="content">
										<span>14h</span>
										<div>
											<a href="#">Lorem ipsum dolor sit amet</a><br>
											asked by <a href="#" title="">Third User</a> in <a href="#" title="">Forum name</a>
										</div>
									</div>
								</div>
			
								<div class="thread">
									<img src="/resources/assets/images/avatar.png" alt="">
									<div class="content">
										<span>14h</span>
										<div>
											<a href="#">Lorem ipsum dolor sit amet</a><br>
											asked by <a href="#" title="">Fourth User</a> in <a href="#" title="">Forum name</a>
										</div>
									</div>
								</div>

								<div class="thread">
									<img src="/resources/assets/images/avatar.png" alt="">
									<div class="content">
										<span>14h</span>
										<div>
											<a href="#">Lorem ipsum dolor sit amet</a><br>
											asked by <a href="#" title="">Fifth User</a> in <a href="#" title="">Forum name</a>
										</div>
									</div>
								</div>
			
								<div class="widget-actions">
									<a href="#" class="btn btn-mini" title="">Show more</a>
								</div>
							</div>
							<!-- / Recent threads tab content -->
							
							<!-- Recent users activity tab content -->
							<div class="tab-pane fade widget-users-activity" id="tab-users">
								<div class="activity">
									<span class="pull-right">12h</span>
									<i class="icon-ok" style="color: #9bb921"></i>
									<img src="/resources/assets/images/avatar.png" alt="">
									<div>
										<a href="#" title="">First User</a> followed <a href="#" title="">Second User</a>
									</div>
								</div>
			
								<div class="activity">
									<span class="pull-right">12h</span>
									<i class="icon-remove" style="color: #dc6343"></i>
									<img src="/resources/assets/images/avatar.png" alt="">
									<div>
										<a href="#" title="">First User</a> unfollowed <a href="#" title="">Second User</a>
									</div>
								</div>
			
								<div class="activity">
									<span class="pull-right">12h</span>
									<i class="icon-comment" style="color: #639ad9"></i>
									<img src="/resources/assets/images/avatar.png" alt="">
									<div>
										<a href="#" title="">First User</a> commented <a href="#" title="">Article name</a>
										<span class="comment">
											Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut 			labore.
										</span>
									</div>
								</div>
			
								<div class="activity">
									<span class="pull-right">12h</span>
									<i class="icon-edit" style="color: #f3a139"></i>
									<img src="/resources/assets/images/avatar.png" alt="">
									<div>
										<a href="#" title="">First User</a> posted in <a href="#" title="">Forum name</a>
										<span class="comment">
											Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut 			labore.
										</span>
									</div>
								</div>

								<div class="activity">
									<span class="pull-right">12h</span>
									<i class="icon-ok" style="color: #9bb921"></i>
									<img src="/resources/assets/images/avatar.png" alt="">
									<div>
										<a href="#" title="">Second User</a> followed <a href="#" title="">Third User</a>
									</div>
								</div>
			
								<div class="widget-actions">
									<a href="#" class="btn btn-mini" title="">Show more</a>
								</div>
							</div>
							<!-- / Recent users activity tab content -->
						</div>
						<!-- / Tabs content -->
					</div>
					<!-- / .tabbable -->
				</div>
			</div>
			<!-- / Last activity -->
		</section>

		<!-- Why AdminFlare
			================================================== -->
		<section class="row-fluid" id="why-adminflare">
			<h3 class="box-header"><i class="icon-fire" style="color: #cd522c"></i> Why AdminFlare</h3>
			<div class=" box well ">
				<ul class="row-fluid">
					<li class="span4">
						<i class="icon-ok"></i> Simple and clean design
					</li>
					<li class="span4">
						<i class="icon-ok"></i> Responsive 12-column stacked-left, centered and fluid layouts
					</li>
					<li class="span4">
						<i class="icon-ok"></i> Built with LESS
					</li>
				</ul>

				<ul class="row-fluid">
					<li class="span4">
						<i class="icon-ok"></i> HTML5 and CSS3
					</li>
					<li class="span4">
						<i class="icon-ok"></i> Node.js scripts for LESS and JS compiling
					</li>
					<li class="span4">
						<i class="icon-ok"></i> Easy to customize
					</li>
				</ul>

				<ul class="row-fluid">
					<li class="span4">
						<i class="icon-ok"></i> Easy to exclude unused components and plugins
					</li>
					<li class="span4">
						<i class="icon-ok"></i> 11 color themes
					</li>
					<li class="span4">
						<i class="icon-ok"></i> 249 icons in one font (<a href="http://fortawesome.github.com/Font-Awesome/" title="FontAwesome" target="_blank">FontAwesome</a>)
					</li>
				</ul>

				<ul class="row-fluid">
					<li class="span4">
						<i class="icon-ok"></i> Based on <a href="http://twitter.github.com/bootstrap/" title="Bootstrap 2.2.2" target="_blank">Bootstrap 2.2.2</a>
					</li>
					<li class="span4">
						<i class="icon-ok"></i> Uses <a href="http://jquery.com/" title="jQuery 1.9.0" target="_blank">jQuery 1.9.0</a>
					</li>
					<li class="span4">
						<i class="icon-ok"></i> Integrated <a href="http://www.flotcharts.org/" title="Flot" target="_blank">Flot</a> charts
					</li>
				</ul>

				<ul class="row-fluid">
					<li class="span4">
						<i class="icon-ok"></i> <a href="http://rendro.github.com/easy-pie-chart/" title="Easy Pie Charts" target="_blank">Easy Pie Charts</a>
					</li>
					<li class="span4">
						<i class="icon-ok"></i> Dynamic tables (<a href="http://exacttarget.github.com/fuelux/#datagrid" title="Fluelux Datagrid" target="_blank">Fuelux Datagrid</a>)
					</li>
					<li class="span4">
						<i class="icon-ok"></i> Styled form elements (<a href="http://exacttarget.github.com/fuelux/" title="Fuelux" target="_blank">Fuelux</a>)
					</li>
				</ul>

				<ul class="row-fluid">
					<li class="span4">
						<i class="icon-ok"></i> Form validation (<a href="http://reactiveraven.github.com/jqBootstrapValidation/" title="jqBootstrapValidation" target="_blank">jqBootstrapValidation</a>)
					</li>
					<li class="span4">
						<i class="icon-ok"></i> WYSIWYG-Editor (<a href="http://jhollingworth.github.com/bootstrap-wysihtml5/" title="bootstrap-wysihtml5" target="_blank">bootstrap-wysihtml5</a>)
					</li>
					<li class="span4">
						<i class="icon-ok"></i> Colorpicker for Bootstrap (<a href="http://www.eyecon.ro/bootstrap-colorpicker/" title="bootstrap-colorpicker" target="_blank">bootstrap-colorpicker</a>)
					</li>
				</ul>

				<ul class="row-fluid">
					<li class="span4">
						<i class="icon-ok"></i> Datepicker for Bootstrap (<a href="http://www.eyecon.ro/bootstrap-datepicker/" title="datepicker-colorpicker" target="_blank">datepicker-colorpicker</a>)
					</li>
					<li class="span4">
						<i class="icon-ok"></i> Timepicker for Bootstrap (<a href="http://jdewit.github.com/bootstrap-timepicker/" title="bootstrap-timepicker" target="_blank">bootstrap-timepicker</a>)
					</li>
					<li class="span4">
						<i class="icon-ok"></i> Autosizing textarea (<a href="http://www.jacklmoore.com/autosize" title="jQuery Autosize" target="_blank">jQuery Autosize</a>)
					</li>
				</ul>

				<ul class="row-fluid">
					<li class="span4">
						<i class="icon-ok"></i> Toggle buttons (<a href="http://simontabor.com/toggles/" title="jQuery Toggles" target="_blank">jQuery Toggles</a>)
					</li>
					<li class="span4">
						<i class="icon-ok"></i> In-place editing with <a href="http://vitalets.github.com/x-editable/" title="X-editable" target="_blank">X-editable</a>
					</li>
					<li class="span4">
						<i class="icon-ok"></i> Wizards (<a href="http://exacttarget.github.com/fuelux/#wizard" title="jQuery Autosize" target="_blank">Fuelux Wizard</a>)
					</li>
				</ul>

				<ul class="row-fluid">
					<li class="span4">
						<i class="icon-ok"></i> Growl-like notifications (<a href="https://github.com/Nijikokun/bootstrap-notify/" title="bootstrap-notify" target="_blank">bootstrap-notify</a>)
					</li>
					<li class="span4">
						<i class="icon-ok"></i> Dialog boxes (<a href="http://bootboxjs.com/" title="Bootbox" target="_blank">Bootbox</a>)
					</li>
					<li class="span4">
						<i class="icon-ok"></i> Clickovers (<a href="https://github.com/lecar-red/bootstrapx-clickover" title="Bootstrapx Clickover" target="_blank">Bootstrapx Clickover</a>)
					</li>
				</ul>


			</div>
		</section>
		<!-- / Why AdminFlare -->

		<!-- Supported browsers
			================================================== -->
		<section class="row-fluid" id="supported-browsers">
			<div class="box">
				<header class="span2">
					SUPPORTED<br><strong>BROWSERS</strong>
				</header>
				<div class="span10">
					<div>
						<img src="/resources/assets/images/browsers/chrome.png" alt="Google Chrome">
						<span>Chrome</span>
					</div>
					<div>
						<img src="/resources/assets/images/browsers/firefox.png" alt="Mozills Firefox 9+">
						<span>Firefox 4+</span>
					</div>
					<div>
						<img src="/resources/assets/images/browsers/safari.png" alt="Safari 5+">
						<span>Safari 5+</span>
					</div>
					<div>
						<img src="/resources/assets/images/browsers/opera.png" alt="Opera 10+">
						<span>Opera 11+</span>
					</div>
					<div>
						<img src="/resources/assets/images/browsers/ie.png" alt="Internet Explorer 9+">
						<span>IE 9+</span>
					</div>
				</div>
			</div>
		</section>
		<!-- / Supported browsers -->
		
		<!-- Page footer
			================================================== -->
		<footer id="main-footer">
			Copyright � 2013 <a href="#">Your Company</a>, all rights reserved.
			<a href="#" class="pull-right" id="on-top-link">
				On Top&nbsp;<i class=" icon-chevron-up"></i>
			</a>
		</footer>
		<!-- / Page footer -->
	</section>
</body>
</html>