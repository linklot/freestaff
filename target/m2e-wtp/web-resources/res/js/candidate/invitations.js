$(document).ready(function() {
    $('#btn_accept').click(function() {
        accept($(this).data('id'));
    });
    $('#btn_decline').click(function() {
        decline($(this).data('id'));
    });
    $('#btn_employer').click(function() {
        employer($(this).data('id'));
    });
});

function accept(id) {
    if(confirm('Sure to accept this invitation?')) {
        window.location.href = '/candidate/invitation/'+ id +'/accept';
    }
}

function decline(id) {
    if(confirm('Sure to decline this invitation?')) {
        window.location.href = '/candidate/invitation/'+ id +'/decline';
    }
}

function employer(id) {
    window.open('/candidate/invitation/'+ id +'/employer', 'empWin', '');
}