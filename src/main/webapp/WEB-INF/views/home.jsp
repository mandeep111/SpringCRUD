<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Management</title>
</head>
<body>
	<div align="center">
		<h1>Book List</h1>
		<h3>
			<a href="books">New Book</a>
		</h3>
		<table border="1" width = "50%">

			<thead align = "center">
				<tr>
					<td>Id</td>
					<td>Book Name</td>
					<td>Book Price</td>
					<td>Book Author</td>
					<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbspAction</td>
				</tr>
			</thead>

			<tbody align = "center">
				<c:forEach var = "books" items = "${blist}">
					<tr>
					<td>${books.bid}</td>
					<td>${books.bname}</td>
					<td>${books.bprice }</td>
					<td>${books.bauthor }</td>
					
					<td>
						<input type = "button" onclick = "editBook(${books.bid})" value = "Edit">
						<input type = "button" onclick = "deleteBook(${books.bid})" value = "Delete">
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		
		<script type="text/javascript">
			function editBook(bid) {
				window.location = "${pageContext.request.contextPath}/"+bid+"/edit";
			}
			
			function deleteBook(bid) {
				var msg = confirm("Delete?");
				if (msg == true) {
					window.location = "${pageContext.request.contextPath}/"+bid+"/delete";	
				}
				
			}
			
		</script>
	
</body>
</html>