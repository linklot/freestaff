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