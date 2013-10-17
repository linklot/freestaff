<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/candidate/nameEmail.js"></script>
<div class="wrapper">
    <div id="pad">
        <h2>Modify Name &amp; Email</h2>
        <span class="backward"><a href="/candidate">Back to Bio Page</a></span>
        <div class="clearFloat"></div>
        <form:form modelAttribute="user" id="nameForm"><form:hidden path="id"/><form:hidden path="candidate.id"/>
        <div class="row">
            <div class="key">First Name</div>
            <div class="value">
                <form:input path="candidate.firstName" id="firstname"/>
                <label for="firstname" id="lbl_fname"></label>
            </div>
        </div>
        <div class="row">
            <div class="key">Last Name</div>
            <div class="value">
                <form:input path="candidate.lastName" id="lastname"/>
                <label for="lastname" id="lbl_lname"></label>
            </div>
        </div>
        <div class="row">
            <div class="key">Email</div>
            <div class="value">
                <form:input path="candidate.email" id="email"/>
                <label for="email" id="lbl_email"></label>
            </div>
        </div>
        <div class="clearFloat"></div>
        <div class="opt_bar">
            <input type="submit" id="btnSubmit" value="Save"/>
        </div>
        </form:form>
    </div>
</div>