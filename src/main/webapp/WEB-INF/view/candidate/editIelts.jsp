<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/candidate/editIelts.js"></script>
<div class="wrapper">
    <div id="pad">
        <h2>Edit IELTS Result</h2>
        <span class="backward"><a href="/candidate">Back to Bio Page</a></span>
        <div class="clearFloat"></div>
        <form:form id="ieltsForm" method="post" modelAttribute="user">
        <form:hidden path="id"/>
        <div class="row">
            <div class="key">Listening</div>
            <div class="value"><form:input path="candidate.listening" id="listening"/><label id="lbl_l" class="lbl" for="listening"></label></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Reading</div>
            <div class="value"><form:input path="candidate.reading" id="reading"/><label id="lbl_r" class="lbl" for="reading"></label></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Writing</div>
            <div class="value"><form:input path="candidate.writing" id="writing"/><label id="lbl_w" class="lbl" for="writing"></label></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Speaking</div>
            <div class="value"><form:input path="candidate.speaking" id="speaking"/><label id="lbl_s" class="lbl" for="speaking"></label></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">Overall</div>
            <div class="value"><form:input path="candidate.overall" id="overall"/><label id="lbl_o" class="lbl" for="overall"></label></div>
            <div class="clearFloat"></div>
        </div>
        <div class="opt_bar">
            <input type="submit" id="btnSubmit" value="Save"/>
        </div>
        </form:form>
    </div>
</div>