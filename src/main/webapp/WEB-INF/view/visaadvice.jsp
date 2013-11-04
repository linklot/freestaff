<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/res/js/visaadvice.js"></script>
<section id="content">
    <div id="title"><c:out value='${post.title}'/></div>
    <div class="logo_wrapper"><img src="../../res/image/WWV_logo.png" alt="" width="260" height="250" /></div>
    <div class="form_wrapper">
        <form id="form0">
            <div class="title">Free Australia Visa Assessment</div>
            <div class="body_wrapper">
                <div class="row">
                    <div class="key">First Name<span class="required">*</span></div>
                    <div class="value">
                        <input type="text" id="f_name" name="f_name"/>
                        <span id="hint_f_name"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="key">Last Name<span class="required">*</span></div>
                    <div class="value">
                        <input type="text" id="l_name" name="l_name"/>
                        <span id="hint_l_name"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="key">Phone<span class="required">*</span></div>
                    <div class="value">
                        <input type="text" id="phone" name="phone"/>
                        <span id="hint_phone"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="key">Email<span class="required">*</span></div>
                    <div class="value">
                        <input type="text" id="email" name="email"/>
                        <span id="hint_email"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="key">Visa Type<span class="required">*</span></div>
                    <div class="value">
                        <select id="visa_type" name="visa_type">
                            <option value="0">Work/Employer Sponsorship Visa</option>
                            <option value="1">State Regional Sponsorship Visa</option>
                            <option value="2">Skilled Migrant Visa</option>
                            <option value="3">Working Holiday Visa</option>
                            <option value="4">Farm Work Visa</option>
                            <option value="5">Student Visa</option>
                            <option value="6">Travel/Visitors Visa</option>
                            <option value="7">Family / Spouse / Partner Visa</option>
                            <option value="8">Retirement Visa</option>
                            <option value="9">Business Visa</option>
                            <option value="10">Permanent/Temporary Residency</option>
                            <option value="11">Other Visas</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="key">Referral Code<span class="required">*</span></div>
                    <div class="value">
                        <input type="text" id="ref_code" name="ref_code" value="FREESTAFF"/>
                        <span id="hint_ref_code"></span>
                    </div>
                </div>
                <div class="clearFloat"></div>
            </div>
            <div class="op_row">
                <input type="submit" value="Submit"/>
                <div class="clearFloat"></div>
            </div>
        </form>
    </div>
    <div class="clearFloat"></div>
    <div class="msg">
        <h3>Thank You</h3>
        <p>Thank you for submitting your visa enquiry.</p>
        <p>We have opened your file, and will be in contact as soon as possible to advise you of next steps.</p>
    </div>
    <p>
        <c:out value="${post.content}" escapeXml="false"/>
    </p>
</section>