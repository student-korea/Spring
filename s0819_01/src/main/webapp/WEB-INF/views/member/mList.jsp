<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		<style>
		  h2{text-align: center;}
		  table{width:800px; margin:10px auto;}
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  th,td{width:400px; height:40px; text-align: center; }
		</style>
	</head>
	<body>
	  <h2>입력결과</h2>
	  <table>
	    <tr>
	      <th>아이디</th>     
	      <th>패스워드</th>
	      <th>이름</th>
	      <th>전화번호</th>
	      <th>성별</th>
	      <th>취미</th>
	    </tr>
	    <c:forEach var="member" items="${list}">
		    <tr>
		      <td>${member.id}</td>
		      <td>${member.pw}</td>
		      <td>${member.name}</td>
		      <td>${member.phone}</td>
		      <td>${member.gender}</td>
		      <td>${member.hobby}</td>
		    </tr>
	    </c:forEach>
	    <tr>
	      <th colspan="6"><a href="/">메인페이지 이동</a></th>
	    </tr>
	  </table>
	
	</body>
</html>