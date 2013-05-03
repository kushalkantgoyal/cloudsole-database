<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="span8">
		<h3 class="box-header">
					<i class="icon-download-alt"></i>
					Manage ${currentSObject} Object
				</h3>
        <div class="box non-collapsible widget-messages">
		   <c:if  test="${!empty success}">
           <div class="alert alert-success">
          	 <button type="button" class="close" data-dismiss="alert">×</button>
 			 <strong>Success:</strong>
 			 	${success}
		   </div>
		   </c:if>
		   <c:if  test="${!empty error}">
		   <div class="alert alert-error">
             <button type="button" class="close" data-dismiss="alert">×</button>
 			 <strong>Error:</strong>
 			 	${error}
		   </div>
		   </c:if>
           <div class="tabbable">              
   			 <ul class="nav nav-tabs" id="getStartedTab">
          	  	<li><a href="/login/sync/query/${currentSObject}" onClick="return objvalidate.checkIfSObjectSelected('${currentSObject}')">Query</a></li>
          	 </ul>
          	   <div class="tab-content">
          	    <div id="/login/sync/query/${currentSObject}" class="tab-pane active">
          	  	<c:if  test="${!empty sobjectQuery}">
          			<form method="POST" action=""> <textarea class="span9" row-fluids="5" rows="5" name="soqlquery" id="soqlquery">${sobjectQuery}</textarea><br />
          	  		<button class="btn btn-primary" type="submit">Run</button></form>
          	  	</c:if>
          	  	</div>
          	  	</div>
          	  	<div class="tab-content">
          	  	<div id="/login/sync/view/${currentSObject}" class="tab-pane active">
          	  	<form method="POST" action="">
          	  	<c:if test="${!empty sobjectRecords}">
          	  	 	<ul class="nav nav-pills line_sep">
          	  	 	<a href="/login/sync/run" class="btn btn-primary btn-mini pull-left">Run Sync</a>
          	  	 	</ul>
          	  	 </c:if>
          	 	<c:if  test="${!empty sobjectFieldNames}">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                    <th>Sync</th>
                    <c:forEach items="${sobjectFieldNames}" var="fieldNames" varStatus="innerColumn">
                    <c:choose>
                     <c:when test="${innerColumn.first}"></c:when>
                    	<c:otherwise>
                     		 <th>${fieldNames}</th>
                    	 </c:otherwise>
                     </c:choose>
         
                    </c:forEach>
                    <c:if test="${!empty sobjectRecords}">
                   	 	<c:forEach items="${sobjectRecords}" var="sobjectRecords" varStatus="outer">
                   	 	<tr>
                   	 		 <c:forEach items="${sobjectRecords}" var="sobjectRecord" varStatus="inner">
                   	 		 <c:choose>
                   	 		 <c:when test="${inner.first}">
                   				<td>
                   	 		 		<label class="checkbox">
  										<input type="checkbox" name="${outer.index}" value="${sobjectRecord.value}">
									</label>
								</td>
	
                   	 		 </c:when>
                   	 		 <c:otherwise>
                   	 		 	<td>
                    				${sobjectRecord.value}
                    			</td>
                   	 		 </c:otherwise>
                   	 		 </c:choose>
                    		</c:forEach>
                    	</tr> 
                    	</c:forEach>	
                    </c:if>
                    </tr>
                    </thead>
                </table>
                <div class="pagination">
  				<ul>
  					<c:if  test="${!empty pagination}">
  					<c:forEach items="${pagination}" var="pagination" >
  						<li><a href="${pagination.value}">${pagination.key}</a></li>
  					</c:forEach>
  					</c:if>
  				</ul>
  				</div>
           		</c:if>
           		</form>
           		</div>
          	  </div>
   			</div>
        </div>
     </div>
      <script type="text/javascript">
    var objvalidate = {
    		checkIfSObjectSelected: function(name) {
            if (!name) {
            	alertbutton = alert('Please select an Object');
            	if (alertbutton == true)
            		{
            			window.location = '/login/';
            		}
                return false;
            }
           
        }
    };
</script>
  