<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<div class="span4">
			<h3 class="box-header">SOQL Viewer</h3>
           <form method="post">
          	  <ul class="nav nav-tabs nav-stacked">
             	<c:forEach items="${sObject}" var="sObject">    
                  <li><a href="/login/sync/query/${sObject['name']}">${sObject['name']}</a></li>
               </c:forEach>	
            </ul>
            </form>
         </div>
    
