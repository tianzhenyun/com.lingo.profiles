<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Update Profile Education</title>
<%@include file="/WEB-INF/jsp/manage-header.jsp"%>
</head>
<body>
	<div class="main ui container masthead vertical segment">
		<div class="ui grid">
			<div class="column">
				<form class="ui form" action="${pageContext.request.contextPath }/education/update" method="post" enctype="multipart/form-data">
					<h2 class="ui header">Update Profile Education</h2>
					<input type="hidden" name="id" value="${form.id }" />
					<div class="ten wide field">
						<label>Title</label> <input type="text" name="title" required
							placeholder="Title" value="${form.title }" >
					</div>
					<div class="ten wide field">
						<label>Logo</label> <input type="file" name="logo" accept="image/*" placeholder="Logo">
					</div>
					<div class="ten wide field">
						<label>Period</label> <input type="text" name="period" required
							placeholder="Title" value="${form.period }" >
					</div>
					<div class="ten wide field">
						<label>Professional</label> <input type="text" name="professional" required
							placeholder="Professional" value="${form.professional }" >
					</div>
					<div class="ten wide field">
						<label>Link</label> <input type="text" name="link" required
							placeholder="Link" value="${form.link }" >
					</div>
					<div class="ten wide field">
						<label>Intro</label> 
						<textarea rows="2" name="intro" required placeholder="Intro">${form.intro }</textarea>
					</div>
					<input class="ui large teal submit button" type="submit"
						value="Submit">
				</form>
			</div>
		</div>
		<div class="ui grid">
			<div class="column">
				<table class="ui celled padded table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Title</th>
							<th>Period</th>
							<th>Professional</th>
							<th>Link</th>
							<th>Intro</th>
							<th>Operation</th>
						</tr>
					</thead>
					<tbody>
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
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/jsp/manage-footer.jsp"%>
</body>
</html>