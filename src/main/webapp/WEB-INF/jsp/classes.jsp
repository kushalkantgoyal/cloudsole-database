<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="header.jsp"/>
<link rel="stylesheet" href="/resources/codemirror.css">
<script src="/resources/codemirror.js"></script>
<script src="/resources/clike.js"></script>
<section class="container">
	<section class="row-fluid">
			<h3 class="box-header">
				Code
			</h3>
				<div class="box">
					<form method="post">
				  		<ul id="myTab" class="nav nav-tabs">
							<li><a href="/login/apex/view/class">Classes</a></li>
							<li><a href="/login/apex/view/trigger">Triggers</a></li>
							<li><a href="/login/apex/view/page">VisualForce</a></li>
							<li><a href="/login/apex/view/component">Component</a></li>
						</ul>
					</form>
					<div id="myTabContent" class="tab-content" style="margin-bottom: 10px">
					
					<div class="span4">
						<form method="post">
						<div class="tab-pane fade in">
          	 				<ul class="nav nav-tabs nav-stacked">
							 	<c:forEach items="${apexClass}" var="apexClass">
									<li><a href="/login/apex/view/${apexType}/${apexClass['Id']}">${apexClass['Name']}</a></li>
								</c:forEach>
								</ul>
						</div>
						</form>
					</div>	
					
					<div class="span8">	
					<c:if test="${not empty result}">
						<c:choose>
							<c:when test="${result == 'Successful'}">
								<div class="alert alert-success">
									<c:forEach items="${result}" var="result">
  										<a href="#" class="close" data-dismiss="alert">×</a>${result}
  									</c:forEach>
								</div>
							</c:when>
							<c:when test="${fn:containsIgnoreCase(result, 'Exception')}">
								<div class="alert alert-error">
								  <c:forEach items="${result}" var="result">
  									<a href="#" class="close" data-dismiss="alert">×</a>${result}
								</c:forEach>
								</div>
							</c:when>
							<c:otherwise>
								<div class="alert alert-error">
								  <c:forEach items="${result}" var="result">
  									<a href="#" class="close" data-dismiss="alert">×</a>Error in line ${result['line']} : ${result['problem']}
								</c:forEach>
								</div>
							</c:otherwise>
						</c:choose>
       				</c:if>
       		
							<form method="post" action="/login/apex/save/${apexType}/${currentId}">
	        					<textarea name="body" id="body" rows="50" style="width: 666px;">${body}</textarea><br/>
		    					<div class="btn-group">
		        					<input type="submit" value="Save" class="btn btn-primary">
		    					</div>
	    					</form>
	    			</div>
				</div>
			</div>
		</section>
	</section>
	<!-- Change mode from java to html for visualforce -->
	<script>
	  var editor = CodeMirror.fromTextArea(document.getElementById("body"), {
	        lineNumbers: true,
	        mode: "text/x-java"
	      });
 	</script>
   
<jsp:include page="footer.jsp"/>