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
		<c:forEach items="${list}" var="list" varStatus="status">
			<tr>
				<td><c:out value="${list.bno}" /></td>
				<td><a class="move" href='/customer/board/get?bno=<c:out value="${list.bno}"/>'> 
				<c:out value="${list.title}" /></a></td>
				<td><c:out value="${list.writer}" /></td>
				<td><fmt:formatDate pattern="yyyy/MM/dd" value="${list.regdate}" /></td>
				<td><fmt:formatDate pattern="yyyy/MM/dd" value="${list.updateDate}" /></td>
			</tr>
		</c:forEach>
	</table>
		<div class="pageInfo_wrap" >
	        <div class="pageInfo_area">
			  	<ul id="pageInfo" class="pageInfo">
			  		<!-- 이전페이지 버튼 -->
	                <c:if test="${pageMaker.prev}">
	                    <li class="pageInfo_btn previous"><a href="${pageMaker.startPage-1}">Previous</a></li>
	                </c:if>
			  		<!-- 각 번호 페이지 버튼 -->
			        <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
	                    <li class="pageInfo_btn ${pageMaker.cri.pageNum == num ? 'active':'' }">
	                    <button type="button" onclick="movePage(${num})">${num}</button></li>
	                </c:forEach>
	
		     		<!-- 다음페이지 버튼 -->
	                <c:if test="${pageMaker.next}">
	                    <li class="pageInfo_btn next"><a href="${pageMaker.endPage + 1 }">Next</a></li>
	                </c:if>
			  	</ul>
	        </div>
	    </div>
	<form action="moveForm" method="GET" id="moveForm">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
	    <input type="hidden" name="amount" value="${pageMaker.cri.amount }">
    </form>
    </div>
</body>
<script>
	
	$(document).ready(function() {
		let sysmsg = '<c:out value="${sysmsg}"/>';
		if(sysmsg!= '' && sysmsg !== undefined){
			alert(sysmsg);
		}
	});
	
	function movePage(num){
		$('input[name=pageNum]').val(num);
		document.getElementById('moveForm').action = "/customer/board/list";
		moveForm.submit();
	}
</script>
</html>