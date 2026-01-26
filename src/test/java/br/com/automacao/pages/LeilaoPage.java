package br.com.automacao.pages;

import br.com.automacao.config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LeilaoPage {

    private WebDriver browser;

    public LeilaoPage(WebDriver browser) {
        this.browser = browser;
    }

    public void clicarBotaoEditar() {
        browser.findElement(By.cssSelector("a.btn-primary[href*='/form']")).click();
    }
    public void cadastrarNovoLeilao(String nome, String valor, String dataAbertura) {
        browser.findElement(By.id("novo_leilao_link")).click();
        preencherCamposLeilao(nome, valor, dataAbertura);
    }
    public void editarLeilao(String nome, String valor, String dataAbertura) {
        preencherCamposLeilao(nome, valor, dataAbertura);

    }

    private void preencherCamposLeilao(String nome, String valor, String dataAbertura) {
        WebElement campoNome = browser.findElement(By.id("nome"));
        campoNome.clear();
        campoNome.sendKeys(nome);

        WebElement campoValor = browser.findElement(By.id("valorInicial"));
        campoValor.clear();
        campoValor.sendKeys(valor);

        WebElement campoData = browser.findElement(By.id("dataAbertura"));
        campoData.clear();
        campoData.sendKeys(dataAbertura);

        browser.findElement(By.id("button-submit")).submit();
    }

    public String obterMensagemDeSucesso() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        WebElement alerta = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".alert.alert-primary")
        ));
        return alerta.getText();
    }
}
