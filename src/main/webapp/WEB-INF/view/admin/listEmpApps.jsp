<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/res/js/admin/listEmpApps.js"></script>
<section id="main" class="column">
    <!-- <h4 class="alert_info">FreeStaff admin panel.</h4> -->

    <article class="module width_full">
        <header>
            <h3>Employer Applications</h3>
        </header>
        <div class="module_content">
            <table>
                <tr>
                    <th>Status</th>
                    <th>Name</th>
                    <th>ABN/ACN</th>
                    <th>Phone</th>
                    <th>Email</th>
                </tr>
                <c:forEach var="app" items="${pw.items}">
                <tr class="row" data-id='<c:out value="${app.id}"/>'>
                    <td>
                        <c:if test="${app.status=='1'}">In Queue</c:if>
                        <c:if test="${app.status=='2'}"><span class="accept">Accepted</span></c:if>
                        <c:if test="${app.status=='3'}"><span class="reject">Rejected</span></c:if>
                    </td>
                    <td><c:out value="${app.name}"/></td>
                    <td><c:out value="${app.number}"/></td>
                    <td><c:out value="${app.phone}"/></td>
                    <td><c:out value="${app.email}"/></td>
                </tr>
                </c:forEach>
            </table>
            <div class="clear"></div>
        </div>
        <footer>
            <div class="navi">
                <c:if test="${pw.currentPage > 1}"><a href='/admin/employerApplications/<c:out value="${pw.previousIndex}"/>/<c:out value="${pw.pageSize}"/>'>Previous Page</a></c:if>
                Page <c:out value="${pw.currentPage}"/> of <c:out value="${pw.pageCount}"/>, <c:out value="${pw.totalCount}"/> in total.
                <c:if test="${pw.currentPage < pw.pageCount}"><a href='/admin/employerApplications/<c:out value="${pw.nextIndex}"/>/<c:out value="${pw.pageSize}"/>'>Next Page</a></c:if>
            </div>
        </footer>
    </article>
</section>