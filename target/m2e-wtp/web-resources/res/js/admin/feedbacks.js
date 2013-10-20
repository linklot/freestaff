$(document).ready(function() {
    $('.trigger').click(function(event) {
        var id = $(this).data('id');
        var target = $('#' + id);
        if(target.css('display') == 'none') target.css('display', 'block');
        else target.css('display', 'none');
    });
});