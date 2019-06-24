<%@page import="com.axelor.db.PhoneNo"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="com.axelor.db.Contact"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	</center>
	<%
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("contactdemo");

	  EntityManager em = emf.createEntityManager();

	  Contact contact = new Contact();

	  String name = request.getParameter("name");

	  Query query = em.createQuery("select c.list from Contact c where c.name=:name");
	  query.setParameter("name", name);

	  List<PhoneNo> phoneno = query.getResultList();
	%>
	<center>
		<h1>Numbers:-</h1>
		<br>

	</center>
	<%
	  for (PhoneNo s : phoneno) {
	    out.println(s.getPhoneNo());
	%>
	<br>
	<%
	  }
	%>
	<form>
		<button type="submit" formaction="index.jsp">Insert</button>
		<br>
		<button type="submit" formaction="update.jsp">update</button>
		<br>
		<br> <button type="submit" formaction="http://localhost:8080/Demo%20Project/show">show</button>
		<br>
		<button type="submit" formaction="delete.jsp">delete</button>
	</form>

</body>
</html>