<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="main" class="column">
    <!-- <h4 class="alert_info">FreeStaff admin panel.</h4> -->

    <article class="module width_full">
        <header>
            <h3>Statistics</h3>
        </header>
        <div class="module_content">
            <div class="row">
                <div class="key">Candidates: <c:out value="${candidateCount}"/></div>
                <div class="value"><a href="/employer/search">Search Candidates</a></div>
            </div>
            <div class="row">
                <div class="key">Invitations: <c:out value="${invitationCount}"/></div>
                <div class="value"><a href="/employer/invitations">Check</a></div>
            </div>
            <div class="clear"></div>
        </div>
    </article>
</section>