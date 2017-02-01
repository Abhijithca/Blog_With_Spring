<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>General Blog</title>
</head>
<body>
<sec:authorize access="isAnonymous()">
<h4>Welcome to Admin Console Blog section</h4>
	<form action="faces/uploadBlogs" method="post">
		<div><input type="submit" value="Upload Blogs"/></div>
	</form>
</sec:authorize>
<c:if test="${true == loggedout}">
	<h5 style="color: green">You have been logged out.</h5>
    <form action="uploadBlogs" method="post">
		<div><input type="submit" value="Upload Blogs"/></div>
	</form>
</c:if>
	
<sec:authorize access="isAuthenticated()">
	<form name="saveblogcontent" action="saveBlog" method="post" enctype="multipart/form-data">
	<table style="border: 1px solid black;">
	<tr>
	<h3 style="text-align:left">Enter the Blog Details</h3>
	<tr>
	<td>Title : </td>
	<td><input type="text" name="blogTitle" size="50" required></td>
	</tr>
	<tr>
	<td>Content: </td>
	<td><textarea name="blogContent" rows="6" cols="100" required> Enter the Blog Contents Here </textarea></td>
	</tr>
	<tr>
	<td>Attachments : </td>
	<td><input type="file" name="file"></td>
	</tr>
	<tr/><tr/>
	<tr>
	<td><input type="submit" value="Save Blog"/></td>
	</tr>
	</table>
	</form>
	<br></br>
    <form action="logout" method="post">
    	<div><input type="submit" value="Log Out"/></div>
    </form>
</sec:authorize>

<table style="border: 1px solid black;">
<h3 style="text-align:left"> Existing uploaded blogs</h3>
	<c:forEach items="${blogList}" var="blog">
		<tr style="border: 1px solid black;">
			<td>
			<table>
				<tr>
				<td>Blog Name: ${blog.blogTitle}
				</td>
				<tr>
				<td>Blog Content: ${blog.content}
				</td>
				</tr>
				<tr>
				<td>
					Attachment: <a href="${blog.attachment}">${blog.attachmentName}</a>
				</td>
				<td>
				<c:forEach items="${blog.comments}" var="com">
									<tr style="border: 1px solid black;">
										<td>Name: ${com.name}</td>
										<td>Comment: ${com.commentText}</td>
									</tr>
								</c:forEach></td>
				</tr>
				<tr>
					<td>
						<form action="addComment" method="post">
							<table>
							<tr>
							<td colspan="2">
							<input name="blogId" type="hidden" value="${blog.id}">
							Name : <input name="name" type="text">
							</td>
							<tr>
							<td>
							Comment:<textarea cols="30" rows="2" name="comment" required></textarea>
							</td>
							<td>
								<input type="submit" value="Submit Comment">
							</td>
							</tr>
							</table>
						</form>
					</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td>
			<td>
		</tr>
	</c:forEach>
</table>
</body>
</html>