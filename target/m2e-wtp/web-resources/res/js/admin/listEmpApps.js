$(document).ready(function() {
    $('.row').click(function(event) {
        event.preventDefault();
        window.location.href = '/admin/employerApplication/' + $(this).data('id');
    });
});