<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Profile Link</title>
	<%@include file="/WEB-INF/jsp/header.jsp" %>
	<style>
		input[type="radio"]{
			margin:24px 0px;
		}
		label
		{
			font-size:1rem;
		}
	</style>
</head>
<body>
	<h1>Add Profile Link</h1>
	<form action="${pageContext.request.contextPath }/link/add"
		method="post" enctype="multipart/form-data">
		<div>
			Title: <input type="text" name="title" />
		</div>
		<div>
			Link: <input type="text" name="link" />
		</div>
		<div>
			Icon:
			<c:forEach var="item" items="${social }">
				<label class="radio-inline">
					<input type="radio" name="icon" value="${item.icon }|${item.bg}"><a class="btn-sm-full ${item.bg } rectangle waves-effect waves-light"><i class="fa fa-${item.icon }"> </i><span>${item.name }</span></a>
				</label>
			</c:forEach>
		</div>
		<div>
			Logo: <input type="file" name="logo" />
		</div>
		<input type="submit" value="Submit" />
	</form>
	<div>
		<table class="striped">
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Link</th>
				<th>Icon</th>
				<th>Operation</th>
			</tr>
			<c:forEach var="item" items="${list }">
				<tr>
					<td>${item.id }</td>
					<td>${item.title }</td>
					<td>
						<a href="${item.link}">${item.link }</a>
					</td>
					<td>
						<a href="${item.link }" class="btn-sm-full ${fn:split(item.icon,'|')[1] } rectangle waves-effect waves-light"><i class="fa fa-${fn:split(item.icon,'|')[0] }"> </i> <span>${item.title }</span> </a>
					</td>
					<td>
					<a href="${pageContext.request.contextPath }/link/update/${item.id}">update</a> 
					<a href="${pageContext.request.contextPath }/link/delete/${item.id}">delete</a> 
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>