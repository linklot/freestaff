<script type="text/javascript" src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/res/js/getPWD.js"></script>

<section id="content">
    <div class="signin_wrapper">
        <form method="post" action="/retrievePWD" id="pwdForm">
        <h2>Forgot Your Password?</h2>
        <div class="row top">
            <div class="prompt">Account:</div>
            <div class="input_area">
                <input type='text' id="account" name='account'>
                <label for="account" id="lbl_account"></label>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="prompt">Registration Email:</div>
            <div class="input_area">
                <input type='email' id="email" name='email'/>
                <label for="email" id="lbl_email"></label>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="hint">Your password will be reset and a notification email will be sent to your registration email address.</div>
            <div class="clearFloat"></div>
        </div>
        <div class="row bottom">
            <div class="input_area"><input type="submit" value="Reset Password"/></div>
            <div class="clearFloat"></div>
        </div>
        </form>
    </div>
</section>