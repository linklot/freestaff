<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/res/js/admin/feedbacks.js"></script>
<section id="main" class="column">
    <article class="module width_full">
        <header>
            <h3>Feedbacks</h3>
        </header>
        <div class="module_content">
            <c:forEach var="feedback" items="${pw.items}">
            <div class="row">
                <div class="account"><c:out value="${feedback.user.account}"/></div>
                <div class="email">
                    <c:if test="${not empty feedback.user.employer}"><c:out value="${feedback.user.employer.email}"/></c:if>
                    <c:if test="${not empty feedback.user.candidate}"><c:out value="${feedback.user.candidate.email}"/></c:if>
                </div>
                <div class="time"><c:out value="${feedback.friendlyTime}"/></div>
                <div class="op"><a class="trigger" href="#" data-id='<c:out value="${feedback.id}"/>'>show/Hide</a></div>
                <div class="clear"></div>
                <div id='<c:out value="${feedback.id}"/>' class="content">
                    <p><c:out value="${feedback.content}"/></p>
                </div>
            </div>
            </c:forEach>
        </div>
        <footer>
            <div class="navi">
                <c:if test="${pw.currentPage > 1}"><a href='/admin/feedbacks/<c:out value="${pw.previousIndex}"/>/<c:out value="${pw.pageSize}"/>'>Previous Page</a></c:if>
                Page <c:out value="${pw.currentPage}"/> of <c:out value="${pw.pageCount}"/>, <c:out value="${pw.totalCount}"/> in total.
                <c:if test="${pw.currentPage < pw.pageCount}"><a href='/admin/feedbacks/<c:out value="${pw.nextIndex}"/>/<c:out value="${pw.pageSize}"/>'>Next Page</a></c:if>
            </div>
        </footer>
    </article>
</section>