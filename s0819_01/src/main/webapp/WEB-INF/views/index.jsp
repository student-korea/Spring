<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>메인페이지</h2>
	<ul>
		<li><a href="/member/login">로그인페이지</a></li>
		<li><a href="/stu/stuInput">성적페이지</a></li>
		<li><a href="/num/numInput">숫자입력</a></li>
		<li><a href="/board/blist/1">PathValiable 게시판</a></li>
	    <li><a href="/board/blist">PathValiable 값없는 게시판</a></li>
	    <li><a href="/board/board?page=1">파라미터 값으로 전달 게시판</a></li>
	    <li><a href="/board/board">파라미터 값 없이 전달 게시판</a></li>
		<li><a href="/member/mView">회원정보 보기</a></li>
		<li><a href="/member/mList">회원리스트</a></li>
		<li><a href="/member/member">회원가입</a></li>
	</ul>
</body>
</html>