<%@page import="javax.persistence.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.axelor.db.PhoneNo"%>
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

	<%
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("contactdemo");

	  EntityManager em = emf.createEntityManager();

	  Contact contact = new Contact();

	  String name = request.getParameter("uname");

	  Query query = em.createQuery("select c.list from Contact c where c.name=:name");
	  query.setParameter("name", name);

	  List<PhoneNo> phoneno = query.getResultList();
	%>
	<center>
		<h1>which number ?</h1>

	</center>
	<%
	  for (PhoneNo s : phoneno) {
	    out.println(s.getPhoneNo());
	%>
	<br>
	<%
	  }
	%>

<center>
	<form action = "update" method="post">
	old number <input type ="text" name="oldpno">
	new number <input type ="text" name = "newpno">
	<input type="submit" value ="OK">
	</form>
	
	</center>

</body>
</html>