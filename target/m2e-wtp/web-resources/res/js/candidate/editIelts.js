var form, listening, reading, writing, speaking, overall;

$(document).ready(function() {
    form = $('#ieltsForm');
    listening = $('#listening');
    reading = $('#reading');
    writing = $('#writing');
    speaking = $('#speaking');
    overall = $('#overall');
    form.submit(function(event) {
        submitForm(event);
    });
});

function submitForm(event) {
    formalise();
    var valid = false;
    var str = 'Please provide value.';

    if(listening.val() == '') {
        valid = false;
        $('#lbl_l').text(str);
    } else {
        valid = true;
        $('#lbl_l').text('');
    }
    if(reading.val() == '') {
        valid = false;
        $('#lbl_r').text(str);
    } else {
        valid = true;
        $('#lbl_r').text('');
    }
    if(writing.val() == '') {
        valid = false;
        $('#lbl_w').text(str);
    } else {
        valid = true;
        $('#lbl_w').text('');
    }
    if(speaking.val() == '') {
        valid = false;
        $('#lbl_s').text(str);
    } else {
        valid = true;
        $('#lbl_s').text('');
    }
    if(overall.val() == '') {
        valid = false;
        $('#lbl_o').text(str);
    } else {
        valid = true;
        $('#lbl_o').text('');
    }

    if(!valid) event.preventDefault();
}

function formalise() {
    listening.val($.trim(listening.val()));
    reading.val($.trim(reading.val()));
    writing.val($.trim(writing.val()));
    speaking.val($.trim(speaking.val()));
    overall.val($.trim(overall.val()));
}