package br.com.automacao.tests;

import br.com.automacao.core.BaseTest;
import br.com.automacao.pages.LeilaoPage;
import br.com.automacao.pages.LoginPage;
import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.Assert;

public class LeilaoTest extends BaseTest {

    @Test
    @Description("Teste que valida o cadastro de um novo leilão")
    public void deveCacastrarNovoLeilaoComSucesso() {
        LoginPage paginaDeLogin = new LoginPage(browser);
        LeilaoPage paginaLeilao = new LeilaoPage(browser);

        paginaDeLogin.preencheFormulario("fulano", "pass");
        paginaDeLogin.efetuaLogin();
        paginaLeilao.cadastrarNovoLeilao("Tablet", "1500", "25/01/2026");
        Assert.assertTrue(paginaLeilao.estaNaPaginaDeLeiloes());
    }

    @Test
    @Description("Teste que valida a edição de um leilão existente")
    public void deveEditarLeilaoComSucesso() {
        LoginPage paginaDeLogin = new LoginPage(browser);
        LeilaoPage paginaLeilao = new LeilaoPage(browser);

        paginaDeLogin.preencheFormulario("fulano", "pass");
        paginaDeLogin.efetuaLogin();
        paginaLeilao.clicarBotaoEditar();
        paginaLeilao.editarLeilao("Tablet editado", "2000", "28/01/2026");
        Assert.assertTrue(paginaLeilao.estaNaPaginaDeLeiloes());

    }

}