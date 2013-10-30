<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="wrapper">
    <div id="pad">
        <h2>Employer Profile</h2>
        <span class="backward"><a href="#" onclick="Javascript:window.close();">Close Page</a></span>
        <div class="clearFloat"></div>
        <div class="row first">
            <div class="key">Name</div>
            <div class="value"><c:out value="${employer.name}"/></div>
        </div>
        <div class="row">
            <div class="key">Phone Number</div>
            <div class="value"><c:out value="${employer.phone}"/></div>
        </div>
        <div class="row">
            <div class="key">Email</div>
            <div class="value"><c:out value="${employer.email}"/></div>
        </div>
        <div class="row">
            <div class="key">Address</div>
            <div class="value">
                <c:out value="${employer.addrStreet}"/>,
                <c:out value="${employer.addrCity}"/>
                <c:out value="${employer.addrState}"/>
                <c:out value="${employer.zip}"/>,
                <c:out value="${employer.addrCountry}"/>
            </div>
        </div>
        <div class="row">
            <div class="key noborder">Statement</div>
            <div class="state_value"><div class="statement"><c:out value="${employer.statement}"/></div></div>
            <div class="clearFloat"></div>
        </div>
        <div class="clearFloat"></div>
    </div>
</div>