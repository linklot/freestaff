<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/candidate/member.js"></script>
<div class="wrapper">
    <div id="pad">
        <h2>Active/Renew Your Membership</h2>
        <span class="backward"><a href="#" id="closeLink">Close</a></span>
        <div class="clearFloat"></div>
        <div class="note">
            <p>Your profile will be activated and live to employers immediately after payment.</p>
            <p>After making the payment, please refresh your profile page to confirm your membership status is changed.</p>
        </div>
        <div class="pay_wrapper">
            <div class="pay_option op1">
                <div class="header">3 Months</div>
                <div class="body">$49.00 $16.00/mon</div>
                <div class="footer">
                    <script src="/res/js/paypal-button.min.js?merchant=FVHRL97T72DMS"
                        data-callback='http://freesta.jvmhost.net/paypalListener?cid=<c:out value="${user.id}"/>'
                        data-button="buynow"
                        data-name="FreeStaff Membership 3 months"
                        data-amount="49.00"
                        data-currency="AUD">
                    </script>
                </div>
            </div>
            <div class="pay_option op2">
                <div class="header">6 Months</div>
                <div class="body">$79.00 $13.00/mon</div>
                <div class="footer">
                    <script src="/res/js/paypal-button.min.js?merchant=FVHRL97T72DMS"
                        data-button="buynow"
                        data-name="FreeStaff Membership 6 months"
                        data-amount="79.00">
                    </script>
                </div>
            </div>
            <div class="pay_option op3">
                <div class="header">12 Months</div>
                <div class="body">$99.00 $8.00/mon</div>
                <div class="footer">
                    <script src="/res/js/paypal-button.min.js?merchant=FVHRL97T72DMS"
                        data-button="buynow"
                        data-name="FreeStaff Membership 12 months"
                        data-amount="99.00">
                    </script>
                </div>
            </div>
            <div class="clearFloat"></div>
            <div class="curr_status">
                Your current status: <c:out value="${user.candidate.membershipStatus}"/>
            </div>
        </div>
    </div>
</div>