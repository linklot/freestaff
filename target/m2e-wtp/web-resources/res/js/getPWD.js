var form, account, email, lbl_account, lbl_email;

$(document).ready(function() {
    form = $('#pwdForm');
    account = $('#account');
    email = $('#email');
    lbl_account = $('#lbl_account');
    lbl_email = $('#lbl_email');

    form.submit(function(event) {
        if(!checkForm()) event.preventDefault();
    });
});

function checkForm() {
    account.val($.trim(account.val()));
    email.val($.trim(email.val()));

    var valid = true;

    if(account.val() == '') {
        lbl_account.text('*');
        valid = false;
    }
    if(email.val() == '') {
        lbl_email.text('*');
        valid = false;
    }

    return valid;
}