<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="container">
<section class="row-fluid">
			<h3 class="box-header">
				SOQL Explorer
			</h3>
			<div class="box">
			<div class="span4">
           <form method="post">
          	  <ul class="nav nav-list">
             	<c:forEach items="${sObject}" var="sObject">    
                  <li><a href="/login/sobject/query/${sobjects['name']}">${sobjects['name']}</a></li>
               </c:forEach>	
            </ul>
            </form>
           </div>
         </div>
