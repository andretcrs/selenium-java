package br.com.automacao.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.Keys;


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

    public void editarLeilao(String nome, String valor, String data) {
        WebElement txtNome = browser.findElement(By.id("nome"));
        WebElement txtValor = browser.findElement(By.id("valorInicial"));
        WebElement txtData = browser.findElement(By.id("dataAbertura"));
        txtNome.clear();
        txtNome.sendKeys(nome);
        txtData.clear();
        txtData.sendKeys(data);
        txtValor.click();
        txtValor.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        txtValor.sendKeys(valor + Keys.TAB);
        browser.findElement(By.id("button-submit")).submit();
    }

    private void preencherCamposLeilao(String nome, String valor, String dataAbertura) {
        WebElement campoNome = browser.findElement(By.id("nome"));
        campoNome.sendKeys(nome);
        WebElement campoValor = browser.findElement(By.id("valorInicial"));
        campoValor.sendKeys(valor);
        WebElement campoData = browser.findElement(By.id("dataAbertura"));
        campoData.sendKeys(dataAbertura);
        browser.findElement(By.id("button-submit")).submit();
    }

    public boolean estaNaPaginaDeLeiloes() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlContains("/leiloes"));
    }

    public boolean isLeilaoCadastrado(String nome, String valor, String data) {
        WebElement linhaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        String nomeTela = linhaTabela.findElement(By.cssSelector("td:nth-child(1)")).getText().trim();
        String dataTela = linhaTabela.findElement(By.cssSelector("td:nth-child(2)")).getText().trim();
        String valorTela = linhaTabela.findElement(By.cssSelector("td:nth-child(3)")).getText().trim();

        return nomeTela.equals(nome) && dataTela.equals(data) && valorTela.contains(valor);
    }
    public void clicarNovoLeilao() {
        browser.findElement(By.id("novo_leilao_link")).click();
    }

    public void clicarSalvar() {
        this.browser.findElement(By.id("button-submit")).click();
    }
    public boolean isMensagensDeValidacaoVisiveis() {
        String content = browser.getPageSource();
        return content.contains("minimo 3 caracteres")
                && content.contains("não deve estar em branco")
                && content.contains("deve ser um valor maior de 0.1")
                && content.contains("deve ser uma data no formato dd/MM/yyyy");
    }
}
