var form, content, msg;

$(document).ready(function() {
    form = $('#form0');
    content = $('#content');
    msg = $('.msg');

    form.submit(function(event) {
        event.preventDefault();
        if(checkform()) {
            ajaxFormPost();
        }
    });
});

function checkform() {
    content.val($.trim(content.val()));
    if(content.val() != '') return true;
    else return false;
}

function ajaxFormPost() {
    $.ajax({
        type: 'POST',
        url: '/employer/feedback',
        xhr: function() {
            var myXhr = $.ajaxSettings.xhr();
            return myXhr;
        },
        data: new FormData(form[0]),
        success: function() { postSuccess(); },
        error: function(xhr, ajaxOptions, thrownError) {
            alert(xhr.status + " : " + thrownError);
        },
        cache: false,
        contentType: false,
        processData: false
    });
}

function postSuccess() {
    msg.css('display', 'block');
}