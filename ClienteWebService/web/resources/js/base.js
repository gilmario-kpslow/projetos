/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
carregar = (function (pagina, conteiner) {
    $.ajax({
        url: "/projetocliente/pagina",
        type: "POST",
        data: "pagina=" + pagina
    }).success(function (data) {
        $(conteiner).html(new String(data));
    });
});

carregarScript = (function (script) {
    $.ajax({
        url: "/projetocliente/pagina",
        type: "GET"
    }).success(function (data) {
        $("#extra_script").html();
        $("#extra_script").append("<script type='text/javascript' src='resources/js/" + script + "'></script>");
    });
});

criaMenu = (function (nome, acao) {
    $("#menu").append("<li><a href='#' onclick=\"" + acao + "\" >" + nome + "</a></li>");
});

iniciar = (function () {
    criaMenu("Inicio", "carregar('inicio', '#formulario');");
    criaMenu("Login", "carregar('login', '#formulario');");
    criaMenu("Cadastrar-se", "carregarScript('usuario/cad_usuario.js'); carregar('cad_usuario', '#formulario');");
});

$(document).ready(function () {
    iniciar();
    carregar("inicio", "#formulario")
});