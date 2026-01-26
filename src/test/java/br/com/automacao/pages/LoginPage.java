package br.com.automacao.pages;

import br.com.automacao.config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver browser;
    // Removi a constante PATH_LOGIN já que você usará a URL direto do Config

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public void preencheFormulario(String username, String password) {
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public void efetuaLogin() {
        browser.findElement(By.id("login-form")).submit();
    }

    public String getUrlAtual() {
        return browser.getCurrentUrl();
    }

    public String validarUsuariosDadosIncorretos(String fulano) {
        return browser.findElement(By.cssSelector(".alert.alert-danger")).getText();
    }
}