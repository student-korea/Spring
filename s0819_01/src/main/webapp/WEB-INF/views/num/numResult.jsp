<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		<style>
		  h2{text-align: center;}
		  table{width:400px; margin:10px auto;}
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  th,td{width:200px; height:40px; text-align: center; }
		</style>
	</head>
	<body>
	  <h2>입력결과</h2>
	  <table>
	    <tr>
	      <th>이름</th>
	      <td>${num.getName()}</td>
	    </tr>
	    <tr>
	      <th>국어</th>
	      <td>${num.getKor()}</td>
	    </tr>
	    <tr>
	      <th>영어</th>
	      <td>${num.getEng()}</td>
	    </tr>
	    <tr>
	      <th>수학</th>
	      <td>${num.getMath()}</td>
	    </tr>
	     <tr>
	      <th>합계</th>
	      <td>${num.getTotal()}</td>
	    </tr>
	    <tr>
	      <th>평균</th>
	      <td>${num.getAvg()}</td>
	    </tr>
	  </table>
	  <a href="/">메인페이지 이동</a>

	</body>
</html>