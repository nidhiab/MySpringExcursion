<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>Spittr</title>

</head>
<body>
<h1>Spittle</h1>
<form method="POST">
Message: <input type="text" name="message" /><br/>
<input type="hidden" name="spitterid"><c:out value='${spitterid}'/></input><br/>
<input type="submit" value="Create" />
</form>

<br/>
<a href="${contextPath}/spittles/<c:out value='${spitterid}'/>/<c:out value='${username}'/>">Back</a>
</body>
</html>