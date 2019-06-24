<%@page import="com.axelor.db.PhoneNo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>
		<form action="search.jsp" method="post">
			Enter name<input type="text" name="name"> <br> <input
				type="submit" value="Search"> <br>
		</form>
		<table>
			<c:forEach items="${contactdetails}" var="contacts">
				<tr>
					<td>${contacts.cId}</td>
					<td>${contacts.name}</td>
					<td><p>
							<a
								href='<%=request.getContextPath() + "/deletecotact/"%>${contacts.cId}'>Delete
								Contact</a>
						</p></td>
					<td><p>
						<form action="updatename.jsp">
							<input type="hidden" name="cid" value="${contacts.cId}">
							<input type="hidden" name="oldname" value="${contacts.name}"> <input
								type="submit" value="update Name">
								
								<%-- <%=request.getContextPath() + "/updatename/"%>${contacts.cId} --%>

						</form>
						</p></td>
					<td><c:forEach items="${contacts.list}" var="phoneNo">

							<tr>
								<td>
								<th>${phoneNo.phoneNo}
								<td><p>
										<a
											href='<%=request.getContextPath() + "/deletephoneno/"%>${phoneNo.pId}'>delete
											Phone Number</a>
									</p></td>
								<td><p><form action="updatephone.jsp">
								<input type="hidden" name="oldno" value="${phoneNo.phoneNo}">
										<input type="hidden" name="pid" value="${phoneNo.pId}"> <input
											type="submit" value="update Number">
											
											<%-- updatephone/${phoneNo.pId} --%>
											
									</form>
									</p></td>
								</th></td>
				</tr>

			</c:forEach>
			</td>

			</tr>
			</c:forEach>
		</table>
		<form>
			<button type="submit" formaction="index.jsp">Insert</button>
			<br>
			<button type="submit" formaction="update.jsp">update</button>
			<br>
			<button type="submit"
				formaction="http://localhost:8080/Demo%20Project/show">show</button>
			<br>
			<button type="submit" formaction="delete.jsp">delete</button>
		</form>
	</center>

</body>
</html>