<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% int cid = Integer.parseInt(request.getParameter("cid"));
	String oldName = (request.getParameter("oldname"));%>

	<center>
		<form action="<%=request.getContextPath() + "/updatename/" + cid%>" method="post">
		    change name from:- <input type="text" name="oldname" value="<%=oldName%>"><br>
			To:-<input type="text" name="name"><br> <input
				type="submit" value="update Name">
		</form>
	</center>

</body>
</html>