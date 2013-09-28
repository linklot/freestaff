<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/admin/pwd.js"></script>
<section id="main" class="column">
    <article class="module width_full">
        <header>
            <h3>Change Password</h3>
        </header>
        <form:form modelAttribute="user" id="userForm" name="user">
        <form:hidden path="id"/>
        <div class="module_content">
            <div class="row">
                <div class="key">Old Password</div>
                <div class="value">
                    <form:password path="password" id="pwd"/>
                    <label id="lbl_p" for="pwd" class="lbl"></label>
                </div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">New Password</div>
                <div class="value">
                    <input type="password" id="n_pwd" name="newPwd"/>
                    <label id="lbl_n" for="nv_pwd" class="lbl"></label>
                </div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">Confirm Password</div>
                <div class="value">
                    <input type="password" id="c_pwd" name="confirmPwd"/>
                    <label id="lbl_c" for="c_pwd" class="lbl"></label>
                </div>
                <div class="clear"></div>
            </div>
        </div>
        <div class="clear"></div>
        <footer>
            <div class="submit_link">
                <input type="submit" value="Save" class="alt_btn"/> 
            </div>
        </footer>
        </form:form>
    </article>
    <c:if test="${msg eq 'n'}"><h4 class="alert_error">An Error occurred when changing password. Please check input.</h4></c:if>
    <c:if test="${msg eq 'y'}"><h4 class="alert_success">Password changed.</h4></c:if>
</section>