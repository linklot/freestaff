<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ice" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="/res/tinymce/tinymce.min.js"></script>
<script type="text/javascript" src="/res/js/admin/post.js"></script>
<section id="main" class="column">
    <article class="module width_full">
        <input type="hidden" id="categoryId" value='<c:out value="${post.category.id}"/>'/>
        <form:form id="post_form" modelAttribute="post" enctype="multipart/form-data" action="/admin/post">
        <form:hidden path="id"/>
        <header>
            <h3>Add Post</h3>
        </header>
        <div class="module_content">
            <div class="row">
                <div class="key">Category</div>
                <div class="value">
                    <form:select id="cate_id" path="category.id">
                    <option value="-1">*&nbsp;Select Category&nbsp;*</option>
                    <ice:categoryTree root="${root_cate}" delimiter="&nbsp;&nbsp;" />
                    </form:select>
                    <label for="cate_id" id="lbl_cate_id"></label>
                    <c:out value="${post.category.name}"/>
                </div>
            </div>
            <div class="row">
                <div class="key">Title</div>
                <div class="value"><form:input path="title"/>
                    <label for="title" id="lbl_title"></label>
                </div>
            </div>
            <div class="row">
                <div class="key">Mini Picture</div>
                <div class="value pic">
                    <input type="file" id="miniPic" name="miniPic"/><label for="miniPic" id="lbl_miniPic"></label>
                    <c:if test="${miniPicUrl!=''}"><img src='<c:out value="${post.miniPicUrl}"/>' height="70"/></c:if>
                </div>
            </div>
            <div class="row">
                <div class="key">Summary</div>
                <div class="value summary"><form:textarea path="summary"/></div>
            </div>
            <div class="row">
                <div class="key">Sequence</div>
                <div class="value"><form:input path="sequence"/></div>
            </div>
            <div class="row">
                <div class="key">Content</div>
                <div class="value txtarea"><form:textarea path="content"/></div>
            </div>
            <div class="row">
                <div class="key"></div>
                <div class="value"><a id="picLink" href="#">Picture Management</a></div>
            </div>
            <div class="clear"></div>
        </div>
        <footer>
            <div class="submit_link">
                <c:if test="${post.id=='0'}"><input type="submit" value="Add New Post" class="alt_btn"/></c:if>
                <c:if test="${post.id!='0'}"><input type="submit" value="Update Post" class="alt_btn"/></c:if>
            </div>
        </footer>
        </form:form>
    </article>
</section>