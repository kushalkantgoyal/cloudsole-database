<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"/>
	  <!-- Why AdminFlare
			================================================== -->
		<section class="row-fluid" id="why-adminflare">
			<h3 class="box-header"><i class="icon-fire" style="color: #cd522c"></i> Why CloudSole Developer</h3>
			<div class=" box well ">
				
				<c:forEach items="${websiteFeatures}" var="feature" varStatus="index">
				 <c:choose>
				 	<c:when test="${index.first}">
				 	<ul class="row-fluid">
					<li class="span4">
						<i class="icon-ok"></i> ${feature}
					</li>
					</c:when>
					<c:when test="${(index.count % 3) == 1 }">
						</ul>
						<ul class="row-fluid">
						<li class="span4">
							<i class="icon-ok"></i> ${feature}
						</li>
					</c:when>
					<c:when test="${index.last}">
						<li class="span4">
							<i class="icon-ok"></i> ${feature}
						</li>
						</ul>
					</c:when>
					<c:otherwise>
						<li class="span4">
							<i class="icon-ok"></i> ${feature}
						</li>
					</c:otherwise>
				</c:choose>
				</c:forEach>
				
			</div>
		</section>
		<!-- / Why AdminFlare -->
		
      <!-- Supported browsers
			================================================== -->
		<section class="row-fluid" id="supported-browsers">
			<div class="box">
				<header class="span2">
					SUPPORTED<br><strong>BROWSERS</strong>
				</header>
				<div class="span10">
					<div>
						<img src="/resources/assets/images/browsers/chrome.png" alt="Google Chrome">
						<span>Chrome</span>
					</div>
					<div>
						<img src="/resources/assets/images/browsers/firefox.png" alt="Mozills Firefox 9+">
						<span>Firefox 4+</span>
					</div>
					<div>
						<img src="/resources/assets/images/browsers/safari.png" alt="Safari 5+">
						<span>Safari 5+</span>
					</div>
					<div>
						<img src="/resources/assets/images/browsers/opera.png" alt="Opera 10+">
						<span>Opera 11+</span>
					</div>
					<div>
						<img src="/resources/assets/images/browsers/ie.png" alt="Internet Explorer 9+">
						<span>IE 9+</span>
					</div>
				</div>
			</div>
		</section>
		<!-- / Supported browsers -->
<jsp:include page="footer.jsp"/>
