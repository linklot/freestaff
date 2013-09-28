<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="wrapper">
    <div id="pad">
        <h2>Edit Education History</h2>
        <span class="backward"><a href="/candidate">Back to Bio Page</a></span>
        <div class="clearFloat"></div>
        <form:form name="candidate" modelAttribute="candidate" method="post">
        <c:forEach var="eduHistory" items="${eduHistories}" varStatus="status">
        <input type="hidden" name="eduHistories[${status.index}].id" value='<c:out value="${eduHistory.id}"/>'/>
        <div class="row">
            <div class="key">Qualification</div>
            <div class="value">
                <input type="text" name="eduHistories[${status.index}].qualifType" value='<c:out value="${eduHistory.qualifType}"/>'/>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">University/College</div>
            <div class="value">
                <input type="text" name="eduHistories[${status.index}].uni" value='<c:out value="${eduHistory.uni}"/>'/>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Location</div>
            <div class="value">
                <input type="text" name="eduHistories[${status.index}].loc" value='<c:out value="${eduHistory.loc}"/>'/>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Date Completed</div>
            <div class="value">
                <input type="text" name="eduHistories[${status.index}].complDate" value='<c:out value="${eduHistory.complDate}"/>'/>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="separator"></div>
        </c:forEach>
        <div class="opt_bar">
            <input type="submit" id="btnSubmit" value="Save"/>
        </div>
        </form:form>
    </div>
</div>