<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>Spittr</title>

</head>
<body>
<h1>Register</h1>
<form:form method="POST" modelAttribute="spitter" enctype="multipart/form-data">
<s:message code="first.name" /> <form:input path="firstName" /><br/>
<s:message code="last.name" />  <form:input path="lastName" /><br/>
<s:message code="user.name" />  <form:input path="username" /><br/>
<s:message code="password" />   <form:password path="password" /><br/>
<s:message code="profile.picture" />
<input type="file" name="file" accept="image/jpeg,image/png,image/gif" /><br/>
<input type="submit" value="Register" />
</form:form>



<br/>
<a href="${contextPath}/spitters">Home</a>
</body>
</html>