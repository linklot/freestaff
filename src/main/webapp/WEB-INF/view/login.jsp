<script type="text/javascript" src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/res/js/login.js"></script>

<section id="content">
    <div class="signin_wrapper">
        <form method="post" action="j_spring_security_check" id="login_form">
        <h2>Sign in to Freestaff</h2>
        <div class="row top">
            <div class="prompt">account:</div>
            <div class="input_area">
                <input type='text' id="j_username" name='j_username'>
                <label id="lbl_username" for="j_username"></label>
            </div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="prompt">password:</div>
            <div class="input_area">
                <input type='password' id="j_password" name='j_password'/>
                <label id="lbl_password" for="j_password"></label>
            </div>
            <div class="label"><a href="/getPWD">Forgot password?</a></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row bottom">
            <div class="input_area"><input type="submit" value="LOG IN"/></div>
            <div class="hint">
                or <a href="/reg">Join Freestaff as a candidate</a><br/>
                or <a href="/employerReg">Join Freestaff as an employer</a>
            </div>
            <div class="clearFloat"></div>
        </div>
        </form>
    </div>
</section>