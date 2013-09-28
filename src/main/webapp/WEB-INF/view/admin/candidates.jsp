<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/admin/candidates.js"></script>
<section id="main" class="column">
    <article class="module width_full">
        <header>
            <h3>Candidates</h3>
        </header>
        <div class="module_content">
            <table>
                <tr>
                    <th>Name</th>
                    <th>Account</th>
                    <th>Date of Reg</th>
                </tr>
                <c:forEach var="user" items="${candWrapper.items}">
                <tr class="row" data-id='${user.id}'>
                    <td><c:out value="${user.candidate.firstName}"/> <c:out value="${user.candidate.lastName}"/></td>
                    <td><c:out value="${user.account}"/></td>
                    <td><c:out value="${user.friendlyRegDate}"/></td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <div class="clear"></div>
        <footer>
            <div class="navi">
                <c:if test='${candWrapper.currentPage!="1"}'><div class="pre"><a href='/admin/candidates/<c:out value="${candWrapper.previousIndex}"/>/<c:out value="${candWrapper.pageSize}"/>'>&lt;&lt; Previous</a></div></c:if>
                <div class="info">Page <c:out value="${candWrapper.currentPage}"/> of <c:out value="${candWrapper.pageCount}"/></div>
                <c:if test='${candWrapper.currentPage!=candWrapper.pageCount}'><div class="next"><a href='/admin/candidates/<c:out value="${candWrapper.nextIndex}"/>/<c:out value="${candWrapper.pageSize}"/>'>Next &gt;&gt;</a></div></c:if>
                <div class="clearFloat"></div>
                <div class="count"><c:out value="${candWrapper.totalCount}"/> in total</div>
            </div>
        </footer>
    </article>
</section>