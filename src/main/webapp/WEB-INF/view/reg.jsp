<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript" src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/res/js/reg.js"></script>

<section id="content">
    <form:form method="post" id="reg_form">
    <div id="title">To join Freestaff, sign up below...</div>
    <div id="note"><span class="significant">NOTE:</span> FREESTAFF IS FOR SKILLED MIGRANTS (NON CITIZENS) ONLY. PLEASE CONFIRM YOU ARE NOT A CITIZEN OF AUSTRALIA.</div>
    <div class="row">
        <div class="label">First Name:</div>
        <div class="field">
            <input type="text" id="firstname" name="firstname"/>
            <label for="firstname" id="lbl_fn"></label>
        </div>
        <div class="clearFloat"></div>
    </div>
    <div class="row">
        <div class="label">Last Name:</div>
        <div class="field">
            <input type="text" id="lastname" name="lastname"/>
            <label for="lastname" id="lbl_ln"></label>
        </div>
        <div class="clearFloat"></div>
    </div>
    <div class="row">
        <div class="label">Email:</div>
        <div class="field">
            <input type="text" id="email" name="email"/>
            <label for="email" id="lbl_email"></label>
        </div>
        <div class="clearFloat"></div>
    </div>
    <div class="row">
        <div class="label">Password:</div>
        <div class="field">
            <input type="password" id="pwd" name="pwd"/>
            <label for="pwd" id="lbl_pwd"></label>
        </div>
        <div class="clearFloat"></div>
    </div>
    <div class="row">
        <div class="label">Confirm Password:</div>
        <div class="field">
            <input type="password" id="repwd" name="repwd"/>
            <label for="repwd" id="lbl_repwd"></label>
        </div>
        <div class="clearFloat"></div>
    </div>
    <div class="row omega">
        <div class="label"></div>
        <div class="field"><input type="submit" id="btnSubmit" value="Join FreeStaff"/></div>
        <div class="clearFloat"></div>
    </div>
    </form:form>
</section>