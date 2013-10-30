$(document).ready(function() {
    var fromYear = $('.fromYear');
    var toYear = $('.toYear');
    var fromMonth = $('.fromMonth');
    var toMonth = $('.toMonth');

    var yearHtml = '';
    for(var i=1950; i<2016; i++) {
        yearHtml += '<option value="'+ i +'">'+ i +'</option>';
    }
    var monthHtml = '';
    for(var i=1; i<13; i++) {
        var str = '';
        if(i < 10) str = '0' + i;
        else str = '' + i;
        monthHtml += '<option value="'+ str +'">'+ str +'</option>';
    }

    fromYear.each(function(index, value) {
        $(this).html(yearHtml);
        $(this).change(function() {
            $('#from'+ index).val($('#from_month_'+ index).val()+ '/' +$('#from_year_'+ index).val());
        });
    });
    fromMonth.each(function(index, value) {
        $(this).html(monthHtml);
        $(this).change(function() {
            $('#from'+ index).val($('#from_month_'+ index).val()+ '/' +$('#from_year_'+ index).val());
        });
    })

    toYear.each(function(index, value) {
        $(this).html(yearHtml);
        $(this).change(function() {
            $('#to'+ index).val($('#to_month_'+ index).val()+ '/' +$('#to_year_'+ index).val());
        });
    });
    toMonth.each(function(index, value) {
        $(this).html(monthHtml);
        $(this).change(function() {
            $('#to'+ index).val($('#to_month_'+ index).val()+ '/' +$('#to_year_'+ index).val());
        });
    })
});