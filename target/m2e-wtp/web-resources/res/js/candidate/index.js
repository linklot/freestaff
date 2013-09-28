var photo, photo_edit_prompt;

$(document).ready(function() {
    photo = $('#photo');
    photo_edit_prompt = $('#photo .photo_edit_prompt');
    initPhotoBehav();
    $('.invi_wrapper').click(function() {
        window.location.href = "/candidate/invitations";
    });

    $('#btnPay').click(function() {
        window.open('/candidate/member', 'payWin');
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