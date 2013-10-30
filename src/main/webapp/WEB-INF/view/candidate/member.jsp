<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/candidate/member.js"></script>
<div class="wrapper">
    <div id="pad">
        <h2>Activate/Renew Your Membership</h2>
        <span class="backward"><a href="#" id="closeLink">Close</a></span>
        <div class="clearFloat"></div>
        <div class="note">
            <p>Your profile will be activated and live to employers immediately after payment.</p>
            <p>After making the payment, please refresh your profile page to confirm your membership status is changed.</p>
        </div>
        <div class="pay_wrapper">
            <div class="pay_option op1">
                <div class="header">6 Months</div>
                <div class="body">
                    <img src="/res/image/79.png" width="200" height="200">
                </div>
                <div class="footer">
                    <script src="/res/js/paypal-button.min.js?merchant=2PJTT787LJVMY"
                        data-button="buynow"
                        data-name="Freestaff Membership 6 months"
                        data-amount="79.00"
                        data-currency="AUD">
                    </script>
                </div>
            </div>
            <div class="pay_option op2">
                <div class="header">12 Months</div>
                <div class="body">
                    <img src="/res/image/99.png" width="200" height="200">
                </div>
                <div class="footer">
                    <script src="/res/js/paypal-button.min.js?merchant=2PJTT787LJVMY"
                        data-button="buynow"
                        data-name="Freestaff Membership 12 months"
                        data-amount="99.00"
                        data-currency="AUD">
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