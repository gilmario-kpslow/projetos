function salvar() {
    $.ajax({
        url: "/masterdoc/projeto/criar",
        data: $("form").serialize(),
        method: "POST"
    }).success(function(r) {

    });
}

$(document).ready(function() {
    $("#salvar").click(function() {
        salvar();
    });
});