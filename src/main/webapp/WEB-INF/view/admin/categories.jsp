<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ice" tagdir="/WEB-INF/tags" %>
<section id="main" class="column">
    <article class="module width_full">
        <header>
            <h3>List Categories</h3>
        </header>
        <div class="module_content">
            <ice:categoryList root="${root_cate}" delimiter="&nbsp;&nbsp;" />
            <div class="clear"></div>
        </div>
        <footer>
        </footer>
    </article>
</section>