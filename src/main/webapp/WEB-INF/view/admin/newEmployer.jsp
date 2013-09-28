<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/admin/newEmployer.js"></script>
<section id="main" class="column">

    <article class="module width_full">
        <header>
            <h3>Add New Employer</h3>
        </header>
        <form:form modelAttribute="newUser" id="userForm" name="newUser">
        <div class="module_content">
            <div class="row">
                <div class="key">Account</div>
                <div class="value">
                    <form:input id="account" path="account"/>
                    <label id="lbl_a" for="account" class="lbl"></label>
                </div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">Password</div>
                <div class="value">
                    <form:input id="pwd" path="password"/>
                    <label id="lbl_p" for="pwd" class="lbl"></label>
                </div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">Name</div>
                <div class="value"><form:input id="name" path="employer.name"/></div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">Phone</div>
                <div class="value"><form:input id="phone" path="employer.phone"/></div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">Email</div>
                <div class="value"><form:input id="email" path="employer.email"/></div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">Address</div>
                <div class="value"><form:input id="addrStreet" path="employer.addrStreet"/></div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">City</div>
                <div class="value"><form:input id="addrCity" path="employer.addrCity"/></div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">State</div>
                <div class="value"><form:input id="addrState" path="employer.addrState"/></div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">Country</div>
                <div class="value"><form:input id="addrCountry" path="employer.addrCountry"/></div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">Postcode</div>
                <div class="value"><form:input id="zip" path="employer.zip"/></div>
                <div class="clear"></div>
            </div>
            <div class="row">
                <div class="key">Statement</div>
                <div class="value txtArea"><form:textarea id="statement" path="employer.statement"/></div>
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
</section>