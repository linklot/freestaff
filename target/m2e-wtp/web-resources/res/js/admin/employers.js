$(document).ready(function() {
    $('.row').click(function() {
        showEmployer($(this).data('id'));
    });
});

function showEmployer(id) {
    window.location.href = '/admin/employer/' + id;
}