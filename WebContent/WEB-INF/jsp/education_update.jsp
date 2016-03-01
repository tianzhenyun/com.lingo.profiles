<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Profile Education</title>
</head>
<body>
	<h1>Update Profile Education</h1>
	<form action="${pageContext.request.contextPath }/education/update"
		method="post">
		<input type="hidden" name="id" value="${form.id }"/>
		<div>
			Title: <input type="text" name="title" value="${form.title }" />
		</div>
		<div>
			Period: <input type="text" name="period" value="${form.period }"/>
		</div>
		<div>
			Professional: <input type="text" name="professional" value="${form.professional }"/>
		</div>
		<div>
			Link: <input type="text" name="link" value="${form.link }" />
		</div>
		<div>
			Intro: <input type="text" name="intro" value="${form.intro }" />
		</div>
		<input type="submit" value="Submit" />
	</form>

	<div>
		<table class="striped">
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Period</th>
				<th>Professional</th>
				<th>Link</th>
				<th>Intro</th>
				<th>Operation</th>
			</tr>
			<c:forEach var="item" items="${list }">
				<tr>
					<td>${item.id }</td>
					<td>${item.title }</td>
					<td>${item.period }</td>
					<td>${item.professional }</td>
					<td>${item.link }</td>
					<td>${item.intro }</td>
					<td>
					<a href="${pageContext.request.contextPath }/education/update/${item.id}">update</a> 
					<a href="${pageContext.request.contextPath }/education/delete/${item.id}">delete</a> 
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>