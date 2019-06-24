<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% int pid = Integer.parseInt(request.getParameter("pid"));
	long oldno =Long.parseLong(request.getParameter("oldno"));%>

	<center>
		<form action="<%=request.getContextPath()+ "/updatephone/"+pid%>" method="post">
		    change name from:- <input type="text" name="oldno" value="<%=oldno%>"><br>
			To:-<input type="text" name="phoneno"><br> <input
				type="submit" value="update phone">
		</form>
	</center>
</body>
</html>