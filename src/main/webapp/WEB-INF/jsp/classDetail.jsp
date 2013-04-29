<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>
<div id="contentwrapper">
<div class="main_content">
<div class="row-fluid">
<div class="span12">
       	<p><a href="../classes">&lt; Class List</a></p>
       	<c:if test="${not empty compilerErrors}">
       		<h3>Compiler Errors:</h3>
            <c:forEach items="${compilerErrors}" var="err">
            		<p>Error in line ${err['line']} : ${err['problem']}</p>
            </c:forEach>
       	</c:if>
       	<c:if test="${not empty errorMsg}">
       		<h3>Errors:</h3>
       		 <c:forEach items="${errorMsg}" var="errmsg">
	       		<p>${errmsg}</p>
	       	</c:forEach>
       	</c:if>
		<form method="POST" action="">
	        <textarea name="body" rows="25" style="font-family: monospace; width: 800px;">${body}</textarea><br/>
		    <div class="btn-group">
		        <input type="submit" value="Save" class="btn btn-primary">
		    </div>
	    </form>
    </div>
  </div>
 </div>
 </div>
<jsp:include page="footer.jsp"/>