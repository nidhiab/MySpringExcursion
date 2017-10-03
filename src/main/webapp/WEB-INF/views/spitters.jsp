

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<c:forEach items="${spitterList}" var="spitter" >
<li id='spitter_<c:out value="${spitter.id}"/>'>
<div style="display:inline;">
<a href="spitters/spitter/<c:out value='${spitter.username}'/>"><c:out value="${spitter.username}" /></a>
</div>
</li>
</c:forEach>

<s:url value="spitters/register" var="registerUrl" />
<a href="${registerUrl}">Register</a>
