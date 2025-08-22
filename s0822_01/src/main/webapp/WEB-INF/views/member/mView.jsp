<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>입력결과</title>
		<style>
		  h2{text-align: center;}
		  table{width:400px; margin:10px auto; }
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  th,td{width:200px; height:40px; text-align: center;}
		</style>
	</head>
	<body>
	  <h2>입력결과</h2>
	  <table>
	    <tr>
	      <th>아이디</th>
	      <td>${member.id}</td>
	    </tr>
	    <tr>
	      <th>패스워드</th>
	      <td>${member.pw}</td>
	    </tr>
	    <tr>
	      <th>이름</th>
	      <td>${member.name}</td>
	    </tr>
	    <tr>
	      <th>전화번호</th>
	      <td>${member.phone}</td>
	    </tr>
	    <tr>
	      <th>성별</th>
	      <td>${member.gender}</td>
	    </tr>
	    <tr>
	      <th colspan="2"><a href="/">메인페이지 이동</a></th>
	    </tr>
	  </table>
	
	</body>
</html>