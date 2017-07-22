<%@ page import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<html>
<head>
	<title>Result</title>
</head>
<body>
	
	<myTags:header fontColor="#660099">
		sdfsadrerfefafsarefdaf
	</myTags:header>
	<br>


	<h1>beer Recommand JSP</h1>

	<%
		List<String> list  =(List<String>)request.getAttribute("style");
		for(String str:list){
			out.print("<br>try : "+str);
		}
	%>

	<jsp:useBean id="dog" class="com.example.model.Dog" scope="request">
		<jsp:setProperty name="dog" property="breed" value="zangao" />
	</jsp:useBean>

	<br>
	Dog created by servlet : <jsp:getProperty name="dog" property="breed" />
	<br>

	El value test : ${dog.breed}   <br>

	luanma : ${str}     buluanma  :   <c:out value="${str}" />  <br>
	username: ${user}    <c:out value="${user}" default="gg"/> <br>

	<c:forEach var="str" items="${style}" varStatus="counter">
		Count: ${counter.count}  ${str} <br>
	</c:forEach>

	If:
	<c:if test="${user == 'twx'}">
		hello，${user}  唐文兴
	</c:if>
	<br>

	When and choose:
	<c:choose>
		<c:when test="${user == 'twx'}">
			you are spectial user
		</c:when>
		<c:otherwise>
			you are not our user,sorry!
		</c:otherwise>
	</c:choose>

	<br>
	c:set--->>
	<c:set var="beerName" scope="session" value="${dog}" />
	Dog name is : ${beerName.breed} <br>

	c:remove-->>
	<c:remove var="user" scope="request" />
	User now is : ${user}
</body>
</html>
