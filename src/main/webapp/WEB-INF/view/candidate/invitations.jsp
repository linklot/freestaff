<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/candidate/invitations.js"></script>
<div class="wrapper">
    <div id="pad">
        <h2>Your Invitations</h2>
        <span class="backward"><a href="/candidate">Back to Bio Page</a></span>
        <div class="clearFloat"></div>
        <c:forEach var="invi" items="${invitations}" varStatus="status">
        <div class="invi">
            <div class="row">
                <div class="key">Employer Name</div>
                <div class="value"><c:out value="${invi.employer.name}"/></div>
                <div class="clearFloat"></div>
            </div>
            <div class="row">
                <div class="key">Time of Sending</div>
                <div class="value"><c:out value="${invi.friendlySendDate}"/></div>
                <div class="clearFloat"></div>
            </div>
            <div class="row">
                <div class="key">Status</div>
                <div class="value">
                    <c:choose>
                        <c:when test="${invi.status=='1'}"><div class="s1">SENT</div></c:when>
                        <c:when test="${invi.status=='2'}"><div class="s2">VIEWED</div></c:when>
                        <c:when test="${invi.status=='3'}"><div class="s3">DECLINED</div></c:when>
                        <c:when test="${invi.status=='4'}"><div class="s4">ACCEPTED</div></c:when>
                        <c:when test="${invi.status=='5'}"><div class="s5">CLOSED</div></c:when>
                        <c:when test="${invi.status=='6'}"><div class="s6">WITHDRAWN</div></c:when>
                    </c:choose>
                </div>
                <div class="clearFloat"></div>
            </div>
            <c:if test="${invi.status=='4'}"><div class="row"><input type="button" id="btn_employer" value="View Employer Profile" data-id='<c:out value="${invi.id}"/>'/></div></c:if>
            <div class="opt_bar">
                <c:if test="${invi.status=='2'}"><input type="button" id="btn_accept" value="Accept Invitation" data-id='<c:out value="${invi.id}"/>'/></c:if>
                <c:if test="${invi.status=='3'}"><input type="button" id="btn_accept" value="Accept Invitation" data-id='<c:out value="${invi.id}"/>'/></c:if>
                <c:if test="${invi.status=='2'}"><input type="button" id="btn_decline" value="Decline" data-id='<c:out value="${invi.id}"/>'/></c:if>
                <c:if test="${invi.status=='4'}"><input type="button" id="btn_decline" value="Decline" data-id='<c:out value="${invi.id}"/>'/></c:if>
            </div>
            <div class="clearFloat"></div>
            <c:if test="${!status.last}"><div class="separator"></div></c:if>
        </div>
        </c:forEach>
    </div>
</div>