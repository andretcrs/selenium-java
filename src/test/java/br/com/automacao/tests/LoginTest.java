package br.com.automacao.tests;
import br.com.automacao.pages.LoginPage;
import br.com.automacao.config.ConfigManager;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import br.com.automacao.core.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    @Description("Teste que valida o login com sucesso")
    public void deveriaEfetuarLoginComDadosValidos() {
        LoginPage paginaDeLogin = new LoginPage(browser);
        paginaDeLogin.preencheFormulario("fulano", "pass");
        paginaDeLogin.efetuaLogin();
        String urlLoginEsperada = ConfigManager.get("base.url");
        Assert.assertNotEquals(urlLoginEsperada, paginaDeLogin.getUrlAtual());
    }

    @Test
    @Description("Teste que valida o login com falha")
    public void naoDeveriaLogarComDadosInvalidos() {
        LoginPage paginaDeLogin = new LoginPage(browser);
        paginaDeLogin.preencheFormulario("ciclano", "123");
        paginaDeLogin.efetuaLogin();
        String urlLoginEsperada = ConfigManager.get("base.url");
        paginaDeLogin.validarUsuariosDadosIncorretos("Usuário e senha inválidos.");

    }
}