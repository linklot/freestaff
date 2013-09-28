var form, parent_id, lbl_parent_id, name, order, lbl_name;

$(document).ready(function() {
    form = $("#cate_form");
    name = $('#name');
    order = $('#order');
    parent_id = $('#parent_id');
    lbl_parent_id = $('#lbl_parent_id');
    lbl_name = $('#lbl_name');

    form.submit(function(event) {
        formalise();
        if(!verify()) {
            event.preventDefault();
        }
    });
});

function verify() {
    if(parent_id.val() == -1) {
        lbl_parent_id.text('Please choose a parent category');
        return false;
    } else {
        lbl_parent_id.text('');
    }
    if(name.val() == '') {
        lbl_name.text('Please provide value');
        return false;
    } else {
        lbl_name.text('');
    }
    return true;
}

function formalise() {
    name.val($.trim(name.val()));
}