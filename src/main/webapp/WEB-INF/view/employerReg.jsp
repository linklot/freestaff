<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/res/js/employerReg.js"></script>
<section id="content">
    <div id="title">Employer Registration</div>
    <p>
        Please fill up the form below and submit it. We will contact you as soon as possible.
    </p>
    <form:form id="app_form" modelAttribute="employerApplication">
    <div class="row">
        <div class="key">Company Name:</div>
        <div class="value">
            <form:input path="name"/>
            <label for="name" id="lbl_name"></label>
        </div>
    </div>
    <div class="row">
        <div class="key">ABN / ACN Number:</div>
        <div class="value">
            <form:input path="number"/>
            <label for="number" id="lbl_number"></label>
        </div>
    </div>
    <div class="row">
        <div class="key">Phone:</div>
        <div class="value">
            <form:input path="phone"/>
            <label for="phone" id="lbl_phone"></label>
        </div>
    </div>
    <div class="row">
        <div class="key">Email:</div>
        <div class="value">
            <form:input path="email"/>
            <label for="email" id="lbl_email"></label>
        </div>
    </div>
    <div class="row">
        <div class="key">Address:</div>
        <div class="value">
            <form:input path="address"/>
            <label for="address" id="lbl_address"></label>
        </div>
    </div>
    <div class="row">
        <div class="key">City:</div>
        <div class="value">
            <form:input path="city"/>
            <label for="city" id="lbl_city"></label>
        </div>
    </div>
    <div class="row">
        <div class="key">State:</div>
        <div class="value">
            <form:input path="state"/>
            <label for="state" id="lbl_state"></label>
        </div>
    </div>
    <div class="row">
        <div class="key">Postcode:</div>
        <div class="value">
            <form:input path="postcode"/>
            <label for="postcode" id="lbl_postcode"></label>
        </div>
    </div>
    <div class="row">
        <div class="key">Country:</div>
        <div class="value">
            <form:input path="country"/>
            <label for="country" id="lbl_country"></label>
        </div>
    </div>
    <div class="row">
        <div class="key statement">Statement:</div>
        <div class="value statement">
            <form:textarea path="statement"/>
        </div>
    </div>
    <div class="clearFloat"></div>
    <div class="opbar">
        <c:if test="${msg==''}"><input type="submit" value="Submit"/></c:if>
        <c:if test="${msg!=''}">
            <span class="msg">Your application has been saved. We will be in contact with you soon.</span>
        </c:if>
    </div>
    </form:form>
</section>