<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/employer/invitations.js"></script>
<section id="main" class="column">
    <article class="module width_full">
        <header>
            <h3>Invitations</h3>
        </header>
        <div class="module_content">
            <c:forEach var="invi" items="${invitations}">
            <div class="invi">
                <div class="avatar"><img src="${invi.candidate.picUrl}" class="img"/></div>
                <div class="cand">
                    <div class="row">
                        <div class="key">Candidate Name</div>
                        <div class="value"><c:out value="${invi.candidate.firstName}"/> <c:out value="${invi.candidate.lastName}"/></div>
                    </div>
                    <div class="row">
                        <div class="key">Classification</div>
                        <div class="value"><c:out value="${invi.candidate.classif}"/></div>
                    </div>
                    <div class="row">
                        <div class="key">Sub-Classification</div>
                        <div class="value"><c:out value="${invi.candidate.subClassif}"/></div>
                    </div>
                    <div class="row">
                        <div class="key">Date</div>
                        <div class="value"><c:out value="${invi.friendlySendDate}"/></div>
                    </div>
                    <div class="clear"></div>
                    <div class="stats_row">
                        <div class="key">Invitation Status</div>
                        <div class="value">
                            <c:choose>
                                <c:when test="${invi.status=='1'}">SENT</c:when>
                                <c:when test="${invi.status=='2'}">VIEWED</c:when>
                                <c:when test="${invi.status=='3'}">DECLINED</c:when>
                                <c:when test="${invi.status=='4'}">ACCEPTED</c:when>
                                <c:when test="${invi.status=='5'}">CLOSED</c:when>
                                <c:when test="${invi.status=='6'}">WITHDRAWN</c:when>
                            </c:choose>
                            <c:if test="${invi.status=='4' || invi.status=='5'}">
                            <input type="button" class="btn_cand" value="Candidate Profile" data-id='<c:out value="${invi.candidate.user.id}"/>'/>
                            </c:if>
                        </div>
                    </div>
                    <div class="clear"></div>
                    <div class="op_row">
                        <c:if test="${invi.status!='6'}"><input type="button" class="withdraw" value="Withdraw" data-id='<c:out value="${invi.id}"/>'/></c:if>
                        <c:if test="${(invi.status=='5') || (invi.status=='6')}"><input type="button" class="resend" value="Re-send" data-id='<c:out value="${invi.id}"/>'/></c:if>
                        <input type="button" class="close" value="Close" data-id='<c:out value="${invi.id}"/>'/>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            </c:forEach>
        </div>
    </article>
</section>