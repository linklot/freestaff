<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/candidate/pwd.js"></script>
<div class="wrapper">
    <div id="pad">
        <h2>Change Password</h2>
        <span class="backward"><a href="/candidate">Back to Bio Page</a></span>
        <div class="clearFloat"></div>
        <form:form id="pwdForm" method="post" modelAttribute="user"><form:hidden path="id"/>
        <div class="row alpha">
            <div class="key">Old Password</div>
            <div class="value">
                <input type="password" id="pwd" name="password"/><label id="lbl_p" class="lbl" for="pwd"></label>
            </div>
        </div>
        <div class="row">
            <div class="key">New Password</div>
            <div class="value">
                <input type="password" id="n_pwd" name="n_pwd"/><label id="lbl_n" class="lbl" for="n_pwd"></label>
            </div>
        </div>
        <div class="row">
            <div class="key">Confirm Password</div>
            <div class="value">
                <input type="password" id="c_pwd" name="c_pwd"/><label id="lbl_c" class="lbl" for="c_pwd"></label>
            </div>
        </div>
        <div class="clearFloat"></div>
        <div class="opt_bar">
            <input type="submit" id="btnSubmit" value="Save"/>
            <c:if test="${msg eq 'n'}"><div class="msg err">Changing password failed. Please check your input.</div></c:if>
            <c:if test="${msg eq 'y'}"><div class="msg">Password changed!</div></c:if>
            <div class="clearFloat"></div>
        </div>
        </form:form>
    </div>
</div>