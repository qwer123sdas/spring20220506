<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.*"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!--font-awesome  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!--bootstrap  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!--Jquery -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>

<title>Insert title here</title>
</head>
<body>
	<h1>고객 리스트</h1>
	<table class="table">
		<thead>
			<tr>
				<th>CustomerID</th>
				<th>CustomerName</th>
				<th>ContactName</th>
				<th>Address</th>
				<th>City</th>
				<th>PostalCode</th>
				<th>Country</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customerList }" var = "cus">
			<tr>
				<td>${cus.id }</td>
				<td>${cus.customerName }</td>
				<td>${cus.contactName }</td>
				<td>${cus.postalCode }</td>
				<td>${cus.address }</td>
				<td>${cus.city }</td>
				<td>${cus.country }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- nav>ul.pagination>li.page-item*7>a.page-link -->

	
</body>
</html>