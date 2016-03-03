<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="profiles" ng-cloak>
<head>
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/jsp/header.jsp"%>
	<h1>Add Profile Info</h1>
	<form action="${pageContext.request.contextPath }/profile/add" method="post" enctype="multipart/form-data">
		<div>
			Name:
			<input type="text" name="name" />
		</div>
		<div>
			Avatar:
			<input type="file" name="avatar"/>
		</div>
		<div>
			Phone:
			<input type="text" name="phone" />
		</div>
		<div>
			Email:
			<input type="text" name="email"/>
		</div>
		<div>
			Address:
			<input type="text" name="address" />
		</div>
		<div>
			Intro:
			<input type="text" name="intro"/>
		</div>
		<md-button type="submit" class="md-raised md-primary">Submit</md-button>
	</form>
	<%@include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>