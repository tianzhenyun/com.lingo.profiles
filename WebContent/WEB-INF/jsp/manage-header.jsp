<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/mdb.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/icon.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/style.css">
<link rel="shortcut icon" href='<c:url value="/img/favicon.ico" />' type="image/x-icon">
<link rel="icon" href='<c:url value="/img/favicon.ico" />' type="image/x-icon">

<nav class="double-navbar navbar navbar-fixed-top pt-color z-depth-1"
	role="navigation">
	<div class="container-fluid">
		<div class="navbar-header pull-left">
           <!-- SideNav slide-out button -->
           <a href="#" data-activates="slide-out" class="button-collapse hidden-lg hidden-md"><i class="fa fa-bars"></i></a>
		<div class="breadcrumbs hidden-xs hidden-sm">
			<h5>
				Lingo Profile
			</h5>
		</div>
	</div>
     	<ul class="list-inline pull-right text-center">
     		<li><a href="${pageContext.request.contextPath }/+${user.name }" class="waves-effect waves-light"><i class="fa fa-user"></i><br><span>Profile</span></a></li>
     		<li><a href="#" class="waves-effect waves-light"><i class="fa fa-info-circle"></i><br><span>About</span></a></li>
     	</ul>
	</div>
</nav>