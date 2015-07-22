<?xml version="1.0" encoding="UTF-8" ?>
<%@ page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP test</title>
	</head>
	<body>
		<div>Calendar.getInstance().getTime() call: <%=Calendar.getInstance().getTime() %></div>
		<div>CSS file content dump with jsp:include page="test-css.css":<br/><pre><jsp:include page="test-css.css"></jsp:include></pre></div>
		<div>JS file content dump with jsp:include page="test-js.js":<br/><pre><jsp:include page="test-js.js"></jsp:include></pre></div>
	</body>
</html>
