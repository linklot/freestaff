<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/res/js/post.js"></script>
<section id="content">
    <div id="title"><c:out value='${post.title}'/></div>
    <p>
        <c:out value="${post.content}" escapeXml="false"/>
    </p>
</section>