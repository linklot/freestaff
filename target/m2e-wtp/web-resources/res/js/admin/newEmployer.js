var form, account, pwd, lbl_a;

$(document).ready(function() {
    form = $('#userForm');
    account = $('#account');
    pwd = $('#pwd');
    lbl_a = $('#lbl_a');
    lbl_p = $('#lbl_p');

    form.submit(function(event) {
        submitForm(event);
    });

});

function submitForm(event) {
    var valid = false;
    account.val($.trim(account.val()));
    pwd.val($.trim(pwd.val()));

    if(account.val() == '') {
        valid = false;
        lbl_a.text('Please provide a value.');
        account.focus();
    } else {
        valid = true;
        lbl_a.text('');
    }
    if(pwd.val() == '') {
        valid = false;
        lbl_p.text('Please provide a value.');
        pwd.focus();
    } else {
        valid = true;
        lbl_p.text('');
    }

    if(!valid) event.preventDefault();
}