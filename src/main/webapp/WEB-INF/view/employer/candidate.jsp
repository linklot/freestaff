<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/employer/candidate.js"></script>
<section id="main" class="column">
    <article class="module width_full">
        <form:form modelAttribute="cand" id="candForm" name="cand">
        <header>
            <h3>Candidate Details</h3>
            <input type="submit" value="Send Invitation" class="alt_btn head_btn"/>
        </header>
        <div class="module_content">
            <div id="avatar_wrapper">
                <img src='<c:out value="${cand.candidate.picUrl}"/>' id="photo"/>
                <span>
                    <c:out value="${cand.candidate.firstName}"/>
                    <c:out value="${cand.candidate.lastName}"/>
                </span>
                <c:if test="${invitation.status=='4'}"><div class="cv_wrapper"><a href='/employer/candCV/<c:out value="${cand.candidate.id}"/>' target="_blank">Download CV</a></div></c:if>
                <c:if test="${invitation.status=='5'}"><div class="cv_wrapper"><a href='/employer/candCV/<c:out value="${cand.candidate.id}"/>' target="_blank">Download CV</a></div></c:if>
            </div>
            <div id="classif_wrapper">
                <div class="row">
                    <div class="key">Classification</div>
                    <div class="value"><c:out value="${cand.candidate.classif}"/></div>
                </div>
                <div class="row">
                    <div class="key">Sub-Classification</div>
                    <div class="value"><c:out value="${cand.candidate.subClassif}"/></div>
                </div>
                <div class="row">
                    <div class="key">Country of Birth</div>
                    <div class="value"><c:out value="${cand.candidate.birthCountry}"/></div>
                </div>
                <div class="row">
                    <div class="key">Current City</div>
                    <div class="value"><c:out value="${cand.candidate.currCity}"/></div>
                </div>
                <div class="row">
                    <div class="key">Current Country</div>
                    <div class="value"><c:out value="${cand.candidate.currCountry}"/></div>
                </div>
                <div class="row">
                    <div class="key">Current Visa Status</div>
                    <div class="value">
                        <c:choose>
                            <c:when test="${cand.candidate.currVisaStatus eq '0'}">I NEED A VISA</c:when>
                            <c:when test="${cand.candidate.currVisaStatus eq '1'}">I HAVE PERMANENT RESIDENCY</c:when>
                            <c:when test="${cand.candidate.currVisaStatus eq '2'}">I HAVE A STATE SPONSORED VISA</c:when>
                            <c:when test="${can.candidate.currVisaStatus eq '3'}">I HAVE AN EMPLOYER SPONSORED VISA</c:when>
                            <c:when test="${cand.candidate.currVisaStatus eq '4'}">I HAVE APPLIED FOR A VISA AND AM WAITING FOR A DECISION</c:when>
                        </c:choose>
                    </div>
                </div>
                <div class="row">
                    <div class="key">Highest Qualification</div>
                    <div class="value"><c:out value="${cand.candidate.highestQualif}"/></div>
                </div>
                <div class="row">
                    <div class="key">Name of Qualification</div>
                    <div class="value"><c:out value="${cand.candidate.qualifName}"/></div>
                </div>
                <div class="row">
                    <div class="key">Can pay own airfare/relocation</div>
                    <div class="value">
                        <c:if test='${cand.candidate.canPayAirfare}'>yes</c:if>
                        <c:if test='${!cand.candidate.canPayAirfare}'>no</c:if>
                    </div>
                </div>
                <div class="row">
                    <div class="key">Can pay own visa costs</div>
                    <div class="value">
                        <c:if test='${cand.candidate.canPayVisaCost}'>yes</c:if>
                        <c:if test='${!cand.candidate.canPayVisaCost}'>no</c:if>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
            <div id="ielts_wrapper">
                <div class="row">
                    <div class="key">IELTS Scores:</div>
                    <div class="value"></div>
                </div>
                <div class="row">
                    <div class="key">Listening</div>
                    <div class="value"><c:out value="${cand.candidate.listening}"/></div>
                </div>
                <div class="row">
                    <div class="key">Reading</div>
                    <div class="value"><c:out value="${cand.candidate.reading}"/></div>
                </div>
                <div class="row">
                    <div class="key">Writing</div>
                    <div class="value"><c:out value="${cand.candidate.writing}"/></div>
                </div>
                <div class="row">
                    <div class="key">Speaking</div>
                    <div class="value"><c:out value="${cand.candidate.speaking}"/></div>
                </div>
                <div class="row">
                    <div class="key">Overall</div>
                    <div class="value"><c:out value="${cand.candidate.overall}"/></div>
                </div>
            </div>
            <div id="skills_wrapper">
                <div class="row">
                    <div class="key">Key Skills:</div>
                    <div class="value"></div>
                </div>
                <c:if test="${!empty cand.candidate.keySkill1}">
                <div class="row">
                    <div class="key">1</div>
                    <div class="value"><c:out value="${cand.candidate.keySkill1}"/></div>
                </div>
                </c:if>
                <c:if test="${!empty cand.candidate.keySkill2}">
                <div class="row">
                    <div class="key">2</div>
                    <div class="value"><c:out value="${cand.candidate.keySkill2}"/></div>
                </div>
                </c:if>
                <c:if test="${!empty cand.candidate.keySkill3}">
                <div class="row">
                    <div class="key">3</div>
                    <div class="value"><c:out value="${cand.candidate.keySkill3}"/></div>
                </div>
                </c:if>
                <c:if test="${!empty cand.candidate.keySkill4}">
                <div class="row">
                    <div class="key">4</div>
                    <div class="value"><c:out value="${cand.candidate.keySkill4}"/></div>
                </div>
                </c:if>
                <c:if test="${!empty cand.candidate.keySkill5}">
                <div class="row">
                    <div class="key">5</div>
                    <div class="value"><c:out value="${cand.candidate.keySkill5}"/></div>
                </div>
                </c:if>
            </div>
            <div class="clear"></div>
            <div id="assess_wrapper">
                <div class="row">
                    <div class="key">Skill Assessment</div>
                    <div class="value">
                        <c:if test='${cand.candidate.skillAssess}'>yes</c:if>
                        <c:if test='${!cand.candidate.skillAssess}'>no</c:if>
                    </div>
                </div>
                <div class="row">
                    <div class="key">Assessment Authority</div>
                    <div class="value"><c:out value="${cand.candidate.assessAuth}"/></div>
                </div>
                <div class="row">
                    <div class="key">Date of Skills Assessment</div>
                    <div class="value"><c:out value="${cand.candidate.assessDate}"/></div>
                </div>
                <div class="row">
                    <div class="key">Reference Number</div>
                    <div class="value"><c:out value="${cand.candidate.assessRefNo}"/></div>
                </div>
            </div>
            <div id="pitch_wrapper">
                <h2>Elevator Pitch</h2>
                <p><c:out value="${cand.candidate.pitch}"/></p>
            </div>
            <div class="clear"></div>
            <div class="video">
                <c:if test="${not empty cand.candidate.videoUrl}">
                    <iframe id="ytplayer" type="text/html" width="640" height="360" src='https://www.youtube.com/embed/<c:out value="${cand.candidate.videoUrl}"/>' frameborder="0" allowfullscreen></iframe>
                </c:if>
            </div>
            <div id="empHistory_wrapper">
                <h2>Employment History</h2>
                <c:forEach var="history" items="${cand.candidate.empHistories}" varStatus="status">
                <c:if test="${!empty history.name}">
                <div class="work">
                    <div class="left">
                        <div class="row">
                            <c:if test="${status.index==0}">Current Employer</c:if>
                            <c:if test="${status.index!=0}">Previous Employer</c:if>
                        </div>
                        <div class="row indent"><c:out value="${history.name}"/></div>
                        <div class="row">Location</div>
                        <div class="row indent"><c:out value="${history.loc}"/></div>
                        <div class="row">Date Employed</div>
                        <div class="row indent">
                            <c:out value="${history.from}"/> - <c:out value="${history.to}"/>
                        </div>
                        <div class="row">Job Title</div>
                        <div class="row indent"><c:out value="${history.jobTitle}"/></div>
                    </div>
                    <div class="right">
                        <h6>Duties/Responsibilities</h6>
                        <p><c:out value="${history.duty}"/></p>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="separator"></div>
                </c:if>
                </c:forEach>
            </div>
            <div class="clear"></div>
            <div id="edu_wrapper">
                <h2>Education History</h2>
                <c:forEach var="history" items="${cand.candidate.eduHistories}" varStatus="status">
                <c:if test="${!empty history.qualifType}">
                    <div class="row">
                        <div class="key">Qualification</div>
                        <div class="value">
                            <c:out value="${history.qualifType}"/>                
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="row">
                        <div class="key">University/College</div>
                        <div class="value">
                            <c:out value="${history.uni}"/>                
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="row">
                        <div class="key">Location</div>
                        <div class="value">
                            <c:out value="${history.loc}"/>                
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="row">
                        <div class="key">Date Completed</div>
                        <div class="value">
                            <c:out value="${history.complDate}"/>                
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="separator"></div>
                </c:if>
                </c:forEach>
            </div>
            <div id="interests_wrapper">
                <h2>Interests</h2>
                <p><c:out value="${cand.candidate.interests}"/></p>
            </div>
            <div class="clear"></div>
        </div>
        <footer>
            <div class="submit_link">
                <input type="submit" value="Send Invitation" class="alt_btn"/>
            </div>
        </footer>
    </form:form>
    </article>
</section>