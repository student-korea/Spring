
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판</title>
		<style>
		  h2{text-align: center;}
		  table{width:1200px; margin:10px auto; }
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  th,td{width:200px; height:40px; text-align: center;}
		</style>
	</head>
	<body>
	  <h2>게시판</h2>
	  <table>
	    <tr>
			<th>번호</th>	      
			<th>이름</th>	      
			<th>국어</th>	      
			<th>영어</th>	      
			<th>수학</th>	     
			<th>총합</th>	      
			<th>평균</th>	      
			<th>등급</th>	 
	    </tr>
	    <c:forEach var="stuscore" items="${list}">
		    <tr>
		        <td>${stuscore.sno}</td>
		        <td>${stuscore.name}</td>
		        <td>${stuscore.kor}</td>
		        <td>${stuscore.eng}</td>
		        <td>${stuscore.math}</td>
		        <td>${stuscore.total}</td>
		        <td>${stuscore.avg}</td>
		        <td>${stuscore.sgrade}</td>
		    </tr>
	    </c:forEach>
	    
	    <tr>
	        <td colspan="8"><a href="/">메인페이지 이동</a></td>
	    </tr>
	  </table>
	
	</body>
</html>
