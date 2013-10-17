<script type="text/javascript" src="/res/js/jquery.js"></script>
<script type="text/javascript" src="/res/js/login.js"></script>

<section id="content">
    <div class="signin_wrapper">
        <form method="post" action="j_spring_security_check">
        <h2>Sign in to FreeStaff</h2>
        <div class="row top">
            <div class="prompt">account:</div>
            <div class="input_area"><input type='text' id="j_username" name='j_username' value=''></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row">
            <div class="prompt">password:</div>
            <div class="input_area"><input type='password' name='j_password'/></div>
            <div class="label"><a href="/getPWD">Forgot password?</a></div>
            <div class="clearFloat"></div>
        </div>
        <div class="row bottom">
            <div class="input_area"><input type="submit" value="LOG IN"/></div>
            <div class="hint">
                or <a href="/reg">Join FreeStaff as a candidate</a><br/>
                or <a href="/employerReg">join FreeStaff as an employer</a>
            </div>
            <div class="clearFloat"></div>
        </div>
        </form>
    </div>
</section>