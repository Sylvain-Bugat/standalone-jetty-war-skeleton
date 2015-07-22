<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL Test</title>
	</head>
	<body>
		<div>JSTL test: forEach 0 to 9</div>
		<c:forEach var="i" begin="0" end="9" step="1">
			<div>[${i}]</div>
		</c:forEach>
	</body>
</html>
