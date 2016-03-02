<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page session="false" %>
<html>
  <head>
    <title>${ad.getTitle()}</title>
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
		<p>${ad.getTitle()} - ${ad.getPrice()}$</p>
		<p><img src="<c:url value="${ad.getAdImage().getPathToImage()}" />" /></p>
		<p>Description:</p>
		<p>		${ad.getDescription()}</p>
		<p>Views : ${ad.getViews()}</p>
		<p>${ad.getIdAd()}</p>
		<p>Region : ${ad.getRegion()}</p>
		<p>City : ${ad.getCity()}</p>
		<hr width = "70%" align = "left" />
		<p>${ad.getUserAd().getSurname()} ${ad.getUserAd().getName()}</p>
		<p><a href = "${contextPath}/ads/user/${ad.getUserAd().getIdUser()}" > Other ads of user</a></p>
		<p>${ad.getPhoneNumber()}</p>
	</div>	
  </body>
</html>