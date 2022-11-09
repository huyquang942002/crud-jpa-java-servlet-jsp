<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>List Account</title>
<link type="text/css" rel="stylesheet"
	href="VIEW/assets/css/viewuser.css">
</head>



<body>

	<div id="wrapper">
		<div id="header">
			<h2>List Account</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<input type="button" value="Add Customer"
				onclick="window.location.href='signup.jsp';return false;"
				class="add-student-button" />

			<table>

				<tr>
					<th>firstName</th>
					<th>lastName</th>
					<th>userName</th>
					<th>passWord</th>
					<th>email</th>
					<th>phoneNumber</th>
					<th>Action</th>
				</tr>

				<c:forEach var="viewuser" items="${USER_LIST}">

					<c:url var="tempLink" value="viewUserController">
						<c:param name="action" value="LOAD" />
						<c:param name="id" value="${viewuser.id}" />
					</c:url>

					<c:url var="deleteLink" value="viewUserController">
						<c:param name="action" value="DELETE" />
						<c:param name="id" value="${viewuser.id}" />
					</c:url>


					<tr>
						<td>${viewuser.firstName}</td>
						<td>${viewuser.lastName}</td>
						<td>${viewuser.userName}</td>
						<td>${viewuser.passWord}</td>
						<td>${viewuser.email}</td>
						<td>${viewuser.phoneNumber}</td>

						<td><a href="${tempLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="if(!(confirm('are you sure you want to delete this student?')))
									 return false">Delete</a>

						</td>
					</tr>
				</c:forEach>

				

			</table>

		</div>

	</div>

	<div style="clear: both;"></div>
	<p>
		<a href="index.jsp">Back To List</a>
	</p>
	</div>
</body>


</html>








