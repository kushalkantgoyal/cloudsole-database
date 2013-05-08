<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>
<section class="container">
<section class="row-fluid">
			<h3 class="box-header">
				Create Databse Insert
			</h3>
			<div class="box">
				<div class="span8">
           			<form class="form-horizontal" method="POST" action="/login/db/insert">
										<fieldset>
											<div class="control-group">
												<label class="control-label">First Name</label>
												<div class="controls">
													<input type="text" class="span5" name="firstName" />
													<span class="help-block">block Job Name</span>
												</div>
											</div>
											<div class="control-group">
												<label class="control-label">Environment</label>
												<div class="controls">
													<input type="text" class="span5" name="lastName" />
												</div>
											</div>
											
											<div class="control-group">
												<div class="controls">
													<button class="btn btn-primary" type="submit">Create Insert</button>
												</div>
											</div>
										</fieldset>
									</form>
           
        </div>
    </div>
</section>
</section>
<jsp:include page="footer.jsp"/>