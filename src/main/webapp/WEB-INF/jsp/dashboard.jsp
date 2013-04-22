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
<jsp:include page="footer.jsp"/>