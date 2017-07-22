<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登入异常页面</title>
</head>
<body>
登入失败<br>
您提交的信息为：<br>
用户名：<%= request.getParameter("uname") %><br>
密码：<%= request.getParameter("upwd") %><br>
<a href="login.jsp">返回登入页面</a>
</body>
</html>