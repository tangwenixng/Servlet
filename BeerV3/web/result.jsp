<%@ page import="java.util.*;" %>

<html>
<head>
	<title>Result</title>
</head>
<body>
	<h1>beer Recommand JSP</h1>

	<%
		List<String> list  =(List<String>)request.getAttribute("style");
		for(String str:list){
			out.print("<br>try : "+str);
		}
	%>
</body>
</html>