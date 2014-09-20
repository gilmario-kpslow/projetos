function redirect(pagina) {
    $.ajax({
        url: "/masterdoc/retorne",
        data: "pagina=" + pagina + "&teste=y&j=nome&s=teste",
        method: "POST"

    }).success(function(r) {
        $("#conteudo").html(r);
    });
}

function criaMenu() {
    $(".menuitem").click(function() {
        redirect($(this).children().val());
    });
}


$(document).ready(function() {
    criaMenu();
    $("#redi").click(function() {
        redirect();
    });
});