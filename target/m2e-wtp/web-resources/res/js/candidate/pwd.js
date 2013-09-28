var form, pwd, n_pwd, c_pwd;

$(document).ready(function() {
    form = $('#pwdForm');
    pwd = $('#pwd');
    n_pwd = $('#n_pwd');
    c_pwd = $('#c_pwd');

    form.submit(function(event) {
        submitForm(event);
    });
});

function submitForm(event) {
    formaliseForm();
    if(!verifyForm()) event.preventDefault();
}

function formaliseForm() {
    pwd.val($.trim(pwd.val()));
    n_pwd.val($.trim(n_pwd.val()));
    c_pwd.val($.trim(c_pwd.val()));
}

function verifyForm() {
    var valid = false;
    if(pwd.val() == '') {
        $('#lbl_p').text('Please enter a value.');
        valid = false;
    }
    else {
        $('#lbl_p').text('');
        valid = true;
    }

    if(n_pwd.val() == '') {
        $('#lbl_n').text('Please enter a value.');
        valid = false;
    }
    else {
        $('#lbl_n').text('');
        valid = true;
    }

    if(c_pwd.val() == '') {
        $('#lbl_c').text('Please enter a value.');
        valid = false;
    }
    else {
        $('#lbl_c').text('');
        valid = true;
    }
    return valid;
}