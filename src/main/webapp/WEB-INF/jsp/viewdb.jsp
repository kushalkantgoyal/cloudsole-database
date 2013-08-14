<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>
<section class="container">
<section class="row-fluid">
			<h3 class="box-header">
				Database View
			</h3>
			<div class="box">
				<div class="span8">
           		 <table class="table table-bordered table-striped">
           		 	<thead>
                    <tr>
                    	<th>Delete</th>
                    	<th>Update</th>
                        <th>Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                    </tr>
                    </thead>
                    <tbody>
                   <c:forEach items="${contactList}" var="contactList" varStatus="outer">
                   	 	<tr>
                   	 		<td><form action="/db/delete/${contactList.id}" method="POST"><input type="submit" class="btn btn-primary btn-mini" value="Delete"/></form></td>
                   	 		<td><form action="/db/update/${contactList.id}" method="GET"><input type="submit" class="btn btn-primary btn-mini" value="Update"/></form></td>
                   	 		 	
                   	 		<td>
                    				${contactList.id}
                    		</td>		
                   	 		<td>
                    				${contactList.firstName}
                    		</td>
                    		<td>
                    				${contactList.lastName}
                    		</td>
                   	  </tr> 
                    </c:forEach>
                    </tbody>
               </table>
               <form method="GET" action="/db/insert">
               <div class="control-group">
					<div class="controls">
							<button class="btn btn-primary" type="submit">New</button>
					</div>
				</div>
				</form>
        </div>
    </div>
</section>
</section>
<jsp:include page="footer.jsp"/>