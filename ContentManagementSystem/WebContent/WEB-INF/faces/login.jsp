<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head>
        <title>Blog Admin Login</title>
    </head>
    <body>
   	<c:if test="${null != param.error}">
    		<h4 style="color: red">invalid credentials</h4>
	</c:if>
	<c:if test="${null != param.logout}">
    		<h4 style="color: green">You have been logged out.</h4>
	</c:if>
        <form th:action="@{/login}" method="post">
        <h4>Please enter your blog credentials</h4>
            <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
            <table style="border: 1px solid black;">
            <tr><td><label> User Name : </label></td><td><input type="text" name="username"/></td></tr>
            <tr><td><label> Password: </label></td><td><input type="password" name="password"/></td></tr>
            <tr><td colspan="2"><input type="submit" value="Sign In"/></td></tr>
            </table>
        </form>
    </body>
</html>