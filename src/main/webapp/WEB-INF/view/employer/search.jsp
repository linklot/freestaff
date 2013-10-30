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
                <input type="text" placeholder="Key Words" id="keyword" name="keywords"/>
            </div>
            <div class="row subrow">
                <label for="classif">Classification:</label>
                <select id="classif" name="classif">
                    <option value="0">Any Classification</option>
                    <c:forEach var="classif" items="${classifs}">
                        <option value='<c:out value="${classif.id}"/>'><c:out value="${classif.name}"/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="row subrow">
                <label for="sub-classif">Sub-Classification:</label>
                <select id="sub-classif" name="sub-classif">
                    <option value="0">Any Sub-classification</option>
                </select>
            </div>
            <div class="row subrow">
                <input type="text" placeholder="Country of Birth" id="birthCountry" name="birthCountry"/>
            </div>
            <div class="row subrow">
                <input type="text" placeholder="Current City" id="currCity" name="currCity"/>
            </div>
            <div class="row subrow">
                <input type="text" placeholder="Current Country" id="currCountry" name="currCountry"/>
            </div>
            <div class="row subrow">
                <label for="currVisaStatus">Current Visa Status:</label>
                <select id="currVisaStatus" name="currVisaStatus">
                    <option value="9">Any</option>
                    <option value="0">Need a Visa</option>
                    <option value="1">Have Permanent Residency</option>
                    <option value="2">Have a State Sponsored Visa</option>
                    <option value="3">Have an Employer Sponsored Visa</option>
                    <option value="4">Have Applied for a Visa and Waiting for a Decision</option>
                </select>
            </div>
            <div class="row subrow">
                <label for="highestQualif">Highest Qualification:</label>
                <select id="highestQualif" name="highestQualif">
                    <option value="9">Any</option>
                    <option value="Doctorate">Doctorate</option>
                    <option value="Masters Degree">Masters Degree</option>
                    <option value="Graduate Diploma">Graduate Diploma</option>
                    <option value="Graduate Certificate">Graduate Certificate</option>
                    <option value="Bachelor Degree">Bachelor Degree</option>
                    <option value="Diploma">Diploma</option>
                    <option value="Certificate">Certificate</option>
                    <option value="Apprenticeship">Apprenticeship</option>
                    <option value="Trade School Certificate">Trade School Certificate</option>
                    <option value="High School Certificate">High School Certificate</option>
                </select>
            </div>
            <div class="row subrow">
                <input type="text" placeholder="Name of Qualification" id="qualifName" name="qualifName"/>
            </div>
            <div class="row subrow">
                <label for="canPayAirfare">Can pay own airfare/relocation:</label>
                <select id="canPayAirfare" name="canPayAirfare">
                    <option value="9">Any</option>
                    <option value="1">Yes</option>
                    <option value="0">No</option>
                </select>
            </div>
            <div class="row subrow">
                <label for="canPayVisaCost">Can pay own visa costs:</label>
                <select id="canPayVisaCost" name="canPayVisaCost">
                    <option value="9">Any</option>
                    <option value="1">Yes</option>
                    <option value="0">No</option>
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