<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/admin/empApp.js"></script>
<section id="main" class="column">
    <article class="module width_full">
        <form:form id="form0" modelAttribute="employer" action="/admin/handleEmpApp">
        <header>
            <h3>Employer Application</h3>
            <input type="hidden" name="app_id" value='<c:out value="${application.id}"/>'/>
        </header>
        <div class="module_content">
            <div class="row">
                <div class="key">Name</div>
                <div class="val"><input type="text" id="name" name="name" value='<c:out value="${employer.name}"/>'/></div>
            </div>
            <div class="row">
                <div class="key">ABN/ACN</div>
                <div class="val"><c:out value="${application.number}"/></div>
            </div>
            <div class="row">
                <div class="key">Phone</div>
                <div class="val"><input type="text" id="phone" name="phone" value='<c:out value="${employer.phone}"/>'/></div>
            </div>
            <div class="row">
                <div class="key">Email</div>
                <div class="val"><input type="text" id="email" name="email" value='<c:out value="${employer.email}"/>'/></div>
            </div>
            <div class="row">
                <div class="key">Address</div>
                <div class="val"><input type="text" id="addrStreet" name="addrStreet" value='<c:out value="${employer.addrStreet}"/>'/></div>
            </div>
            <div class="row">
                <div class="key">City</div>
                <div class="val"><input type="text" id="addrCity" name="addrCity" value='<c:out value="${employer.addrCity}"/>'/></div>
            </div>
            <div class="row">
                <div class="key">State</div>
                <div class="val"><input type="text" id="addrState" name="addrState" value='<c:out value="${employer.addrState}"/>'/></div>
            </div>
            <div class="row">
                <div class="key">postcode</div>
                <div class="val"><input type="text" id="zip" name="zip" value='<c:out value="${employer.zip}"/>'/></div>
            </div>
            <div class="row">
                <div class="key">Country</div>
                <div class="val"><input type="text" id="addrCountry" name="addrCountry" value='<c:out value="${employer.addrCountry}"/>'/></div>
            </div>
            <div class="row">
                <div class="key statement">Statement</div>
                <div class="val statement"><textarea id="statement" name="statement"><c:out value="${employer.statement}"/></textarea></div>
            </div>
            <div class="row">
                <div class="key">Apply Date</div>
                <div class="val"><c:out value="${application.friendlyApplyTime}"/></div>
            </div>
            <div class="clear"></div>
            <div class="sep_line"></div>
            <div class="row">
                <div class="key">Account</div>
                <div class="val">
                    <input type="text" id="account" name="account" class="narrow"/>
                    <label id="lbl_account" for="account"></label>
                </div>
            </div>
            <div class="row">
                <div class="key">Password</div>
                <div class="val">
                    <input type="text" id="password" name="password" class="narrow"/>
                    <label id="lbl_password" for="password"></label>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <footer>
            <div class="submit_link">
                <input type="button" id="accept" value="Accept" class="alt_btn"/>
                <input type="button" id="refuse" value="Refuse"/>
                <input type="hidden" id="decision" name="decision" />
            </div>
        </footer>
        </form:form>
    </article>
</section>