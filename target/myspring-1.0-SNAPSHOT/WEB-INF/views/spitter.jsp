<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1>Your Profile</h1>
<c:out value="${spitter.username}" /><br/>
<c:out value="${spitter.firstName}" />
<c:out value="${spitter.lastName}" />
<br/>

<div style="display:block;margin-top:30px;">
<a href="${contextPath}/spittles/<c:out value='${spitter.id}'/>/<c:out value='${spitter.username}'/>">My Spittles</a>
</div>
<div style="display:block;margin-top:30px;">
<a href="${contextPath}/spitters">Home</a>
</div>