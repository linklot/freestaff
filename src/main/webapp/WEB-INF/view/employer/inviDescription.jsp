<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<section id="main" class="column">
    <article class="module width_full">
        <form:form id="desForm">
        <header>
            <h3>Job Description</h3>
            <input type="submit" value="Send" class="alt_btn head_btn"/>
        </header>
        <div class="module_content">
            <textarea id="description" name="description" placeholder="Description of the position."></textarea>
            <div class="clear"></div>
        </div>
        <footer>
            <div class="submit_link">
                <input type="submit" value="Send" class="alt_btn"/>
            </div>
        </footer>
    </form:form>
    </article>
</section>