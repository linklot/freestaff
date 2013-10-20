var form, c_name, lbl_name, number, lbl_number, phone, lbl_phone,
    email, lbl_email, address, lbl_address, city, lbl_city, state, lbl_state,
    postcode, lbl_postcode, country, lbl_country;

$(document).ready(function() {
    form = $('#app_form');
    c_name = $('#name');
    number = $('#number');
    phone = $('#phone');
    email = $('#email');
    address = $('#address');
    city = $('#city');
    state = $('#state');
    postcode = $('#postcode');
    country = $('#country');

    form.submit(function(event) {
        if(!checkform()) event.preventDefault();
    });
});

function checkform() {   
    var valid = true; 
    c_name.val($.trim(c_name.val()));
    number.val($.trim(number.val()));
    phone.val($.trim(phone.val()));
    email.val($.trim(email.val()));
    address.val($.trim(address.val()));
    city.val($.trim(city.val()));
    state.val($.trim(state.val()));
    postcode.val($.trim(postcode.val()));
    country.val($.trim(country.val()));

    if(c_name.val() == '') {
        $('#lbl_name').text('*');
        valid = false;
    } else $('#lbl_name').text('');
    if(number.val() == '') {
        $('#lbl_number').text('*');
        valid = false;
    } else $('#lbl_number').text('');
    if(phone.val() == '') {
        $('#lbl_phone').text('*');
        valid = false;
    } else $('#lbl_phone').text('');
    if(email.val() == '') {
        $('#lbl_email').text('*');
        valid = false;
    } else $('#lbl_email').text('');
    if(address.val() == '') {
        $('#lbl_address').text('*');
        valid = false;
    } else $('#lbl_address').text('');
    if(city.val() == '') {
        $('#lbl_city').text('*');
        valid = false;
    } else $('#lbl_city').text('');
    if(state.val() == '') {
        $('#lbl_state').text('*');
        valid = false;
    } else $('#lbl_state').text('');
    if(postcode.val() == '') {
        $('#lbl_postcode').text('*');
        valid = false;
    } else $('#lbl_postcode').text('');
    if(country.val() == '') {
        $('#lbl_country').text('*');
        valid = false;
    } else $('#lbl_country').text('');

    return valid;
}