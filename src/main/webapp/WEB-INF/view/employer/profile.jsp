<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/employer/profile.js"></script>
<section id="main" class="column">
    <article class="module width_full">
        <header>
            <h3>Edit Profile</h3>
        </header>
        <form:form modelAttribute="user" id="userForm" name="user">
        <form:hidden path="id"/>
        <div class="module_content">
            <div class="row">
                <div class="key">Name</div>
                <div class="value">
                    <form:input path="employer.name" id="name"/>
                    <label id="lbl_n" for="name" class="lbl"></label>
                </div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">Phone</div>
                <div class="value">
                    <form:input path="employer.phone"/>
                </div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">Email</div>
                <div class="value">
                    <form:input path="employer.email"/>
                </div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">Street</div>
                <div class="value">
                    <form:input path="employer.addrStreet"/>
                </div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">City</div>
                <div class="value">
                    <form:input path="employer.addrCity"/>
                </div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">State</div>
                <div class="value">
                    <form:input path="employer.addrState"/>
                </div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">Postcode</div>
                <div class="value">
                    <form:input path="employer.zip"/>
                </div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">Country</div>
                <div class="value">
                    <form:input path="employer.addrCountry"/>
                </div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">Statement</div>
                <div class="txtarea">
                    <form:textarea path="employer.statement"/>
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