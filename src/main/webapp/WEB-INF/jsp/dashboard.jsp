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
				Record statictics
			</h3>
			<div class="box no-border non-collapsible">
				
				<div class="span2 pie-chart">
					<div id="easy-pie-chart-1" data-percent="${queryCountOppResult}">
						${queryCountOppResult}
					</div>
					<div class="caption">
						Total Opportunities
					</div>
				</div>
				
				<div class="span2 pie-chart">
					<div id="easy-pie-chart-2" data-percent="${queryTotalAmountOppResult}">
						${queryTotalAmountOppResult}
					</div>
					<div class="caption">
						Total Opportunity Amount
					</div>
				</div>

				<div class="span2 pie-chart">
					<div id="easy-pie-chart-3" data-percent="${queryNewOpenCaseToday}">
						${queryNewOpenCaseToday}
					</div>
					<div class="caption">
						Open Cases Today
					</div>
				</div>

				<div class="span2 pie-chart">
					<div id="easy-pie-chart-4" data-percent="${queryNewClosedCaseToday}">
						${queryNewClosedCaseToday}
					</div>
					<div class="caption">
						Closed Cases Today
					</div>
				</div>

				<div class="span2 pie-chart">
					<div id="easy-pie-chart-5" data-percent="${queryNewLeadsToday}">
						${queryNewLeadsToday}
					</div>
					<div class="caption">
						New Leads Today
					</div>
				</div>

				<div class="span2 pie-chart">
					<div id="easy-pie-chart-6" data-percent="${queryNewContactToday}">
						${queryNewContactToday}
					</div>
					<div class="caption">
						New Contacts Today
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
					Daily Opportunity Chart
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
							${queryLoginsToday}
							</span>
						</div>
						<div class="counter-label">
							Logins Today
						</div>
					</div>
					
					<div class="rounded-borders">
						<div class="counter small">
							<span>
							${queryChatterPostsToday}
							</span>
						</div>
						<div class="counter-label">
							Chatter Posts
						</div>
					</div>
					
					<div class="rounded-borders">
						<div class="counter small">
							<span>
							${queryChatterCommentsToday}
							</span>
						</div>
						<div class="counter-label">
							Chatter Comments
						</div>
					</div>
					
					<div class="rounded-borders">
						<div class="counter small">
							<span>
							${queryEmailToday}
							</span>
						</div>
						<div class="counter-label">
							Total Emails
						</div>
					</div>
					
					<div class="rounded-borders">
						<div class="counter small">
							<span>
							${queryTasksToday}
							</span>
						</div>
						<div class="counter-label">
							Total Tasks
						</div>
					</div>
					
					<div class="rounded-borders">
						<div class="counter small">
							<span>
							${queryDocumentToday}
							</span>
						</div>
						<div class="counter-label">
							Total Documents
						</div>
					</div>
				</div>
			</div>
			<!-- / Daily statistics -->
		</section>

<jsp:include page="footer.jsp"/>