var form, fname, lname, email, pwd, repwd;

$(document).ready(function() {
    form = $('#reg_form');
    fname = $('#firstname');
    lname = $('#lastname');
    email = $('#email');
    pwd = $('#pwd');
    repwd = $('#repwd');

    form.submit(function(event) {
        if(!checkForm()) event.preventDefault();
        else {
            $('#btnSubmit').prop('disabled', true);
        }
    });
});

function checkForm() {
    normaliseForm();

    if(fname.val() == '') {
        $('#lbl_fn').text('Please enter a value.');
        return false;
    } else $('#lbl_fn').text('');

    if(lname.val() == '') {
        $('#lbl_ln').text('Please enter a value.');
        return false;
    } else $('#lbl_ln').text('');

    if(email.val() == '') {
        $('#lbl_email').text('Please enter a value.');
        return false;
    } else $('#lbl_email').text('');

    if(pwd.val() == '') {
        $('#lbl_pwd').text('Please enter a value.');
        return false;
    } else $('#lbl_pwd').text('');

    if(repwd.val() == '') {
        $('#lbl_repwd').text('Please enter a value.');
        return false;
    } else $('#lbl_repwd').text('');

    if(pwd.val() != repwd.val()) {
        $('#lbl_repwd').text('Please check the value.');
        return false;
    } else $('#lbl_repwd').text('');

    return true;
}

function normaliseForm() {
    fname.val($.trim(fname.val()));
    lname.val($.trim(lname.val()));
    email.val($.trim(email.val()));
    pwd.val($.trim(pwd.val()));
    repwd.val($.trim(repwd.val()));
}