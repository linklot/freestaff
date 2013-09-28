var form, empName;

$(document).ready(function() {
    form = $('#userForm');
    empName = $('#name')

    form.submit(function(event) {
        submitForm(event);
    });

});

function submitForm(event) {
    empName.val($.trim(empName.val()));

    if(empName.val() == '') {
        $('#lbl_n').text('Please provide a value.');
        event.preventDefault();
    } else {
        $('#lbl_n').text('');
    }
}