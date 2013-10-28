var form, cvFile, lbl_b;
var max = 2097152; //2M

$(document).ready(function() {
    form = $('#cvForm');
    cvFile = $('#cvFile');
    lbl_b = $('#lbl_b');

    form.submit(function(event) {
        submitForm(event);
    });

    cvFile.bind('change', function() {
        //this.files[0].size gets the size of your file.
        if(this.files[0].size > max) {
            lbl_b.text('File size is too large.');
            cvFile.replaceWith( cvFile = cvFile.clone( true ) );
        } else lbl_b.text('');
    });

});

function submitForm(event) {
    if(!checkForm()) event.preventDefault();
}

function checkForm() {
    var fileName = cvFile.val();
    if(fileName == '') {
        lbl_b.text('Please select a file.');
        return false;
    } else {
        var ext = fileName.substr(fileName.lastIndexOf('.') + 1);
        ext = ext.toLowerCase();
        if((ext == 'pdf') || (ext == 'doc') || (ext == 'docx') || (ext == 'rtf') || (ext == 'txt')) {
            lbl_b.text('');
            return true;
        }
        else {
            lbl_b.text('Only support .doc, .docx, .pdf, .rtf, &amp; .txt');
            return false;
        }
    }
}