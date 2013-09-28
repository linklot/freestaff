var form, image, lbl_img;

$(document).ready(function() {
    form = $('#picForm');
    image = $('#image');
    lbl_img = $('#lbl_img');
    form.submit(function(event) {
        event.preventDefault();
        ajaxUpload();
    });
    ajaxGetPics();
});

function ajaxGetPics() {
    $.ajax({
        type: 'GET',
        url: '/admin/ajaxGetPics',
        success: function(data) { populateWindow(data); },
        fails: function() { alert("fail"); }
    });
    image.val('');
}

function populateWindow(data) {
    var target = $('#picWrapper');
    var html = '';
    for(var i=0; i<data.length; i++) {
        html += '<div class="pic">';
        html += '<div class="view">';
        html += '<img src="'+ data[i] +'" width="230" height="130"/></div>';
        html += '<div class="url"><input type="text" value="'+ data[i] +'"/>';
        html += '</div></div>';
    }
    target.html(html);
}

function ajaxUpload() {
    if(image.val() == '') lbl_img.text('Missing file.');
    else {
        $.ajax({
            type: 'POST',
            url: '/admin/ajaxUploadPic',
            xhr: function() {
                var myXhr = $.ajaxSettings.xhr();
                return myXhr;
            },
            data: new FormData(form[0]),
            success: function() {
                ajaxGetPics();
                lbl_img.text('Picture uploaded.');
            },
            error: function(xhr, ajaxOptions, thrownError) {
                alert(xhr.status + " : " + thrownError);
            },
            cache: false,
            contentType: false,
            processData: false
        });
    }
}