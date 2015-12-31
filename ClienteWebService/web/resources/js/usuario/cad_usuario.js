salvar = (function () {
    $.ajax({
        url: "/projetocliente/responsavel/salvar",
        type: "POST",
        data: $('#frm_usuario').serialize()
    }).success(function (data) {
        var resposta = data;
        alert(resposta);
    });
});

