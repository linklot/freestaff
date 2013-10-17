<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="content">
    <div id="title">Password Reset</div>
    <div id="note">
        <c:if test="${msg=='success'}">
            <p class="success">Your new password has been sent to your email address. Please check.</p>
            <p>Your account is <strong><c:out value="${account}"/></strong></p>
        </c:if>
        <c:if test="${msg=='fail'}">
            <p class="fail">Your account/email is wrong. Please check your input and try again.</p>
            <p></p>
        </c:if>
        <p>Click <a href="/">here</a> to return to front page.</p>
    </div>
</section>