<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page session="false" %>
<html>
  <head>
    <title>Home page</title>
    <link type ="text/css"  rel ="stylesheet"  href ="<c:url value="/resources/css/index.css" />"  />
  </head>
  <body>
  	<div id = "top" >
		<div id = "links" >
			<div id = "link1" >
				<p><a href = "${contextPath}/" >Home</a></p>
			</div>
			<div id = "link2" >
				<p><a href = "${contextPath}/ad/1" >Sign In</a></p>
			</div>
			<div id = "link3" >
    	    	<p><a href = "${contextPath}/categories/1" >Sign Up</a></p> 
			</div>
		</div>
	</div>
	
	<div id = "bottom" >
    	<h3>Login with Email and Password</h3>
    	<c:if test = "${not empty error}">
    		<p><span style="color: #cc0000;">${error}</span></p>
    	</c:if>
    	<c:url var="loginUrl" value="/j_spring_security_check"></c:url>
    	<form action="${loginUrl}" method="POST">
        	<table>
            	<tr>
                	<td>Email:</td>
                	<td><input type='text' name='email' /></td>
            	</tr>
            	<tr>
                	<td>Password:</td>
                	<td><input type='password' name='password' /></td>
            	</tr>
            	<tr>
                	<td colspan='2'><input name="submit" type="submit"
                    	value="Login" /></td>
            	</tr>
        	</table>
    	</form>
    </div>
</body>
</html>