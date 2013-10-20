var form, btn_accept, btn_refuse, decision, account, password,
    lbl_account, lbl_password;

$(document).ready(function() {
    form = $('#form0');
    btn_accept = $('#accept');
    btn_refuse = $('#refuse');
    decision = $('#decision');
    account = $('#account');
    password = $('#password');
    lbl_account = $('#lbl_account');
    lbl_password = $('#lbl_password');

    btn_accept.click(function() {
        accept();
    });

    btn_refuse.click(function() {
        refuse();
    });
});

function accept() {
    var valid = true;
    decision.val('accept');
    account.val($.trim(account.val()));
    password.val($.trim(password.val()));
    if(account.val() == '') {
        lbl_account.text('*');
        valid = false;
    } else lbl_account.text('');
    if(password.val() == '') {
        lbl_password.text('*');
        valid = false;
    } else lbl_password.text('');
    if(valid) form.submit();
}

function refuse() {
    decision.val('refuse');
    if(window.confirm('Refuse this application?')) form.submit();
}