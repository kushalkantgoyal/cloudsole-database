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
		CloudSole - Developer
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
					<a href="/login/dashboard"><span class="icon-dashboard"></span>Dashboard</a>
				</li>
				<li>
					<a href="layout.html"><span class="icon-th-large"></span>Layout</a>
				</li>
				<li>
					<a href="typography.html"><span class="icon-font"></span>Metadata</a>
				</li>
				<li>
					<a href="forms.html"><span class="icon-edit"></span>CRUD</a>
				</li>
				<li>
					<a href="/login/sobject"><span class="icon-table"></span>SOQL</a>
				</li>
				
				<li>
					<a href="components.html"><span class="icon-inbox"></span>Email</a>
				</li>
				<li>
					<a href="javascript.html"><span class="icon-cog"></span>Apex</a>
				</li>
				<li class="lp-dropdown">
					<a href="#" class="lp-dropdown-toggle" id="extras-dropdown"><span class="icon-reorder"></span>Extras</a>
					<ul class="lp-dropdown-menu" data-dropdown-owner="extras-dropdown">
						<li>
							<a tabindex="-1" href="extras-icons.html"><span class="icon-coffee"></span>Icons</a>
						</li>
						<li>
							<a tabindex="-1" href="extras-charts.html"><span class="icon-bar-chart"></span>Stats</a>
						</li>
						<li>
							<a tabindex="-1" href="extras-widgets.html"><span class="icon-star"></span>Wiki</a>
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