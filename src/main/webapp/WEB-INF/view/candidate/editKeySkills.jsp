<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/candidate/editKeySkills.js"></script>
<div class="wrapper">
    <div id="pad">
        <h2>Edit Key Skills</h2>
        <span class="backward"><a href="/candidate">Back to Bio Page</a></span>
        <div class="clearFloat"></div>
        <form:form id="skillsForm" method="post" modelAttribute="user">
        <form:hidden path="id"/>
        <div class="row">
            <div class="key">1</div>
            <div class="value"><form:input path="candidate.keySkill1" id="keySkill1"/><label id="lbl_1" class="lbl" for="keySkill1"></label></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">2</div>
            <div class="value"><form:input path="candidate.keySkill2" id="keySkill2"/><label id="lbl_2" class="lbl" for="keySkill2"></label></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">3</div>
            <div class="value"><form:input path="candidate.keySkill3" id="keySkill3"/><label id="lbl_3" class="lbl" for="keySkill3"></label></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">4</div>
            <div class="value"><form:input path="candidate.keySkill4" id="keySkill4"/><label id="lbl_4" class="lbl" for="keySkill4"></label></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="key">5</div>
            <div class="value"><form:input path="candidate.keySkill5" id="keySkill5"/><label id="lbl_5" class="lbl" for="keySkill5"></label></div>
            <div class="clearFloat"></div>
        </div>
        <div class="opt_bar">
            <input type="submit" id="btnSubmit" value="Save"/>
        </div>
        </form:form>
    </div>
</div>