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
							<form method="post" action="/login/apex/update">
	        					<textarea name="body" rows="25" style="font-family: monospace; width: 666px;">${body}</textarea><br/>
		    					<div class="btn-group">
		        					<input type="submit" value="Save" class="btn btn-primary">
		    					</div>
	    					</form>
	    				
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