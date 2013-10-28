<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/candidate/editSkillAssess.js"></script>
<div class="wrapper">
    <div id="pad">
        <h2>Edit Skills Assessment</h2>
        <span class="backward"><a href="/candidate">Back to Bio Page</a></span>
        <div class="clearFloat"></div>
        <form:form id="skillForm" method="post" modelAttribute="user">
        <form:hidden path="id"/>
        <div class="row">
            <div class="key">Skill Assessment</div>
            <div class="value">
                <form:select id="skillAssess" path="candidate.skillAssess">
                    <option value="1"<c:if test='${user.candidate.skillAssess}'> selected='selected'</c:if>>yes</option>
                    <option value="0"<c:if test='${!user.candidate.skillAssess}'> selected='selected'</c:if>>no</option>
                </form:select>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Assessment Authority</div>
            <div class="value"><form:input path="candidate.assessAuth" id="auth"/><label id="lbl_auth" class="lbl" for="auth"></label></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Date of Skill Assessment</div>
            <div class="value"><form:input path="candidate.assessDate" id="date"/><label id="lbl_date" class="lbl" for="date"></label></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Reference Number</div>
            <div class="value"><form:input path="candidate.assessRefNo" id="refNo"/><label id="lbl_refNo" class="lbl" for="refNo"></label></div>
            <div class="clearFloat"></div>
        </div>
        <div class="opt_bar">
            <input type="submit" id="btnSubmit" value="Save"/>
        </div>
        </form:form>
    </div>
</div>