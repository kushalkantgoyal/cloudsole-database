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
                   <c:forEach items="${contactList}" var="contactList" varStatus="outer">
                   	 	<tr>		
                   	 		<td>
                    				${contactList.firstName}
                    		</td>
                    		<td>
                    				${contactList.lastName}
                    		</td>
                   	  </tr> 
                    </c:forEach>
               </table>
        </div>
    </div>
</section>
</section>
<jsp:include page="footer.jsp"/>