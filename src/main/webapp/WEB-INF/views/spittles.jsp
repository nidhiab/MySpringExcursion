<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:forEach items="${spittleList}" var="spittle" >
<li id='spittle_<c:out value="spittle.id"/>'>
<div style="display:inline">
<c:out value="${spittle.message}" />
</div>
<div style="display:inline">
<c:out value="${spittle.time}" />
(<c:out value="${spittle.latitude}" />,
<c:out value="${spittle.longitude}" />)
</div>
</li>
</c:forEach>

<div style="display:block;margin-top:50px;">
<div>
<a href="${contextPath}/spittles/new/<c:out value='${spitterid}'/>/<c:out value='${username}'/>">Create Spittle</a>
</div>
<div style="display:inline;margin-top:30px;">
<a href="${contextPath}/spitters/spitter/<c:out value='${username}'/>">Back</a>
</div>
</div>
