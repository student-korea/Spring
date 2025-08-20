<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Member List</title>
		<style>
		  h2{text-align: center;}
		  table{width:800px; margin:10px auto;}
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  th,td{width:400px; height:40px; text-align: center; }
		</style>
	</head>
	<body>
	  <h2>Member imfo List</h2>
	  <table>
	    <tr>
	      <th>Id</th>     
	      <th>Pw</th>
	      <th>Name</th>
	      <th>Tel</th>
	      <th>Gender</th>
	      <th>Hobby</th>
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
	      <td colspan="6"><a href="/">메인페이지 이동</a></td>
	    </tr>
	    <tr>
		      <td>${one.id}</td>
		      <td>${one.pw}</td>
		      <td>${one.name}</td>
		      <td>${one.phone}</td>
		      <td>${one.gender}</td>
		      <td>${one.hobby}</td>
		    </tr>
	  </table>
	
	</body>
</html>