<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Phone BooK</title>
</head>
<body>
	<center>
		<form action="insert" method="post">
			Enter username<input type="text" name="uname"><br> Enter
			phone Number<input type="text" name="pnumber"> <br> <input
				type="submit" value="Insert"> <br>
			<button type="submit" formaction="update.jsp">update</button>
			<br>
			<button type="submit" formaction="delete.jsp">delete</button>
		</form>
		<form>
			<br>
			<button type="submit"
				formaction="http://localhost:8080/Demo%20Project/show">show</button>
		</form>
	</center>
</body>
</html>
