var form, f_name, l_name, phone, email, ref_code;

$(document).ready(function() {
    form = $('#form0');
    f_name = $('#f_name');
    l_name = $('#l_name');
    phone = $('#phone');
    email = $('#email');
    ref_code = $('#ref_code');

    form.submit(function(event) {
        event.preventDefault();
        if(checkform()) {
            // Submit the form in Ajax-way to generate an email.
            $.ajax({
                type: 'POST',
                url: '/ajaxVisaAdvice',
                xhr: function() {
                    var myXhr = $.ajaxSettings.xhr();
                    return myXhr;
                },
                data: new FormData(form[0]),
                success: function() {
                    $('.msg').css('display', 'block');
                },
                error: function(xhr, ajaxOptions, thrownError) {
                    $('.msg').css('display', 'block');
                    alert('error');
                },
                cache: false,
                contentType: false,
                processData: false
            });
        }
    });
});

function checkform() {
    formaliseForm();
    var html = '<img src="/res/image/cross-red.png" width="16" height="16"/>';
    if(f_name.val() == '') {
        $('#hint_f_name').html(html);
        return false;
    } else $('#hint_f_name').html('');
    if(l_name.val() == '') {
        $('#hint_l_name').html(html);
        return false;
    } else $('#hint_l_name').html('');
    if(phone.val() == '') {
        $('#hint_phone').html(html);
        return false;
    } else $('#hint_phone').html('');
    if(email.val() == '') {
        $('#hint_email').html(html);
        return false;
    } else $('#hint_email').html('');
    if(ref_code.val() == '') {
        $('#hint_ref_code').html(html);
        return false;
    } else $('#hint_ref_code').html('');
    return true;
}

function formaliseForm() {
    f_name.val($.trim(f_name.val()));
    l_name.val($.trim(l_name.val()));
    phone.val($.trim(phone.val()));
    email.val($.trim(email.val()));
    ref_code.val($.trim(ref_code.val()));
}