<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/admin/employer.js"></script>
<section id="main" class="column">
    <article class="module width_full">
        <header>
            <h3>Employer</h3>
        </header>
        <form:form id="emp_form" modelAttribute="user" name="user" path="user" action="/admin/employer">
        <form:hidden path="id"/>
        <div class="module_content">
            <div class="row">
                <div class="key">Account</div>
                <div class="value"><c:out value="${user.account}"/></div>
            </div>
            <div class="row">
                <div class="key">Name</div>
                <div class="value"><form:input path="employer.name"/></div>
            </div>
            <div class="row">
                <div class="key">Phone</div>
                <div class="value"><form:input path="employer.phone"/></div>
            </div>
            <div class="row">
                <div class="key">Email</div>
                <div class="value"><form:input path="employer.email"/></div>
            </div>
            <div class="row">
                <div class="key">Address</div>
                <div class="value"><form:input path="employer.addrStreet"/></div>
            </div>
            <div class="row">
                <div class="key">City</div>
                <div class="value"><form:input path="employer.addrCity"/></div>
            </div>
            <div class="row">
                <div class="key">State</div>
                <div class="value"><form:input path="employer.addrState"/></div>
            </div>
            <div class="row">
                <div class="key">Country</div>
                <div class="value"><form:input path="employer.addrCountry"/></div>
            </div>
            <div class="row">
                <div class="key">Postcode</div>
                <div class="value"><form:input path="employer.zip"/></div>
            </div>
            <div class="row">
                <div class="key">Statement</div>
                <div class="value txtArea"><form:textarea path="employer.statement"/></div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
        <footer>
            <div class="submit_link">
                <input type="submit" value="Update Profile" class="alt_btn"/>
            </div>
        </footer>
        </form:form>
    </article>
</section>