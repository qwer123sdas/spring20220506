<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<h1>${message }</h1>
	<h1>임원 등록 하기</h1>
	<form action="${pageContext.request.contextPath }/ex14/sub06" method="post">
		LastName : <input type="text" name="lastName" value="H.M"/>
		FirstName : <input type="text" name="firstName" value="SON"/>
		BirthDate : <input type="date" name="birthDate" id="" />
		Photo : <input type="text" name="photo" value="EmpID3.pic"/>
		Notes : <input type="text" name="notes"/>
		<button>등록</button>
	</form>
	
	<table class="table">
		<thead>
			<tr>
				<th>EmployeeID</th>
				<th>LastName</th>
				<th>FirstName</th>
				<th>BirthDate</th>
				<th>Photo</th>
				<th>Notes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employee }" var="employee" >
			<tr>
				<td>${employee.id }</td>
				<td>${employee.firstName }</td>
				<td>${employee.lastName }</td>
				<td>${employee.birthDate }</td>
				<td>${employee.photo }</td>
				<td>${employee.notes }</td>
			</tr> 
			</c:forEach>
		</tbody>
	</table>
	
	<c:url value="/ex14/sub06" var="employeeUrl"></c:url>
	<h1>직원 등록</h1>
	 <form action="${employeeUrl }" method="post">
	 	First Name : <input type="text" name="firstName"/>
	 	last Name : <input type="text" name="lastName"/>
	 	photo : <input type="text" 	name="photo"/> <br />
	 	Notes : <textarea name= "notes" rows="30" cols="10"></textarea>
	 	<button>등록</button>
	 </form>
	
</body>
</html>