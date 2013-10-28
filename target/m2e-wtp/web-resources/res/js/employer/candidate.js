var form, photo;

$(document).ready(function() {
    form = $('#candForm');
    form.submit(function(event) {
        submitForm(event);
    });

    photo = $('#photo');
    var pic = new Image();
    pic.src = photo.attr('src');
    var width = pic.width;
    var height = pic.height;
    if(width > 200) photo.attr('width', '200');
    else if (height > 200) photo.attr('height', '200');
});

function submitForm(event) {
    if(!confirm('Sure to send an invitation?'))
        event.preventDefault();
}