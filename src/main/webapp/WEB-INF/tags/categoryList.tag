<%@ attribute name="root" required="true" type="com.iceroom.fundamental.viewmodel.CategoryViewModel" %>
<%@ attribute name="delimiter" required="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ice" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${!empty root}">
    <div class="row">
        <c:if test="${delimiter!='&nbsp;&nbsp;'}"><c:out value="${delimiter}" escapeXml="false"/></c:if>
        <c:out value="${root.name}" />
    </div>
        <c:forEach var="item" items="${root.children}">
            <ice:categoryList root="${item}" delimiter="${delimiter}${delimiter}"/>
        </c:forEach>
</c:if>