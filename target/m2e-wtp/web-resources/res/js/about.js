$(document).ready(function() {
    var li_p = $('ul#menu li:nth-child(1)');
    var li_c = $('ul#menu li:nth-child(4)');
    li_p.attr('id', '');
    li_c.attr('id', 'menu_active');
});