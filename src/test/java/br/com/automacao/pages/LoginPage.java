package br.com.automacao.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver browser;
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

}