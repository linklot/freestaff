<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="content">
    <div id="title"><c:out value='${post.title}'/></div>
    <p>
        <c:out value="${post.content}" escapeXml="false"/>
    </p>
</section>