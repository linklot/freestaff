<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="main" class="column">
    <!-- <h4 class="alert_info">FreeStaff admin panel.</h4> -->

    <article class="module width_full">
        <header>
            <h3>Statistics</h3>
        </header>
        <div class="module_content">
            <div class="row">
                <div class="text">
                    Candidates: <span class="highlight"><c:out value="${cand_stat[0]}"/></span>
                    <span class="indent">Activated Candidates: <span class="highlight"><c:out value="${cand_stat[1]}"/></span></span>
                </div>
            </div>
            <div class="clear"></div>
            <div class="row">
                <div class="text"><a href="/employer/search">Search Candidates</a></div>
            </div>
            <div class="sepration"></div>
            <div class="row">
                <div class="text">Invitations: <span class="highlight"><c:out value="${invitationCount}"/></span></div>
            </div>
            <div class="clear"></div>
            <div class="row">
                <div class="text"><a href="/employer/invitations">Check</a></div>
            </div>
        </div>
    </article>
</section>