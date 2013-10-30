$(document).ready(function() {
    $('.withdraw').click(function() {
        withdraw($(this).data('id'));
    });
    $('.resend').click(function() {
        resend($(this).data('id'));
    })
    $('.close').click(function() {
        close_fun($(this).data('id'));
    })
    $('.btn_cand').click(function() {
        cand_prof($(this).data('id'));
    })

    $('.img').each(function() {
        var photo = new Image();
        photo.src = $(this).attr('src');
        var width = photo.width;
        var height = photo.height;
        if(width > 200) $(this).attr('width', '200');
        else if(height > 200) $(this).attr('height', '200');
    });
});

function withdraw(id) {
    if(confirm('Sure to withdraw this invitation?'))
        window.location.href = '/employer/invitation/'+ id +'/withdraw';
}

function resend(id) {
    if(confirm('Sure to re-send this invitation?'))
        window.location.href = '/employer/invitation/' + id + '/resend';
}

function close_fun(id) {
    if(confirm('Sure to close this invitation?'))
        window.location.href = '/employer/invitation/' + id + '/close';
}

function cand_prof(id) {
    window.location.href = '/employer/candidate/' + id;
}