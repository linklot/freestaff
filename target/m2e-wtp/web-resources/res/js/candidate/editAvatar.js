var form, file, cid;

$(document).ready(function() {
    form = $('#pic_form');
    form.submit(function(event) {
        event.preventDefault();
        checkFileForm();
    });
    cid = $('#cid').val();
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
    $.ajax({
        type: 'POST',
        url: '/candidate/editAvatar',
        xhr: function() {
            var myXhr = $.ajaxSettings.xhr();
            return myXhr;
        },
        data: new FormData(form[0]),
        success: function() { ajaxGetAvatar(); },
        error: function(xhr, ajaxOptions, thrownError) {
            alert(xhr.status + " : " + thrownError);
        },
        cache: false,
        contentType: false,
        processData: false
    });
}

function ajaxGetAvatar() {
    $.ajax({
        type: 'GET',
        url: '/candidate/avatar/' + cid,
        success: function(data) { populateAvatar(data); },
        error: function() { alert('fail'); }
    });
}

function populateAvatar(data) {
    var target = $('#avatar');
    target.html('<img src="'+ data +'" width="200" height="200"/>');
}