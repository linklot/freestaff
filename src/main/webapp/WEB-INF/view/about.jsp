<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/res/js/jquery.js"></script>
<script type="text/javascript" src="/res/js/about.js"></script>
<section id="content">
    <div id="title"><c:out value='${post.title}'/></div>
    <p>
        <c:out value="${post.content}" escapeXml="false"/>
    </p>
</section>