<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>
<section class="container">
<section class="row-fluid">
<div class="span8">
			<h3 class="box-header">
				Create New Apex
			</h3>
			<div class="box">
			<div class="tabbable">
					
						<!-- Tabs
							================================================== -->
						<ul class="nav nav-tabs box-wide">
						
							<li class="active">
								<a href="#tab-trigger" data-toggle="tab">Trigger</a>
							</li>
							
							<li>
								<a href="#tab-class" data-toggle="tab">Class</a>
							</li>
							
							<li>
								<a href="#tab-visualforce" data-toggle="tab">Visualforce</a>
							</li>
							<li>
								<a href="#tab-component" data-toggle="tab">Component</a>
							</li>
						</ul>
						<!-- / Tabs -->
			<!-- Tabs content
							================================================== -->
			<div class="tab-content box-wide box-no-bottom-padding">
			<c:if test="${error != null}">
                <div class="alert">${error}</div>
            </c:if>		
			<!-- Recent comments tab content -->
			<div class="tab-pane fade in active" id="tab-trigger">
            
            <form class="form-horizontal" method="POST" action="">
             <fieldset>
 				<div class="control-group">
 					<label>Select Operation</label>
 					<label class="checkbox">
  						<input type="checkbox" name="before_insert" value="before insert">Before Insert
					</label>
					<label class="checkbox">
  						<input type="checkbox" name="after_insert" value="after insert">After Insert
					</label>
					<label class="checkbox">
  						<input type="checkbox" name="before_update" value="before update">Before Update
					</label>
					<label class="checkbox">
  						<input type="checkbox" name="after_updater" value="after update">After Update
					</label>
					<label class="checkbox">
  						<input type="checkbox" name="before_delete" value="before update">Before Delete
					</label>
					<label class="checkbox">
  						<input type="checkbox" name="after_delete" value="after update">After Update
					</label>
					<label class="checkbox">
  						<input type="checkbox" name="undelete" value="undelete">Undelete
					</label>
 				</div>
 				<div class="control-group">
 					<label>Select Handler</label>
 					<label class="checkbox inline">
  						<input type="checkbox" value="handler">Create Handler
					</label>
 				</div>
    			<div class="control-group">
    				<label>Enter Trigger Name</label>
		        		<input id="triggername" name="triggername" value="" placeholder="Type trigger name"/>
		      	</div>
		      	<div class="control-group">
    				<label>Enter Trigger Handler Name:</label>
		        		<input id="triggerhandlername" name="triggerhandlername" value="" placeholder="Type trigger handler name"/>
		      	</div>
                <div class="control-group">
					<div class="controls">
                    	<input type="submit" value="Save" class="btn btn-primary">
                    </div>
                </div>
              </fieldset>
            </form>
    	</div>
    	<div class="tab-pane fade in" id="tab-class">
    	<form class="form-horizontal" method="POST" action="login/apex/new/class">
             <fieldset>
 				<div class="control-group">
 				<select>
 					<c:forEach items="${classTypes}" var="classtypes">
 					<option>${classtypes}</option>
 					</c:forEach>
 				</select>
 				</div>
 				 <div class="control-group">
					<div class="controls">
                    	<input type="submit" value="Save" class="btn btn-primary">
                    </div>
                </div>
 			</fieldset>
 		</form>
    	</div>
  	</div>
  </div>
  </div>
 </div>
 </section>
 </section>

<jsp:include page="footer.jsp"/>