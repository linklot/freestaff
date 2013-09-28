var form, title, cate, lbl_cate_id, lbl_title, miniPic, lbl_miniPic;

$(document).ready(function() {
    form = $('#post_form');
    cate = $('#cate_id')
    title = $('#title');
    lbl_cate_id = $('#lbl_cate_id');
    lbl_title = $('#lbl_title');
    miniPic = $('#miniPic');
    lbl_miniPic = $('#lbl_miniPic');

    initTinyMCE();

    form.submit(function(event) {
        if (!checkForm()) event.preventDefault();
    });

    initCate();

    $('#picLink').click(function(event) {
        event.preventDefault();
        window.open('/admin/postPics', 'picWin');
    });

});

function checkForm(event) {
    formalise();
    var valid = false;
    var selectedIndex = cate.prop('selectedIndex');
    
    if(selectedIndex == 0) {
        lbl_cate_id.text('Please select a category.');
        return false;
    } else lbl_cate_id.text('');

    if(title.val() == '') {
        lbl_title.text('Please provide value.');
        return false;
    } else lbl_title.text('');

    if(miniPic.val() != '') {
        var ext = miniPic.val().substr(miniPic.val().lastIndexOf('.') + 1);
        ext = ext.toLowerCase();
        if(!(ext == 'png' || ext == 'gif' || ext == 'jpg')) {
            lbl_miniPic.text('Wrong file format.');
            return false;
        }
    }

    return true;
}

function formalise() {
    title.val($.trim(title.val()));
}

function initTinyMCE() {
    tinymce.init({
        selector: "textarea#content",
        theme: "modern",
        width: 710,
        height: 400,
        plugins: [
             "advlist autolink link image lists charmap print preview hr anchor pagebreak spellchecker",
             "searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking",
             "save table contextmenu directionality emoticons template paste textcolor"
       ],
       toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | print preview media fullpage | forecolor backcolor emoticons",
       style_formats: [
            {title: 'Bold text', inline: 'b'},
            {title: 'Red text', inline: 'span', styles: {color: '#ff0000'}},
            {title: 'Red header', block: 'h1', styles: {color: '#ff0000'}},
            {title: 'Example 1', inline: 'span', classes: 'example1'},
            {title: 'Example 2', inline: 'span', classes: 'example2'},
            {title: 'Table styles'},
            {title: 'Table row 1', selector: 'tr', classes: 'tablerow1'}
        ]
    });
}

function initCate() {
    var categoryId = $('#categoryId').val();
    $('#cate_id > option').each(function() {
        if($(this).val() == categoryId) {
            $(this).attr('selected','selected');
        }
    });
}