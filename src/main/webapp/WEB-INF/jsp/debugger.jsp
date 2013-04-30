<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"/>
	 <!-- Page content
		================================================== -->
	<section class="container">
	
		<!-- ================================================== -->
		<section class="row-fluid">

			<!-- Support tickets
				================================================== -->
			<div class="span6">
				<h3 class="box-header">
					<i class="icon-bullhorn"></i>
					Debugger Issues
				</h3>
				<div class="box widget-support-tickets">
					<div class="ticket">
						<span class="label label-success">Completed</span>
						<a href="#" title="">Server unavaible<span>[#201798]</span></a>
						<img src="assets/images/avatar.png" alt="Avatar">
						<span class="opened-by">
							Opened by <a href="#" title="">First User</a> <br>
							Jan 28, 2012 10:24
						</span>
					</div>

					<div class="widget-actions">
						<a href="#" class="btn btn-mini" title="">Show more</a>
					</div>
				</div>
			</div>
			<!-- / Support tickets -->
	 
<jsp:include page="footer.jsp"/>
