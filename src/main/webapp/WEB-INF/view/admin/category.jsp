<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ice" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="/res/js/admin/category.js"></script>
<section id="main" class="column">
    <article class="module width_full">
        <form:form id="cate_form" modelAttribute="category">
        <header>
            <h3>Add Category</h3>
        </header>
        <div class="module_content">
            <div class="row">
                <div class="key">Parent Category</div>
                <div class="value">
                    <form:select id="parent_id" path="parent.id">
                    <option value="-1">*&nbsp;Select Parent Category&nbsp;*</option>
                    <ice:categoryTree root="${root_cate}" delimiter="&nbsp;&nbsp;" />
                    </form:select>
                    <label for="parent_id" id="lbl_parent_id"></label>
                </div>
            </div>
            <div class="row">
                <div class="key">Name</div>
                <div class="value">
                    <form:input path="name"/>
                    <label for="name" id="lbl_name"></label>
                </div>
            </div>
            <div class="row">
                <div class="key">Sequence</div>
                <div class="value"><form:input path="sequence"/></div>
            </div>
            <div class="clear"></div>
        </div>
        <footer>
            <div class="submit_link">
                <input type="submit" value="Add Category" class="alt_btn"/>
            </div>
        </footer>
        </form:form>
    </article>
</section>