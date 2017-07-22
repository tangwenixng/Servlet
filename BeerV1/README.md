使用JSTL需要引入两个jar包 standard.jar jstl.jar 
编译语句：javac -classpath D:\software\apache-tomcat-7.0.73\lib\servlet-api.jar;WEB-INF/classes -d WEB-INF/classes src/com/example/web/BeerSelect.java
# Servlet 8个监听器
  1、上下文监听器： ServletContextListener 和 ServletContextAttributeListener <br>
  2、请求监听器： ServletRequestListener 和 ServletRequestAttributeListener <br>
  3、会话监听器: HttpSessionListener HttpSessionAttributeListener HttpSessionBindingListener HttpSessionActivationListern<br>

# JSP
	scriptlet: <% %>
	指令： <%@ %>
	表达式: <%= %>

	page指令的属性: import session contentType isELIgnored isErrorPage language pageEncoding
	
### 隐式对象
-------------

API | 隐式对象 |
-------- | --------|
JspWriter | out
HttpServletRequest | request |
HttpServletResponse | response |
HttpSession | session |
ServletContext | application |
ServletConfig | config |
Throwable | exception |
PageContext | pageContext | 
Object | page |
<br>

```java
final javax.servlet.jsp.PageContext pageContext;
javax.servlet.http.HttpSession session = null;
final javax.servlet.ServletContext application;
final javax.servlet.ServletConfig config;
javax.servlet.jsp.JspWriter out = null;
final java.lang.Object page = this;
javax.servlet.jsp.JspWriter _jspx_out = null;
javax.servlet.jsp.PageContext _jspx_page_context = null;
```

### JSP中的属性
----------------------
|  | servlet | JSP |
| ---- | --- | --- |
| 应用 | getServletContext.setAttribute("foo",obj); | application.setAttribute("foo",obj); |
| 请求 | request.setAttribute("foo",obj); | request.setAttribute("foo",obj); |
| 会话 | request.getSession.setAttribute("foo",obj); | session.setAttribute("foo",obj); |
| 页面 | 不适用 | pageContext.setAttribute("foo",obj); |

### 在JSP中禁用scriptlet脚本
-------------------
	<script-invalid>true</script-invalid>
	
### 忽略EL表达式
方式一：
```xml
<jsp-config>
	<jsp-property-group>
		<url-pattern>*.jsp</url-pattern>
		<el-ignored>true</el-ignored>
	</jsp-property-group>
</jsp-config>
```
方式二：
	<%@ page isELIgnored="true" %>
	
	
### <jsp:useBean>转为servlet的代码
-------------
jsp代码如下：
```jsp
<%-- Dog对象必须有一个无参的构造函数，属性必须有set、get方法 --%>
<%-- sc ope默认为page--%>
<jsp:useBean id="dog" class="com.example.model.Dog" scope="request">
	<jsp:setProperty name="dog" property="breed" value="zangao" />
</jsp:useBean>
Dog created by servlet : <jsp:getProperty name="dog" property="breed" />
```
servlet中的代码如下：
```java
com.example.model.Dog dog = null;
dog = (com.example.model.Dog) _jspx_page_context.getAttribute("dog", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
if (dog == null){
	dog = new com.example.model.Dog();
	_jspx_page_context.setAttribute("dog", dog, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
	out.write('\n');
	out.write('	');
	out.write('	');
	org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("dog"), "breed", "zangao", null, null, false);
	out.write('\n');
	out.write('	');
}
out.write("\n");
out.write("\n");
out.write("\tDog created by servlet : ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.example.model.Dog)_jspx_page_context.findAttribute("dog")).getBreed())));
```

***********
# EL表达式
------------------------
例子： ${person.name}  
**表达式中的第一个命名变量可以是一个隐式对象(requestScope、param等)，也可以是一个属性（或者说bean）**  
点号左边的变量要么是一个Map,要么是一个bean(有性质)。  

## EL隐式对象
 * pageScope
 * requestScope
 * sessionScope
 * applicationScope
 * param
 * paramValues
 * head
 * headValues
 * cookie
 * initParam  上下文初始化参数的Map
 * pageContext  只有这个不是映射，它是pageContext对象的实际引用
