$(document).ready(function() {
    var li_p = $('ul#menu li:nth-child(1)');
    var li_c = $('ul#menu li:nth-child(5)');
    li_p.attr('id', '');
    li_c.attr('id', 'menu_active');

    var privacy = $('#privacy');
    var href_privacy = $('#href_privacy');
    var terms = $('#terms');
    var href_terms = $('#href_terms')
    privacy.css('display', 'none');
    terms.css('display', 'none');
    href_privacy.click(function(event) {
        event.preventDefault();
        if(privacy.css('display') == 'none') privacy.css('display', 'block');
        else privacy.css('display', 'none');
    });
    href_terms.click(function(event) {
        event.preventDefault();
        if(terms.css('display') == 'none') terms.css('display', 'block');
        else terms.css('display', 'none');
    });
});