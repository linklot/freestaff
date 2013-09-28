<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/candidate/member.js"></script>
<div class="wrapper">
    <div id="pad">
        <h2>Payment History</h2>
        <span class="backward"><a href="#" id="closeLink">Close</a></span>
        <div class="clearFloat"></div>
        <div class="list">
            <ul>
                <c:forEach var="history" items="${user.candidate.paymentHistories}">
                    <li>
                        <c:out value="${history.description}"/>,
                        $<c:out value="${history.amount}"/>,
                        <c:out value="${history.friendlyDate}"/>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>