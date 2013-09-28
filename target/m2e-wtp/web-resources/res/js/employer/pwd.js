var form, pwd, n_pwd, c_pwd;

$(document).ready(function() {
    form = $('#userForm');
    pwd = $('#pwd');
    n_pwd = $('#n_pwd');
    c_pwd = $('#c_pwd');
    lbl_p = $('#lbl_p');
    lbl_n = $('#lbl_n');
    lbl_c = $('#lbl_c');

    form.submit(function(event) {
        submitForm(event);
    });

});

function submitForm(event) {
    var valid = false;
    formaliseForm();

    if(pwd.val() == '') {
        valid = false;
        lbl_p.text('Please provide a value.');
    } else {
        valid = true;
        lbl_p.text('');
    }
    if(n_pwd.val() == '') {
        valid = false;
        lbl_n.text('Please provide a value.');
    } else {
        valid = true;
        lbl_n.text('');
    }
    if(c_pwd.val() == '') {
        valid = false;
        lbl_c.text('Please provide a value.');
    } else {
        valid = true;
        lbl_c.text('');
        if(n_pwd.val() != c_pwd.val()) {
            valid = false;
            lbl_c.text('Password does not match.');
        } else {
            valid = true;
            lbl_c.text('');
        }
    }

    if(!valid) event.preventDefault();
}

function formaliseForm() {
    pwd.val($.trim(pwd.val()));
    n_pwd.val($.trim(n_pwd.val()));
    c_pwd.val($.trim(c_pwd.val()));
}