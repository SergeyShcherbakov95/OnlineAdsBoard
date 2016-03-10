<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
			<sec:authorize access="isAnonymous()">
				<div id = "link2" >
					<p><a href = "${contextPath}/login" >Sign In</a></p>
				</div>
				<div id = "link3" >
    	    		<p><a href = "${contextPath}/register" >Sign Up</a></p> 
				</div>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_USER')">
				<div id = "link2" >
					<p><a href="${contextPath}/userInfo" >My info and Ads</a></p>
				</div>
				<div id = "link3" >
					<p><a href="${contextPath}/<c:url value='j_spring_security_logout' />" >Logout</a></p>
				</div>
			</sec:authorize>
		</div>
	</div>
	
	<div id = "bottom" >
		<form action="${contextPath}/addUser" method = "POST" enctype="multipart/form-data">
			<table>
            	<tr>
                	<td>Email:</td>
                	<td><input type='email' name='email' /></td>
            	</tr>
            	<tr>
                	<td>Password:</td>
                	<td><input type='password' name='password' /></td>
            	</tr>
            	<tr>
                	<td>Surname:</td>
                	<td><input type='text' name='surname' /></td>
            	</tr>
            	<tr>
                	<td>Name:</td>
                	<td><input type='text' name='name' /></td>
            	</tr>
            	<tr>
                	<td>Sex:</td>
                	<td><input type='radio' name='sex'  value='M' checked/>Man</td>
                	<td><input type='radio' name='sex'  value='W'/>Woman</td>
            	</tr>
            	<tr>
            		<td>User image:</td>
            		<td><input type='file' name='image' /></td>
            	</tr>
            	<tr>
                	<td colspan='2'><input name="submit" type="submit" value="Login" /></td>
            	</tr>
        	</table>
		</form>
	</div>	
  </body>
</html>