<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>
<section class="container">
	<section class="row-fluid">
			<h3 class="box-header">
				Code
			</h3>
			<div class="box">
					<ul id="myTab" class="nav nav-tabs">
						<li class="active"><a href="#classes" data-toggle="tab">Classes</a></li>
						<li><a href="#trigger" data-toggle="tab">Triggers</a></li>
						<li><a href="#visualforce" data-toggle="tab">VisualForce</a></li>
						<li><a href="#component" data-toggle="tab">Component</a></li>
					</ul>
					<div id="myTabContent" class="tab-content" style="margin-bottom: 10px">
					<div class="span4">
						<div class="tab-pane fade in active" id="classes">
							<form method="post">
          	 				<ul class="well nav nav-tabs nav-stacked">
							 	<c:forEach items="${apexClass}" var="apexClass">
									<li><a href="/login/apex/${apexClass['Id']}" data-toggle="tab">${apexClass['Name']}</a></li>
								</c:forEach>
								</ul>
							</form>
						</div>
						<div class="tab-pane fade in active" id="trigger">
							<form method="post">
          	 				<ul class="well nav nav-tabs nav-stacked">
							 	<c:forEach items="${apexTrigger}" var="apexTrigger">
									<li><a href="/login/apex/${apexTrigger['Id']}" data-toggle="tab">${apexTrigger['Name']}</a></li>
								</c:forEach>
								</ul>
							</form>
						</div>
						<div class="tab-pane fade in active" id="visualforce">
							<form method="post">
          	 				<ul class="well nav nav-tabs nav-stacked">
							 	<c:forEach items="${apexPage}" var="apexTrigger">
									<li><a href="/login/apex/${apexPage['Id']}" data-toggle="tab">${apexPage['Name']}</a></li>
								</c:forEach>
								</ul>
							</form>
						</div>
						<div class="tab-pane fade in active" id="component">
							<form method="post">
          	 				<ul class="well nav nav-tabs nav-stacked">
							 	<c:forEach items="${apexComponent}" var="apexTrigger">
									<li><a href="/login/apex/${apexComponent['Id']}" data-toggle="tab">${apexComponent['Name']}</a></li>
								</c:forEach>
								</ul>
							</form>
						</div>
					</div>
					<div class="span8">				
						<c:if test="${!empty body}">
							<form method="POST" action="">
	        					<textarea name="body" rows="25" style="font-family: monospace; width: 800px;">${body}</textarea><br/>
		    					<div class="btn-group">
		        					<input type="submit" value="Save" class="btn btn-primary">
		    					</div>
	    					</form>
	    				</c:if>
	    			</div>
				</div>
			</div>
		</section>
	</section>
    <script type="text/javascript">
    var SFDC = {
    		deleteApexClass: function(type, id, name) {
            if (!confirm("Are you sure you want to delete '" +  name + "'?")) {
                return false;
            }

            $.ajax({
                'url': 'classes/'+id,
                'type': 'DELETE',
                'success': function(data, textStatus, jqXHR) {
                    location.href = '/sfdc/classes'
                },
                'error': function(jqXHR, textStatus, errorThrown) {
                    alert('Failed to delete class.');
                }
            })
        }
    };
	</script>
<jsp:include page="footer.jsp"/>