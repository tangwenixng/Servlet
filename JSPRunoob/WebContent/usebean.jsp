<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>use bean</title>
</head>
<body>
	<h1>Use Bean</h1>
	<jsp:useBean id="test" class="com.twx.TestBean" />
	<jsp:setProperty property="message" name="test" value="twx"/>
	
	<p>输出信息...</p>
	<jsp:getProperty property="message" name="test"/>
	
</body>
</html>