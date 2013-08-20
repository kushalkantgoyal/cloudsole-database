<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>

<section class="container">
<section class="row-fluid">
			<h3 class="box-header">
				File Manager
			</h3>
				
				<div class="span8">
				<c:if test="${!empty uploadResult}">
					<div class="alert fade in">
					<button type="button" class="close" data-dismiss="alert">×</button>
					<strong>${uploadResult}</strong>
				</div>
				</c:if>
			
				<form method="POST" action="/file/parse" enctype="multipart/form-data">
					Select a file: <input type="file" name="file" /> <input type="submit" value="upload" />
				</form>
				
				 <c:if test="${!empty csvList}">
           		<table class="table table-bordered table-striped">
           		 	<thead>
                    
                    </thead>
                    <tbody>
                   
                    <c:forEach items="${csvList}" var="csvList" varStatus="outer">
                   	 	<tr>
                   	 		<td>
                    				${csvList.key}
                    		</td>		
                    		<td>
                    				${csvList.value}
                    		</td>
                   	  </tr> 
                    </c:forEach>
                    </tbody>
               </table>
               </c:if>
        </div>
</section>
</section>	
<jsp:include page="footer.jsp"/>