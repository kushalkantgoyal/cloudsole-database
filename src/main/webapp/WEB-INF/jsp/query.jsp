<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"/>
<section class="container">
<section class="row-fluid">
	<h3 class="box-header">
				Database Query
			</h3>
			
		<div class="span12">
		<form class="form-horizontal" method="POST" action="/db/query">
			<fieldset>
				<div class="control-group">
					<textarea name="query" id="query" class="span12" rows="5"></textarea>
				</div>
				<div class="control-group">
					<div class="controls">
						<button class="btn btn-primary" type="submit">Run</button>
					</div>
				</div>
			</fieldset>
		</form>
		</div>
	</section>
</section>
<jsp:include page="footer.jsp"/>
