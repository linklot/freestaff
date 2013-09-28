<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="wrapper">
    <div id="pad">
        <h2>Edit Elevator Pitch</h2>
        <span class="backward"><a href="/candidate">Back to Bio Page</a></span>
        <div class="clearFloat"></div>
        <form:form id="pitchForm" method="post" modelAttribute="user">
        <form:hidden path="id"/>
        <div class="row">
            <form:textarea path="candidate.pitch"/>
        </div>
        <div class="opt_bar">
            <input type="submit" id="btnSubmit" value="Save"/>
        </div>
        </form:form>
    </div>
</div>