package br.com.automacao.core;
import br.com.automacao.config.ConfigManager;
import br.com.automacao.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver browser;

    @Before
    public void setup() {
        browser = DriverFactory.getDriver();
        browser.get(ConfigManager.get("base.url"));

        LoginPage paginaDeLogin = new LoginPage(browser);

        paginaDeLogin.preencheFormulario("fulano", "pass");
        paginaDeLogin.efetuaLogin();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}