<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/employer/searchResult.js"></script>
<section id="main" class="column">
    <article class="module width_full">
        <header>
            <h3>Search Result</h3>
        </header>
        <div class="module_content">
            <div class="criteria">
                <ul>
                    <c:if test="${c_k != ''}"><li><strong>Keywords:</strong> <c:out value="${c_k}"/></li></c:if>
                    <c:if test="${c_k == ''}"><li>No Keywords</li></c:if>
                    <c:if test="${c_c != ''}"><li><strong>Classification:</strong> <c:out value="${c_c}"/></li></c:if>
                    <c:if test="${c_c == ''}"><li>Any Classification.</li></c:if>
                    <c:if test="${c_s != ''}"><li><strong>Sub-Classification:</strong> <c:out value="${c_s}"/></li></c:if>
                    <c:if test="${c_s == ''}"><li>Any Sub-Classification.</li></c:if>
                </ul>
            </div>
            <div class="search_content">
                <table class="tablesorter">
                    <thead>
                        <tr>
                            <th>Candidate Name</th>
                            <th>Classification</th>
                            <th>Sub-Classification</th>
                            <th>Highest Qualification</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${candidates}">
                        <tr class="row_cand" data-id='<c:out value="${user.id}"/>'>
                            <td><c:out value="${user.candidate.firstName}"/> <c:out value="${user.candidate.lastName}"/></td>
                            <td><c:out value="${user.candidate.classif}"/></td>
                            <td><c:out value="${user.candidate.subClassif}"/></td>
                            <td><c:out value="${user.candidate.highestQualif}"/></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="clear"></div>
        <footer>
        </footer>
    </article>
</section>