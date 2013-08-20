<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9"><![endif]-->
<!--[if gt IE 8]><!--><html class="no-js"><!--<![endif]-->
<jsp:include page="header.jsp"/>
<body>

	
	<!-- Page content
		================================================== -->
	<section class="container">

		<!-- Server statistics
			================================================== -->
		<section class="well row-fluid widget-pie-charts">
			<h3 class="box-header">
				Customer statictics
			</h3>
			<div class="box no-border non-collapsible">
				
				<div class="span2 pie-chart">
					<div id="easy-pie-chart-1" data-percent="${totalAmountOfCustomers}">
						${totalAmountOfCustomers}
					</div>
					<div class="caption">
						Total Customers
					</div>
				</div>
				
				
			</div>
		</section>
		<!-- / Server statistics -->


<jsp:include page="footer.jsp"/>