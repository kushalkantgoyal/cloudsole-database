<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"/>

       <div class="span12">
			<!-- Badges
			================================================== -->
		<section class="row-fluid">
			<h3 class="box-header">
				Database Config Details
			</h3>
			<div class="box">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Name</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								Database Open
							</td>
							<td>
								<c:if test="${!empty connectionStatus}">
									<span class="label label-success">${connectionStatus}</span>
								</c:if>
							</td>
							<td>
								
							</td>
						</tr>
						<tr>
							<td>
								Connection Info
							</td>
							<td>
								<span class="label label-blue">Info</span>
							</td>
							<td>
								${url}
								${username}
							</td>
						</tr>
						<tr>
							<td>
								Warning
							</td>
							<td>
								<span class="badge badge-warning">Warnings</span>
							</td>
							<td>
								${warnings}
							</td>
						</tr>
						<tr>
							<td>
								Metadata
							</td>
							<td>
								<span class="badge badge-important">6</span>
							</td>
							<td>
								${metadata}
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</section>
		<!-- / Badges -->
		
    </div>
 <jsp:include page="footer.jsp"/>
