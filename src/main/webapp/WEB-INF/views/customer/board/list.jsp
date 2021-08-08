<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/list.css" />
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous">
</script>
<title>掲示板ページ</title>
</head>
<body>
<h1>掲示板リスト</h1>
	<div class="table_wrap">
	<a href="/customer/board/enroll" class="top_btn">投稿する</a>
	<table>
		<thead>
			<tr>
				<th class="bno_width">番号</th>
				<th class="title_width">タイトル</th>
				<th class="writer_width">作成者</th>
				<th class="regdate_width">作成日</th>
				<th class="updatedate_width">編集日</th>
			</tr>
		</thead>
			<c:forEach items="${list}" var="list">
				<tr>
					<td><c:out value="${list.bno}"/></td>
					<td><c:out value="${list.title}"/></td>
					<td><c:out value="${list.writer}"/></td>
					<td><fmt:formatDate pattern="yyyy/MM/dd" value="${list.regdate}"/></td>
					<td><fmt:formatDate pattern="yyyy/MM/dd" value="${list.updateDate}"/></td>
				</tr>
			</c:forEach>
		</table>
</div>
	
</body>
<script>
	
	$(document).ready(function() {
		let result = '<c:out value="${result}"/>';

		checkAlert(result);

		function checkAlert(result) {

			if (result === '') {
				reutrn;
			}

			if (result === "enrol success") {
				alert("등록이 완료되었습니다.");
			}

		}
	});
</script>
</html>