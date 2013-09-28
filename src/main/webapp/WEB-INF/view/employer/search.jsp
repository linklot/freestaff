<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/employer/search.js"></script>
<section id="main" class="column">
    <article class="module width_full">
        <header>
            <h3>Candidate Search</h3>
        </header>
        <form:form modelAttribute="user" id="userForm" name="user">
        <form:hidden path="id"/>
        <div class="module_content">
            <div class="row">
                <input type="text" value="Key Words" id="keyword" name="keywords"/>
            </div>
            <div class="row subrow">
                <label for="classif">Classification</label>
                <select id="classif" name="classif">
                    <option value="0">ANY CLASSIFICATION</option>
                    <c:forEach var="classif" items="${classifs}">
                        <option value='<c:out value="${classif.id}"/>'><c:out value="${classif.name}"/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="row subrow">
                <label for="sub-classif">Sub-Classification</label>
                <select id="sub-classif" name="sub-classif">
                    <option value="0">ANY SUB-CLASSIFICATION</option>
                </select>
            </div>
        </div>
        <div class="clear"></div>
        <footer>
            <div class="submit_link">
                <input type="submit" value="Search" class="alt_btn"/> 
            </div>
        </footer>
        </form:form>
    </article>
</section>