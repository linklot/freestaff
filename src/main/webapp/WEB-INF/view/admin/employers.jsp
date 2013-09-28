<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/admin/employers.js"></script>
<section id="main" class="column">
    <article class="module width_full">
        <header>
            <h3>Employers</h3>
        </header>
        <div class="module_content">
            <table>
                <tr>
                    <th>Name</th>
                    <th>Account</th>
                    <th>Date of Reg</th>
                </tr>
                <c:forEach var="user" items="${empWrapper.items}">
                <tr class="row" data-id='${user.id}'>
                    <td><c:out value="${user.employer.name}"/></td>
                    <td><c:out value="${user.account}"/></td>
                    <td><c:out value="${user.friendlyRegDate}"/></td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <div class="clear"></div>
        <footer>
            <div class="navi">
                <c:if test='${empWrapper.currentPage!="1"}'><div class="pre"><a href='/admin/employers/<c:out value="${empWrapper.previousIndex}"/>/<c:out value="${empWrapper.pageSize}"/>'>&lt;&lt; Previous</a></div></c:if>
                <div class="info">Page <c:out value="${empWrapper.currentPage}"/> of <c:out value="${empWrapper.pageCount}"/></div>
                <c:if test='${empWrapper.currentPage!=empWrapper.pageCount}'><div class="next"><a href='/admin/employers/<c:out value="${empWrapper.nextIndex}"/>/<c:out value="${empWrapper.pageSize}"/>'>Next &gt;&gt;</a></div></c:if>
                <div class="count"><c:out value="${empWrapper.totalCount}"/> in total</div>
                <div class="clearFloat"></div>
            </div>
        </footer>
    </article>
</section>