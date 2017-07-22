<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ip</title>
</head>
<body>
	Hello World!<br/>
	<%
	out.println("您的IP地址是 " + request.getRemoteAddr());
	%>
	
</body>
</html>