<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>
<section class="container">
<section class="row-fluid">
			<h3 class="box-header">
				Create New Apex
			</h3>
			<div class="box">
			<div class="span8">
            <c:if test="${error != null}">
                <div class="alert">${error}</div>
            </c:if>

            <form class="form-horizontal" method="POST" action="">
             <fieldset>
 				<div class="control-group">
 					<label>Select Type</label>
 					<div class="controls">
		        		<select name="type">
		        			<option value="Trigger">Trigger</option>
		        			<option value="Class">Class</option>
		        			<option value="Visualforce Page">Visualforce Page</option>
		        			<option value="Visualforce Component">Visualforce Component</option>
		        		</select>
		       	</div>
 				</div>
 				<div class="control-group">
 					<label>Select Option</label>
 					<div class="controls">
		        		<select name="option">
		        			<option value="Base">Base</option>
		        			<option value="Test">Test</option>
		        			<option value="Batch">Batch</option>
		        			<option value="Schedule">Schedule</option>
		        			<option value="Email">Email</option>
		        			<option value="Exception">Exception</option>
		        			<option value="Empty">Empty</option>
		        		</select>
		       		 </div>
 				</div>
    			<div class="control-group">
    				<label>Enter ${triggerOrClass} Name</label>
    				<div class="controls">
		        		<input id="name" name="name" value="" placeholder="Type class name"/>
		        	</div>
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
 </section>
 </section>

<jsp:include page="footer.jsp"/>