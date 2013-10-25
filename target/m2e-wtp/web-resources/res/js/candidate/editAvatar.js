var form, file, cid, lbl_msg, target;
$.ajaxSetup({cache: false});

$(document).ready(function() {
    form = $('#pic_form');
    form.submit(function(event) {
        event.preventDefault();
        checkFileForm();
    });
    cid = $('#cid').val();
    lbl_msg = $('#lbl_msg');
    target = $('#avatar');
    ajaxGetAvatar();
});

function checkFileForm() {
    var valid = false;
    file = $('#pic_file');
    var lbl = $('#msgLbl');
    if(file.val() == '') {
        lbl.text('Please select a file.');
        valid = false;
        return false;
    }
    else lbl.text('');

    var ext = file.val().substr(file.val().lastIndexOf('.') + 1);
    ext = ext.toLowerCase();
    if(ext == 'png' || ext == 'gif' || ext == 'jpg') valid = true;
    else valid = false;

    if(valid) ajaxUpload();
    else lbl.text('Invalid file format.');
}

function ajaxUpload() {
    lbl_msg.text('Upload...');
    $.ajax({
        type: 'POST',
        url: '/candidate/editAvatar',
        xhr: function() {
            var myXhr = $.ajaxSettings.xhr();
            return myXhr;
        },
        data: new FormData(form[0]),
        success: function() {
            lbl_msg.text('Uploading finished.');
            ajaxGetAvatar();
        },
        error: function(xhr, ajaxOptions, thrownError) {
            alert(xhr.status + " : " + thrownError);
        },
        cache: false,
        contentType: false,
        processData: false
    });
}

function ajaxGetAvatar() {
    target.html('');
    $.ajax({
        type: 'GET',
        url: '/candidate/avatar/' + cid,
        success: function(data) {
            target.html('<img src="'+ data +'" width="200" height="200"/>');
        },
        error: function() { alert('fail'); }
    });
}