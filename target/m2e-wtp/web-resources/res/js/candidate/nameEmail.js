var firstname, lastname, email, lbl_fname, lbl_lname, lbl_email;

$(document).ready(function() {
    form = $('#nameForm');
    firstname = $('#firstname');
    lastname = $('#lastname');
    email = $('#email');
    lbl_fname = $('#lbl_fname');
    lbl_lname = $('#lbl_lname');
    lbl_email = $('#lbl_email');
    form.submit(function(event) {
        if(!checkForm()) {
            event.preventDefault();
        }
    });
});

function checkForm() {
    firstname.val($.trim(firstname.val()));
    lastname.val($.trim(lastname.val()));
    email.val($.trim(email.val()));

    var valid = true;

    if(firstname.val() == '') {
        lbl_fname.text('Invalid value.');
        valid = false;
    }
    if(lastname.val() == '') {
        lbl_lname.text('Invalid value.');
        valid = false;
    }
    if(email.val() == '') {
        lbl_email.text('Invalid value.');
        valid = false;
    }

    return valid;
}