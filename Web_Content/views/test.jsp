<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/Test" method="get">
		<input type="text" name="a" />
		<button> Zô</button>
	</form>
	
	ATB: ${a}
	<br />
	Sessions: ${sessionScope.user} 
</body>
</html>