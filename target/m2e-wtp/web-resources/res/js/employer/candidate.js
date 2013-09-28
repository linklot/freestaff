var form;

$(document).ready(function() {
    form = $('#candForm');
    form.submit(function(event) {
        submitForm(event);
    });
});

function submitForm(event) {
    if(!confirm('Sure to send an invitation?'))
        event.preventDefault();
}