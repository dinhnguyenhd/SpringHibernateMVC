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
</style>
<script type="text/javascript">
	function showMore() {
		$path = "ajax/" + $("#page").val();
		alert($path);
		$.get($path, function(data, status) {
			alert(data);
			$.each(data, function(index, product) {
				alert(product.image);
				$('table tbody').append(" <tr>" + 
										" <td>" + product.id + " </td>"    +
										" <td>" +  product.name + "</td>"  + 
										" <td>"  + product.price + "</td>" +
										" <td> <img class='images' src= "  + "/SpringMVCHibernate/resources/images/" + product.image + "></td>" +
										" <td> <a href=" + "/SpringMVCHibernate/shopping/add/" + product.id + " class = 'btn btn-info'> Add </a></td></tr>");
			});
			$('#page').val(parseInt($('#page').val()) + 1);
		});
	}
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<c:if test="${!empty list}">
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
						<c:forEach items="${list}" var="product">
							<tr>
								<td>${product.id}</td>
								<td>${product.name}</td>
								<td>${product.price}</td>
								<td><img src="<c:url value="/resources/images/${product.image}"/>" class="images" /></td>
								<td><a href="<c:url value='/shopping/add/${product.id}'/>" class="btn btn-info">Add</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		<!-- end row -->
		<button type="button" class="btn btn-info" id="more"
			onclick="showMore()">Show more</button>
	</div>
	<input type="hidden" name="page" value="1" id="page" />

</body>
</html>