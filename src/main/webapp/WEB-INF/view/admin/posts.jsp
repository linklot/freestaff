<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/res/js/admin/posts.js"></script>
<section id="main" class="column">
    <article class="module width_full">
        <header>
            <h3>List Posts</h3>
        </header>
        <div class="module_content">
            <table>
                <tr>
                    <th>Title</th>
                    <th>Publish Time</th>
                    <th>Hits</th>
                    <th></th>
                </tr>
                <c:forEach var="post" items="${posts.items}">
                <tr class="row" data-id='${post.id}'>
                    <td><a href='/admin/post/<c:out value="${post.id}"/>'><c:out value="${post.title}"/></a></td>
                    <td><c:out value="${post.friendlyPubTime}"/></td>
                    <td><c:out value="${post.hits}"/></td>
                    <td>
                        <a class="del" data-id='<c:out value="${post.id}"/>' href="#">Delete</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <div class="clear"></div>
        <footer>
            <div class="navi">
                <c:if test='${posts.currentPage!="1"}'><div class="pre"><a href='/admin/employers/<c:out value="${posts.previousIndex}"/>/<c:out value="${posts.pageSize}"/>'>&lt;&lt; Previous</a></div></c:if>
                <div class="info">Page <c:out value="${posts.currentPage}"/> of <c:out value="${posts.pageCount}"/></div>
                <c:if test='${posts.currentPage!=posts.pageCount}'><div class="next"><a href='/admin/employers/<c:out value="${posts.nextIndex}"/>/<c:out value="${posts.pageSize}"/>'>Next &gt;&gt;</a></div></c:if>
                <div class="count"><c:out value="${posts.totalCount}"/> in total</div>
                <div class="clearFloat"></div>
            </div>
        </footer>
    </article>
</section>