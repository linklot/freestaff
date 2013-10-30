<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/candidate/empHistory.js"></script>
<div class="wrapper">
    <div id="pad">
        <h2>Edit Employment History</h2>
        <span class="backward"><a href="/candidate">Back to Bio Page</a></span>
        <div class="clearFloat"></div>
        <form:form name="candidate" modelAttribute="candidate" method="post">
        <c:forEach var="empHistory" items="${empHistories}" varStatus="status">
        <input type="hidden" name="empHistories[${status.index}].id" value='<c:out value="${empHistory.id}"/>'/>
        <div class="row">
            <div class="key">
                <c:if test='${status.index==0}'>Current Employer</c:if>
                <c:if test='${status.index!=0}'>Previous Employer</c:if>
            </div>
            <div class="value">
                <input type="text" name="empHistories[${status.index}].name" value='<c:out value="${empHistory.name}"/>'/>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Location</div>
            <div class="value">
                <input type="text" name="empHistories[${status.index}].loc" value='<c:out value="${empHistory.loc}"/>'/>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Date Employed</div>
            <div class="value">
                <label for="from${status.index}">From</label>
                <select id='from_year_${status.index}' class="fromYear"></select>
                <select id='from_month_${status.index}' class="fromMonth"></select>
                <input type="hidden" id="from${status.index}" name="empHistories[${status.index}].from" value='<c:out value="${empHistory.from}"/>'/>
                <label for="to${status.index}">To</label>
                <select id='to_year_${status.index}' class="toYear"></select>
                <select id='to_month_${status.index}' class="toMonth"></select>
                <input type="hidden" id="to${status.index}" name="empHistories[${status.index}].to" value='<c:out value="${empHistory.to}"/>'/>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Job Title</div>
            <div class="longtxt"><input type="text" name="empHistories[${status.index}].jobTitle" value='<c:out value="${empHistory.jobTitle}"/>'/></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Duties/Responsibilities</div>
            <div class="longtxt"><textarea name="empHistories[${status.index}].duty"><c:out value="${empHistory.duty}"/></textarea></div>
            <div class="clearFloat"></div>
        </div>
        <div class="separator"></div>
        </c:forEach>
        <div class="opt_bar"><input type="submit" id="btnSubmit" value="Save"/></div>
        </form:form>
    </div>
</div>