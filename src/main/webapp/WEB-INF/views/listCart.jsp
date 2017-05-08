<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Display product</title>
<style>
#more {
	display: block;
	float: right;
	clear: right;
	right: 120px;
}

.images {
	display: block;
	width: 120px;
	height: 120px;
}
#continues_bt{
	display: block;
	float: right;
	clear: right;
	margin-right: 120px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<c:if test="${!empty cartList}">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Price</th>
							<th>Image</th>
							<th>Add</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cart" items="${cartList}" >
							<tr>
								<td>${cart.value.id}</td>
								<td>${cart.value.name}</td>
								<td>${cart.value.price}</td>
								<td><img src="<c:url value="/resources/images/${cart.value.image}"/>" class="images" /></td>
								<td><a href="<c:url value='/shopping/delete/${cart.value.id}'/>"  class="btn btn-info">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		<!-- end row -->
		<a href="<c:url value='/product/list/0'/>"  class="btn btn-info" id="continues_bt">Continues to shopping</a>
	</div> 
	<table>
</table>
 </body>
</html>