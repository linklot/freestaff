$(document).ready(function() {
    $('.del').click(function(event) {
        var id = $(this).data('id');
        if(confirm('Click \"OK\" to delete this post.')) {
            window.location.href = '/admin/post/'+ id +'/delete';
        }
    });
});