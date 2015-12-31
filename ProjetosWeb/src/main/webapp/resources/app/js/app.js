function mascaraData(input) {
    $(input).attr("maxlength", '10');
    $(input).mask("99/99/9999", {placeholder: "__/__/____"});
}

function mascaraCurrency(input) {
    $(input).maskMoney({
        thousands: '.', decimal: ',', allowZero: true, prefix: 'R$ '
    });
}