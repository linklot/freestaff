<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/candidate/cv.js"></script>
<div class="wrapper">
    <div id="pad">
        <h2>Update Curriculum Vitae</h2>
        <span class="backward"><a href="/candidate">Back to Bio Page</a></span>
        <div class="clearFloat"></div>
        <form:form id="cvForm" method="post" modelAttribute="user" enctype="multipart/form-data">
        <form:hidden path="id"/>
        <div class="row">
            <div class="key">Current CV File</div>
            <div class="value"><a href='/candidate/downloadcv' target='_blank'><c:out value="${user.candidate.cvUrl}"/></a></div>
            <div class="clearFloat"></div>
        </div>
        <div class="opt_bar">
            <label for="cvFile">Support .doc, .docx, .pdf, .rtf, &amp; .txt up to 2M.</label><br/>
            <input type="file" id="cvFile" name="cvFile"/>
            <input type="submit" id="btnSubmit" value="Update"/>
            <label id="lbl_b" for="btnSubmit"></label>
        </div>
        </form:form>
    </div>
</div>