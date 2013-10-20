var form, username, password, lbl_username, lbl_password;

$(document).ready(function() {
    form = $('#login_form');
    username = $('#j_username');
    password = $('#j_password');
    lbl_username = $('#lbl_username');
    lbl_password = $('#lbl_password');
    username.focus();

    form.submit(function(event) {
        if(!checkform()) event.preventDefault();
    });
});

function checkform() {
    username.val($.trim(username.val()));
    password.val($.trim(password.val()));

    var valid = true;
    if(username.val() == '') {
        valid = false;
        lbl_username.text('*');
    } else lbl_username.text('');
    if(password.val() == '') {
        valid = false;
        lbl_password.text('*');
    } else lbl_password.text('');
    return valid;
}