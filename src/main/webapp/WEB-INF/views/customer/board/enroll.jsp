<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/board.css" />
<title>掲示板書き込み</title>
</head>
<body>
	<h1>掲示板書き込み</h1>
	<form action="/customer/board/enroll" method="POST">
		<div class="input_wrap">
			<label>Title</label>
			<input type="text" name="title">
		</div>

		<div class="input_wrap">
			<label>Content</label>
			<textarea rows="3" name="content"></textarea>
		</div>
		<div class="input_wrap">
			<label>Writer</label>
			<input type="text" name="writer">
		</div>
		<button type="submit" class="btn">投稿</button>
	</form>
	
</body>
</html>