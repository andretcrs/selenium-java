package br.com.automacao.core;

import br.com.automacao.config.ConfigManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver browser;

    @Before
    public void setup() {
        // Pede um driver limpo para a factory
        browser = DriverFactory.getDriver();
        browser.get(ConfigManager.get("base.url"));
    }

    @After
    public void tearDown() {
        // IMPORTANTE: Use o método da factory que limpa a variável estática
        DriverFactory.quitDriver();
    }
}