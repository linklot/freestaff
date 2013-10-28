<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/candidate/editClassif.js"></script>
<div class="wrapper">
    <div id="pad">
        <form:form id="classifForm" method="post" modelAttribute="user"><form:hidden id="cid" name="cid" path="id"/>
        <h2>Edit Personal Information</h2>
        <span class="backward"><a href="/candidate">Back to Bio Page</a></span>
        <div class="clearFloat"></div>
        <div class="row alpha">
            <div class="key">Classification</div>
            <div class="value">
                <label for="classif">
                    <c:if test="${empty user.candidate.classif}">
                    ANY
                    </c:if>
                    <c:if test="${!empty user.candidate.classif}">
                    <c:out value="${user.candidate.classif}"/>
                    </c:if>
                </label>
                <select id="classif" name="classif">
                    <option value='0'>Any Classification</option>
                    <c:forEach var="classif" items="${classifs}">
                    <option value='<c:out value="${classif.id}"/>'><c:out value="${classif.name}"/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Sub Classification</div>
            <div class="value">
                <label for="subClassif">
                    <c:if test="${empty user.candidate.subClassif}">
                    ANY
                    </c:if>
                    <c:if test="${!empty user.candidate.subClassif}">
                    <c:out value="${user.candidate.subClassif}"/>
                    </c:if>
                </label>
                <select id="subClassif" name="subClassif">
                    <option value='0'>Any Sub-Classification</option>
                </select>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Country of Birth</div>
            <div class="value"><form:input path="candidate.birthCountry"/></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Current City</div>
            <div class="value"><form:input path="candidate.currCity"/></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Current Country</div>
            <div class="value"><form:input path="candidate.currCountry"/></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Current Visa Status</div>
            <div class="value">
                <form:select id="currVisaStatus" path="candidate.currVisaStatus">
                    <option value="0" <c:if test="${user.candidate.currVisaStatus eq '0'}">selected="selected"</c:if>>I NEED A VISA</option>
                    <option value="1" <c:if test="${user.candidate.currVisaStatus eq '1'}">selected="selected"</c:if>>I HAVE PERMANENT RESIDENCY</option>
                    <option value="2" <c:if test="${user.candidate.currVisaStatus eq '2'}">selected="selected"</c:if>>I HAVE A STATE SPONSORED VISA</option>
                    <option value="3" <c:if test="${user.candidate.currVisaStatus eq '3'}">selected="selected"</c:if>>I HAVE AN EMPLOYER SPONSORED VISA</option>
                    <option value="4" <c:if test="${user.candidate.currVisaStatus eq '4'}">selected="selected"</c:if>>I HAVE APPLIED FOR A VISA AND AM WAITING FOR A DECISION</option>
                </form:select>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Highest Qualification</div>
            <div class="value">
                <label for="highestQualif">
                    <c:if test="${!empty user.candidate.highestQualif}"><c:out value="${user.candidate.highestQualif}"/></c:if>
                </label>
                <form:select id="highestQualif" path="candidate.highestQualif">
                    <option value="Doctorate">Doctorate</option>
                    <option value="Masters Degree">Masters Degree</option>
                    <option value="Graduate Diploma">Graduate Diploma</option>
                    <option value="Graduate Certificate">Graduate Certificate</option>
                    <option value="Bachelor Degree">Bachelor Degree</option>
                    <option value="Diploma">Diploma</option>
                    <option value="Certificate">Certificate</option>
                    <option value="Apprenticeship">Apprenticeship</option>
                    <option value="Trade School Certificate">Trade School Certificate</option>
                    <option value="High School Certificate">High School Certificate</option>
                </form:select>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Name of Qualification</div>
            <div class="value"><form:input path="candidate.qualifName"/></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Can pay own airfare/relocation</div>
            <div class="value">
                <form:select id="airefare" path="candidate.canPayAirfare" class="noIndent">
                    <option value="1"<c:if test='${user.candidate.canPayAirfare}'> selected='selected'</c:if>>yes</option>
                    <option value="0"<c:if test='${!user.candidate.canPayAirfare}'> selected='selected'</c:if>>no</option>
                </form:select>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Can pay own visa costs</div>
            <div class="value">
                <form:select id="visacost" path="candidate.canPayVisaCost" class="noIndent">
                    <option value="1"<c:if test='${user.candidate.canPayVisaCost}'> selected='selected'</c:if>>yes</option>
                    <option value="0"<c:if test='${!user.candidate.canPayVisaCost}'> selected='selected'</c:if>>no</option>
                </form:select>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="opt_bar"><input type="submit" id="btnSubmit" value="Save"/></div>
        </form:form>
    </div>
</div>