<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"/>
	<h3 class="box-header">
			Quartz Manager
	</h3>
<div class="span12">

	 <c:if  test="${!empty quartzOutput}">
	 	<div class="alert fade in">
					<button type="button" class="close" data-dismiss="alert">×</button>
					<strong>${quartzOutput}</strong>
			</div>
	</c:if>
	
	<!-- Togglable tabs
			================================================== -->
		<section class="row-fluid">
				<div class="well">
					<ul id="myTab" class="nav nav-tabs">
						<li class="active"><a href="#run" data-toggle="tab">Run</a></li>
						<li><a href="#details" data-toggle="tab">Details</a></li>
						<li><a href="#triggers" data-toggle="tab">Triggers</a></li>
						<li><a href="#cronexpressions" data-toggle="tab">Cron Expression</a></li>
					</ul>
					<div id="myTabContent" class="tab-content" style="margin-bottom: 50px">
						<div class="tab-pane fade in active" id="run">
						 <form class="form-horizontal" method="POST" action="/quartz/run">
               			<fieldset>
							<div class="control-group">
								<label class="control-label" >Job Name</label>
								<div class="controls">
								<select name="jobName" id="jobName" >
									<c:forEach items="${cronDetails}" var="cronDetails" varStatus="outer">
										<option >${cronDetails.key}</option>
									</c:forEach>
								</select>
								</div>
							</div>
				
							<div class="control-group">
                				<label class="control-label" >Cron Expression</label>
                				<div class="controls">
                					<input name="cronexpression" id="cronexpression" required/>
                				</div>
                			</div>
                
                			<button class="btn btn-primary" type="submit">Run</button>
             			</fieldset>   
             		</form>	
					</div>


					<div class="tab-pane fade" id="details">
						<c:if  test="${!empty cronDetails}">
	 	 				<table class="table table-bordered table-striped">
           		 			<thead>
           		 			<tr>
                    			<th>Name</th>
                    			<th>Details</th>
                    		</tr>
                    		</thead>
                    	<tbody>
                   		<c:forEach items="${cronDetails}" var="cronDetails" varStatus="outer">
                   	 	<tr>	                 	    
                   	 		<td>
                    				${cronDetails.key}
                    		</td>
                    		<td>
                    				${cronDetails.value}
                    		</td>		
                   	  	</tr> 
                    	</c:forEach>
                    	</tbody>
               			</table>
	 				</c:if>
				</div>

				<div class="tab-pane fade" id="triggers">
				<c:if  test="${!empty jobTriggers}">
	 	 		<table class="table table-bordered table-striped">
           		 	<thead>
           		 	<tr>
           		 		<th>Operation</th>
                    	<th>Name</th>
                    	<th>Tigger</th>
                    </tr>	
                    </thead>
                    <tbody>
                   <c:forEach items="${jobTriggers}" var="jobTriggers" varStatus="outer">
                   	 	<tr>
                   	 		<td>
                   	 		<div class="btn-group">
  								<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">Action
  									<span class="caret"></span>
  								</a>
  								<ul class="dropdown-menu">
  									<li><a href="/quartz/run/${jobTriggers.key}">Run</a></li>
  									<li><a href="/quartz/stop/${jobTriggers.key}">Stop</a></li>
  									<li><a href="/quartz/pause/${jobTriggers.key}">Pause</a></li>
  								</ul>
							</div>
							</td>
                   	 		<td>
                    				${jobTriggers.key}
                    		</td>
                    		<td>
                    				${jobTriggers.value}
                    		</td>			
                   	  </tr> 
                    </c:forEach>
                    </tbody>
               	</table>
				 </c:if>
				</div>

				<div class="tab-pane fade" id="cronexpressions">
				<c:if  test="${!empty cronExpression}">
				<form action="/quartz/update" method="POST">
	 			 <table class="table table-bordered table-striped">
           		 	<thead>
           		 	<tr>
           		 		<th>Operation</th>
                    	<th>Name</th>
                    	<th>Tigger</th>
                    </tr>
                    </thead>
                    <tbody>
                   <c:forEach items="${cronExpression}" var="cronExpression" varStatus="outer">
                   	 	<tr>
                   	 		<td><input type="submit" class="btn btn-primary btn-mini" value="Update"/></td>
                   	 		<td>
                    			<input name="jobName" id="jobName" value="${cronExpression.key}"/>
                    		</td>
                    		<td>
                    			<input name="cronexpression" id="cronexpression" value="${cronExpression.value}"/>
                    		</td>			
                   	  </tr> 
       
                    </c:forEach>
                    </tbody>
               	  </table>
               	  </form>
				 </c:if>

				</div>
			</div>
		</div>
</section>
</div>		
<jsp:include page="footer.jsp"/>
