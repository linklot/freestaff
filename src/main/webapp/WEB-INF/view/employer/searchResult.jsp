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
                <div class="left">
                <ul>
                    <c:if test="${!empty c_k}"><li><strong>Keywords:</strong> <c:out value="${c_k}"/></li></c:if>
                    <c:if test="${empty c_k}"><li>No Keywords</li></c:if>
                    <c:if test="${!empty c_c}"><li><strong>Classification:</strong> <c:out value="${c_c}"/></li></c:if>
                    <c:if test="${empty c_c}"><li>Any Classification</li></c:if>
                    <c:if test="${!empty c_s}"><li><strong>Sub-Classification:</strong> <c:out value="${c_s}"/></li></c:if>
                    <c:if test="${empty c_s}"><li>Any Sub-Classification</li></c:if>
                    <c:if test="${!empty birthCountry}"><li><strong>Country of Birth:</strong> <c:out value="${birthCountry}"/></li></c:if>
                    <c:if test="${empty birthCountry}"><li>Any Country of Birth</li></c:if>
                    <c:if test="${!empty currCity}"><li><strong>Current City:</strong> <c:out value="${currCity}"/></li></c:if>
                    <c:if test="${empty currCity}"><li>Any Current City</li></c:if>
                    <c:if test="${!empty currCountry}"><li><strong>Current Country:</strong> <c:out value="${currCountry}"/></li></c:if>
                    <c:if test="${empty currCountry}"><li>Any Current Country.</li></c:if>
                </ul>
                </div>
                <div class="right">
                <ul>
                    <c:if test="${currVisaStatus=='9'}"><li>Any Current Visa Status</li></c:if>
                    <c:if test="${currVisaStatus=='0'}"><li><strong>Current Visa Status:</strong> Need a Visa</li></c:if>
                    <c:if test="${currVisaStatus=='1'}"><li><strong>Current Visa Status:</strong> Have Permanent Residency</li></c:if>
                    <c:if test="${currVisaStatus=='2'}"><li><strong>Current Visa Status:</strong> Have a State Sponsored Visa</li></c:if>
                    <c:if test="${currVisaStatus=='3'}"><li><strong>Current Visa Status:</strong> Have an Employer Sponsored Visa</li></c:if>
                    <c:if test="${currVisaStatus=='4'}"><li><strong>Current Visa Status:</strong> Have Applied for a Visa and Waiting for a Decision</li></c:if>
                    <c:if test="${!highestQualif=='9'}"><li><strong>Highest Qualification:</strong> <c:out value="${highestQualif}"/></li></c:if>
                    <c:if test="${highestQualif=='9'}"><li>Any Highest Qualification</li></c:if>
                    <c:if test="${!empty qualifName}"><li><strong>Name of Qualification:</strong> <c:out value="${qualifName}"/></li></c:if>
                    <c:if test="${empty qualifName}"><li>Any Qualification Name</li></c:if>
                    <c:if test="${canPayAirfare=='9'}"><li>Can pay own airfare/relocation: Any</li></c:if>
                    <c:if test="${canPayAirfare=='1'}"><li><strong>Can pay own airfare/relocation:</strong> Yes</li></c:if>
                    <c:if test="${canPayAirfare=='0'}"><li><strong>Can pay own airfare/relocation:</strong> No</li></c:if>
                    <c:if test="${canPayVisaCost=='9'}"><li>Can pay own visa costs: Any</li></c:if>
                    <c:if test="${canPayVisaCost=='1'}"><li><strong>Can pay own visa costs:</strong> Yes</li></c:if>
                    <c:if test="${canPayVisaCost=='0'}"><li><strong>Can pay own visa costs:</strong> No</li></c:if>
                </ul>
                </div>
                <div class="clear"></div>
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