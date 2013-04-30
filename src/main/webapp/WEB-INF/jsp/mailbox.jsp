<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>
<section class="container">
		<!-- ================================================== -->
		<section class="row-fluid">
			<!-- Navigation and search field
			================================================== -->
			<div class="span4">
				<h3 class="box-header">&nbsp;</h3>
				<ul class="well nav nav-tabs nav-stacked">
					<li class="active">
						<a href="#"><i class="icon-download-alt"></i> Inbox <span class="badge pull-right badge-primary">58</span></a>
					</li>
					<li>
						<a href="#"><i class="icon-exclamation-sign"></i> Important <span class="badge pull-right">3</span></a>
					</li>
					<li>
						<a href="#"><i class="icon-upload-alt"></i> Sent <span class="badge pull-right">56</span></a>
					</li>
					<li>
						<a href="#"><i class="icon-edit"></i> Drafts <span class="badge pull-right">15</span></a>
					</li>
					<li>
						<a href="#"><i class="icon-trash"></i> Trash <span class="badge pull-right">12</span></a>
					</li>
					<li>
						<a href="#"><i class="icon-ban-circle"></i> Spam</a>
					</li>
				</ul>
				<hr>
				<form class="form-search row-fluid">
					<input type="text" placeholder="Search messages..." class="search-query input-block-level">
					<i class="icon-search"></i>
				</form>
			</div>
			<!-- / Navigation and search field -->

			<!-- ================================================== -->
			<div class="span8">
				<!-- Messages
					================================================== -->
				<h3 class="box-header">
					<i class="icon-download-alt"></i>
					Inbox Messages
					<span class="pull-right">4 unread messages</span>
				</h3>
				<div class="box non-collapsible widget-messages">
					<div class="message-actions">
						<div class="btn-group">
							<a href="javascript:selectAll()" class="btn btn-small">Select All</a>
							<button class="btn btn-small dropdown-toggle" data-toggle="dropdown">
								<i class="icon-caret-down"></i>
							</button>
							<ul class="dropdown-menu">
								<li>
									<a href="javascript:toggleSelection()">Toggle Selection</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="javascript:unselectAll()">Unselect All</a>
								</li>
							</ul>
						</div>
						<div class="btn-group">
							<a class="btn btn-small dropdown-toggle" data-toggle="dropdown" href="#">
								Actions&nbsp;&nbsp;
								<i class="icon-caret-down"></i>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="javascript:markAsRead()">Mark as read</a>
								</li>
								<li>
									<a href="javascript:markAsUnread()">Mark as unread</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="#">Move to folder</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="javascript:deleteMessages()">Delete</a>
								</li>
							</ul>
						</div>
						<button class="btn btn-primary btn-small pull-right"><i class="icon-refresh"></i></button>
					</div>

					<div class="message unread">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">First User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 1<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message unread">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Second User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 2<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Third User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 3<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Fourth User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 4<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Fifth User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 5<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Sixth User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 6<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Seventh User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 7<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Eigtht User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 8<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Ninth User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 9<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message unread">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">First User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 10<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message unread">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Second User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 11<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Third User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 12<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Fourth User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 13<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Fifth User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 14<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Sixth User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 15<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Seventh User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 16<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Eigtht User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 17<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Ninth User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 18<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Ninth User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 19<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
					<div class="message">
						<div class="action-checkbox">
							<input type="checkbox" name="" value="">
						</div>
						<a href="#" title="" class="from">Ninth User</a>
						<div class="date">
							18 jan
						</div>
						<a href="#" title="" class="title">Message Title 20<span> - Lorem ipsum dolor sit amet...</span></a>
					</div>
				</div>
				<!-- / Messages -->

				<!-- Pagination
					================================================== -->
				<div class="pagination pagination-small">
					<ul>
						<li><a href="#">Prev</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><span>...</span></li>
						<li><a href="#">8</a></li>
						<li class="active"><a href="#">9</a></li>
						<li><a href="#">10</a></li>
						<li><span>...</span></li>
						<li><a href="#">32</a></li>
						<li><a href="#">33</a></li>
						<li><a href="#">Next</a></li>
					</ul>
				</div>
				<!-- / Pagination -->
			</div>
		</section>
	</section>
<jsp:include page="footer.jsp"/>