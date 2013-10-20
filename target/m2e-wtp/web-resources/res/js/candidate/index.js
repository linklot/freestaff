var photo, photo_edit_prompt, element;

$(document).ready(function() {
    photo = $('#photo');
    photo_edit_prompt = $('#photo .photo_edit_prompt');
    initPhotoBehav();
    element = $('#right_pad .feedback_wrapper .form_area');

    $('.invi_wrapper').click(function() {
        window.location.href = "/candidate/invitations";
    });

    $('#btnPay').click(function() {
        window.open('/candidate/member', 'payWin');
    });

    $('#feedback').click(function(event) {
        event.preventDefault();
        if(element.css('display') == 'none') element.css('display', 'block');
        else element.css('display', 'none');
    });

    $('#form0').submit(function(event) {
        event.preventDefault();
        ajaxFormPost();
    });
});

function initPhotoBehav() {
    photo.css('cursor', 'pointer');
    photo.mouseover(function() {
        photo_edit_prompt.css('display', 'block');
    });
    photo.mouseout(function() {
        photo_edit_prompt.css('display', 'none');
    });
    photo.click(function() {
        window.location.href = '/candidate/editAvatar';
    });
}

function ajaxFormPost() {
    var content = $('#content');
    var form = $('#form0')
    content.val($.trim(content.val()));
    if(content.val() != '') {
        // Post form data.
        $.ajax({
            type: 'POST',
            url: '/candidate/feedback',
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
}

function postSuccess() {
    element.css('display', 'none');
    $('#right_pad .return_msg').html('We have received your feedback. Many thanks!');
}