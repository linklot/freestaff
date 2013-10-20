<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/res/js/candidate/index.js"></script>
<div class="wrapper">
    <div id="left_pad">
        <div id="bio_wrapper">
            <h1><c:out value="${user.candidate.firstName}"/> <c:out value="${user.candidate.lastName}"/>'s Bio</h1>
            <span class="membership">
                Membership Status:
                <c:if test="${user.candidate.membershipStatus=='Inactive'}"><span class="inactive">Inactive</span><input type="button" id="btnPay" value="Activate"/></c:if>
                <c:if test="${user.candidate.membershipStatus=='Active'}"><span class="active">Active</span> <c:out value="${user.candidate.friendlyMembershipFrom}"/> - <c:out value="${user.candidate.friendlyMembershipTo}"/><input type="button" id="btnPay" value="Renew"/></c:if>
                <c:if test="${user.candidate.membershipStatus=='Suspended'}"><span class="inactive">Suspended</span> <c:out value="${user.candidate.friendlyMembershipFrom}"/> - <c:out value="${user.candidate.friendlyMembershipTo}"/><input type="button" id="btnPay" value="Activate"/></c:if>
            </span>
            <div class="clearFloat"></div>
            <div id="photo_wrapper">
                <div id="photo">
                    <img src='<c:out value="${user.candidate.picUrl}"/>' width='200' height='200'/>
                    <div class="photo_edit_prompt">Edit your avatar</div>
                </div>
                <div id="number">Reg ID: <c:out value="${user.account}"/></div>
            </div>

            <div id="op_wrapper">
                <div class="row">
                    <div class="key"><a href="/candidate/nameEmail">Modify Name &amp; Email</a></div>
                </div>
                <div class="row">
                    <div class="key"><a href="/candidate/pwd">Modify Password</a></div>
                </div>
                <div class="row">
                    <div class="key"><a href="/candidate/cv">Upload CV</a></div>
                </div>
                <div class="row">
                    <div class="key"><a href="/candidate/paymentHistory" target="_blank">Payment History</a></div>
                </div>
            </div>

            <div class="clearFloat"></div>
            <div id="info1_wrapper">
                <div class="modify_row">
                    <a href='/candidate/classif/'>Edit</a>
                </div>
                <div class="row">
                    <div class="key">Classification</div>
                    <div class="value"><c:out value="${user.candidate.classif}"/></div>
                </div>
                <div class="row">
                    <div class="key">Sub Classification</div>
                    <div class="value"><c:out value="${user.candidate.subClassif}"/></div>
                </div>
                <div class="row">
                    <div class="key">Country of Birth</div>
                    <div class="value"><c:out value="${user.candidate.birthCountry}"/></div>
                </div>
                <div class="row">
                    <div class="key">Current City</div>
                    <div class="value"><c:out value="${user.candidate.currCity}"/></div>
                </div>
                <div class="row">
                    <div class="key">Current Country</div>
                    <div class="value"><c:out value="${user.candidate.currCountry}"/></div>
                </div>
                <div class="row">
                    <div class="key">Current Visa Status</div>
                    <div class="value">
                        <c:choose>
                            <c:when test="${user.candidate.currVisaStatus eq '0'}">I NEED A VISA</c:when>
                            <c:when test="${user.candidate.currVisaStatus eq '1'}">I HAVE PERMANENT RESIDENCY</c:when>
                            <c:when test="${user.candidate.currVisaStatus eq '2'}">I HAVE A STATE SPONSORED VISA</c:when>
                            <c:when test="${user.candidate.currVisaStatus eq '3'}">I HAVE AN EMPLOYER SPONSORED VISA</c:when>
                            <c:when test="${user.candidate.currVisaStatus eq '4'}">I HAVE APPLIED FOR A VISA AND AM WAITING FOR A DECISION</c:when>
                        </c:choose>
                    </div>
                </div>
                <div class="row">
                    <div class="key">Highest Qualification</div>
                    <div class="value"><c:out value="${user.candidate.highestQualif}"/></div>
                </div>
                <div class="row">
                    <div class="key">Name of Qualification</div>
                    <div class="value"><c:out value="${user.candidate.qualifName}"/></div>
                </div>
                <div class="row">
                    <div class="key">Can pay own airfare/relocation</div>
                    <div class="value">
                        <c:if test='${user.candidate.canPayAirfare}'>yes</c:if>
                        <c:if test='${!user.candidate.canPayAirfare}'>no</c:if>
                    </div>
                </div>
                <div class="row">
                    <div class="key">Can pay own visa costs</div>
                    <div class="value">
                        <c:if test='${user.candidate.canPayVisaCost}'>yes</c:if>
                        <c:if test='${!user.candidate.canPayVisaCost}'>no</c:if>
                    </div>
                </div>
                <div class="clearFloat"></div>
            </div>
            <div class="clearFloat"></div>
            <div id="info2_wrapper">
                <div class="row">
                    <div class="key">IELTS Scores:</div>
                    <div class="value modify_row"><a href="/candidate/ielts">Edit</a></div>
                </div>
                <div class="row">
                    <div class="key indent">Listening</div>
                    <div class="value"><c:out value="${user.candidate.listening}"/></div>
                </div>
                <div class="row">
                    <div class="key indent">Reading</div>
                    <div class="value"><c:out value="${user.candidate.reading}"/></div>
                </div>
                <div class="row">
                    <div class="key indent">Writing</div>
                    <div class="value"><c:out value="${user.candidate.writing}"/></div>
                </div>
                <div class="row">
                    <div class="key indent">Speaking</div>
                    <div class="value"><c:out value="${user.candidate.speaking}"/></div>
                </div>
                <div class="row">
                    <div class="key indent">Overall</div>
                    <div class="value"><c:out value="${user.candidate.overall}"/></div>
                </div>
            </div>
            <div id="info3_wrapper">
                <div class="row">
                    <div class="keyskills">Key Skills:</div>
                    <div class="value modify_row"><a href="/candidate/keySkills">Edit</a></div>
                </div>
                <div class="row">
                    <div class="key indent">1</div>
                    <div class="value"><c:out value="${user.candidate.keySkill1}"/></div>
                </div>
                <div class="row">
                    <div class="key indent">2</div>
                    <div class="value"><c:out value="${user.candidate.keySkill2}"/></div>
                </div>
                <div class="row">
                    <div class="key indent">3</div>
                    <div class="value"><c:out value="${user.candidate.keySkill3}"/></div>
                </div>
                <div class="row">
                    <div class="key indent">4</div>
                    <div class="value"><c:out value="${user.candidate.keySkill4}"/></div>
                </div>
                <div class="row">
                    <div class="key indent">5</div>
                    <div class="value"><c:out value="${user.candidate.keySkill5}"/></div>
                </div>
            </div>
            <div class="clearFloat"></div>
            <div id="info6_wrapper">
                <div class="row">
                    <div class="value modify_row"><a href="/candidate/skillAssess">Edit</a></div>
                </div>
                <div class="row">
                    <div class="key">Skills Assessment</div>
                    <div class="value">
                        <c:if test='${user.candidate.skillAssess}'>yes</c:if>
                        <c:if test='${!user.candidate.skillAssess}'>no</c:if>
                    </div>
                </div>
                <div class="row">
                    <div class="key">Assessment Authority</div>
                    <div class="value"><c:out value="${user.candidate.assessAuth}"/></div>
                </div>
                <div class="row">
                    <div class="key">Date of Skills Assessment</div>
                    <div class="value"><c:out value="${user.candidate.assessDate}"/></div>
                </div>
                <div class="row">
                    <div class="key">Reference Number</div>
                    <div class="value"><c:out value="${user.candidate.assessRefNo}"/></div>
                </div>
                <div class="clearFloat"></div>
            </div>
            
            <div id="info4_wrapper">
                <h2>Elevator Pitch</h2>
                <div class="modify_row"><a href="/candidate/pitch">Edit</a></div>
                <div class="clearFloat"></div>
                <p><c:out value="${user.candidate.pitch}"/></p>
            </div>
            <div id="info5_wrapper">
                <h2>Video</h2><div class="modify_row"><a href="/candidate/video">Edit</a></div>
                <div class="clearFloat"></div>
                <div class="video">
                    <c:if test="${empty user.candidate.videoUrl}">No video yet.<c:out value="${user.candidate.videoUrl}"/></c:if>
                    <c:if test="${not empty user.candidate.videoUrl}">
                        <iframe id="ytplayer" type="text/html" width="205" height="115" src='https://www.youtube.com/embed/<c:out value="${user.candidate.videoUrl}"/>' frameborder="0" allowfullscreen></iframe>
                    </c:if>
                </div>
            </div>
            <div class="clearFloat"></div>
        </div>

        <div id="work_wrapper">
            <h1>Employment History</h1>
            <div class="modify_row"><a href="/candidate/empHistory">Edit</a></div>
            <div class="clearFloat"></div>
            <c:forEach var="history" items="${user.candidate.empHistories}" varStatus="status">
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
                <div class="clearFloat"></div>
            </div>
            <c:if test="${!status.last}"><div class="separator"></div></c:if>
            <div class="clearFloat"></div>
            </c:forEach>
        </div>

        <div id="edu_wrapper">
            <h1>EDUCATION &amp; TRAINING</h1>
            <div class="modify_row"><a href="/candidate/eduHistory">Edit</a></div>
            <div class="clearFloat"></div>
            <c:forEach var="history" items="${user.candidate.eduHistories}" varStatus="status">
            <div class="edu">
                <div class="row">
                    <div class="key">Qualification</div>
                    <div class="value"><c:out value="${history.qualifType}"/></div>
                    <div class="clearFloat"></div>
                </div>
                <div class="row">
                    <div class="key">University/College</div>
                    <div class="value"><c:out value="${history.uni}"/></div>
                    <div class="clearFloat"></div>
                </div>
                <div class="row">
                    <div class="key">Location</div>
                    <div class="value"><c:out value="${history.loc}"/></div>
                    <div class="clearFloat"></div>
                </div>
                <div class="row">
                    <div class="key">Date Completed</div>
                    <div class="value"><c:out value="${history.complDate}"/></div>
                    <div class="clearFloat"></div>
                </div>
            </div>
            <c:if test="${!status.last}"><div class="separator"></div></c:if>
            </c:forEach>
        </div>

        <div id="interest_wrapper">
            <h1>INTERESTS</h1>
            <div class="modify_row"><a href="/candidate/interests">Edit</a></div>
            <div class="clearFloat"></div>
            <p><c:out value="${user.candidate.interests}"/></p>
        </div>
    </div>
    <div id="right_pad">
        <c:if test="${inviCount != '0'}">
        <div id="new_invi_wrapper" class="invi_wrapper"><c:out value="${inviCount}"/> new invitation(s).</div>
        </c:if>
        <c:if test="${inviCount == '0'}">
        <div id="invi_wrapper" class="invi_wrapper">Check your invitations.</div>
        </c:if>
        <c:if test="${user.candidate.viewCount!='0'}"><div id="viewCount">Profile viewed: <strong><c:out value="${user.candidate.viewCount}"/></strong> time(s)</div></c:if>
        <div class="sep_bar"></div>
        <div class="feedback_wrapper">
            <div class="title"><a href="#" id="feedback">FEEDBACK</a></div>
            <div class="form_area">
                <form id="form0" action="/candidate/feedback" method="post">
                    <textarea id="content" name="content" placeholder="Please give us your feedback"></textarea>
                    <input type="submit" value="Send" class="btn"/>
                </form>
            </div>
        </div>
        <div class="return_msg"></div>
    </div>
    <div class="clearFloat"></div>
</div>