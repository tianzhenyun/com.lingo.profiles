<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Profile</title>
	<%@include file="/WEB-INF/jsp/header.jsp" %>
</head>
<body ng-app="profiles" layout="column">
	<md-toolbar layout="row">		
		<h1>Webcome to com.lingo.profiles</h1>
	</md-toolbar>
	<div flex layout="row">
		<md-sidenav md-is-locked-open="true" class="md-whiteframe-z2">
			<md-list> 
				<md-list-item> 
					<md-icon md-svg-src="" class="avatar"></md-icon> Skill </md-list-item> <md-list-item>
					<md-icon md-svg-src="" class="avatar"></md-icon> Project </md-list-item> <md-list-item>
					<md-icon md-svg-src="" class="avatar"></md-icon> Education </md-list-item> <md-list-item>
					<md-icon md-svg-src="" class="avatar"></md-icon> Living </md-list-item> <md-list-item>
					<md-icon md-svg-src="" class="avatar"></md-icon> Link 
				</md-list-item> 
			</md-list> 
		</md-sidenav>

		<md-content flex id="content">
			<div>
				<h3>Profile info</h3>
				<div>
					Name: <label>${form.name }</label>
				</div>
				<div>
					Avatar: <img src="data:image/jpg;base64,${form.avatarImage }"
						style="width: 200px; height: 200px" />
				</div>
				<div>Phone:${form.phone }</div>
				<div>Email:${form.email }</div>
				<div>Address:${form.address }</div>
				<div>Intro:${form.intro }</div>
			</div>
			<h3>Skill</h3>
			<div>
				<table class="striped">
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Content</th>
					</tr>
					<c:forEach var="item" items="${form.skill }">
						<tr>
							<td>${item.id }</td>
							<td>${item.title }</td>
							<td>${item.content }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
	
			<h3>Project</h3>
			<div>
				<table class="striped">
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Image</th>
						<th>Link</th>
						<th>Tags</th>
						<th>Intro</th>
					</tr>
					<c:forEach var="item" items="${form.project }">
						<tr>
							<td>${item.id }</td>
							<td>${item.title }</td>
							<td><img src="data:image/jpg;base64,${item.projectImage }"
								style="width: 100px; height: 100px;" /></td>
							<td><a href="${item.link}">${item.link }</a></td>
							<td>${item.tags }</td>
							<td>${item.intro }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
	
	
			<h3>Education</h3>
			<div>
				<table class="striped">
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Period</th>
						<th>Professional</th>
						<th>Link</th>
						<th>Intro</th>
					</tr>
					<c:forEach var="item" items="${form.education }">
						<tr>
							<td>${item.id }</td>
							<td>${item.title }</td>
							<td>${item.period }</td>
							<td>${item.professional }</td>
							<td>${item.link }</td>
							<td>${item.intro }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
	
			<h3>Living</h3>
			<div>
				<table class="striped">
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Content</th>
					</tr>
					<c:forEach var="item" items="${form.living }">
						<tr>
							<td>${item.id }</td>
							<td>${item.title }</td>
							<td>${item.content }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
	
			<h3>Link</h3>
			<div>
				<table class="striped">
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Link</th>
						<th>Logo</th>
					</tr>
					<c:forEach var="item" items="${form.link }">
						<tr>
							<td>${item.id }</td>
							<td>${item.title }</td>
							<td><a href="${item.link}">${item.link }</a></td>
							<td><img src="data:image/jpg;base64,${item.logoImage }"
								style="width: 50px; height: 50px;" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</md-content>
	</div>
	<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>