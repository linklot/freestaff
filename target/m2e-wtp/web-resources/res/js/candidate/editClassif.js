var form, classif, subClassif;

$(document).ready(function() {
    form = $('#classifForm');
    classif = $('#classif');
    subClassif = $('#subClassif');

    classif.change(function() {
        classifChange();
    });
});

function classifChange() {
    var parent_id = $("#classif option:selected").val();
    if(parent_id == 0) {
        populateSub();
        return;
    }
    $.ajax({
        type: 'GET',
        url: '/classif/'+ parent_id +'/sub',
        success: function(data) { populateSub(data); },
        error: function() { alert('fail'); }
    });
}

function populateSub(data) {
    var html = '';
    if(data != null) {
        for(var i=0; i<data.length; i++) {
            var classif = data[i];
            html = html + '<option value="'+ classif.id +'">'+ classif.name +'</option>\n';
        }
    }
    subClassif.html('<option value="0">Any Sub-Classification</option>\n');
    subClassif.html(subClassif.html() + html);
}