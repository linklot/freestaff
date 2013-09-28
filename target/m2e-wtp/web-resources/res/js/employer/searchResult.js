$(document).ready(function() {
    $('.row_cand').click(function() {
        viewCandidate($(this).data('id'));
    });
});

function viewCandidate(id) {
    window.open('/employer/candidate/' + id, 'canWin', '');
}