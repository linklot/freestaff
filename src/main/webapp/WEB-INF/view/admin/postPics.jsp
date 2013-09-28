<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/admin/postPics.js"></script>
<section id="main" class="column">
    <article class="module width_full">
        <form:form id="picForm" enctype="multipart/form-data">
        <header>
            <h3>Post Pictures</h3>
        </header>
        <div class="module_content">
            <div id="picWrapper"></div>
            <div class="clear"></div>
        </div>
        <footer>
            <div class="submit_link">
                <form:form id="picForm" action="/admin/ajaxUploadPic">
                    <input type="file" id="image" name="image"/>
                    <label for="image" id="lbl_img"></label>
                    <input type="submit" value="Add New Picture" class="alt_btn"/>
                </form:form>
            </div>
        </footer>
        </form:form>
    </article>
</section>