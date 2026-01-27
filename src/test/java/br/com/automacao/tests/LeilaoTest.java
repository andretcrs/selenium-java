package br.com.automacao.tests;

import br.com.automacao.core.BaseTest;
import br.com.automacao.pages.LeilaoPage;
import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class LeilaoTest extends BaseTest {

    @Test
    @Description("Teste que valida o cadastro de um novo leilão")
    public void deveCacastrarNovoLeilaoComSucesso() {
        LeilaoPage paginaLeilao = new LeilaoPage(browser);

        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String valorAleatorio = String.format("%.2f", (double) ThreadLocalRandom.current().nextInt(1000, 9001)).replace(",", ".");
        String nomeComData = "Leilão novo " + data + " - " + valorAleatorio;

        paginaLeilao.cadastrarNovoLeilao(nomeComData, valorAleatorio, data);
        Assert.assertTrue(paginaLeilao.estaNaPaginaDeLeiloes());
        Assert.assertTrue(paginaLeilao.isLeilaoCadastrado(nomeComData, valorAleatorio,data));

    }

    @Test
    @Description("Teste que valida a edição de um leilão existente")
    public void deveEditarLeilaoComSucesso() {
        LeilaoPage paginaLeilao = new LeilaoPage(browser);
        paginaLeilao.clicarBotaoEditar();

        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String valorAleatorio = String.valueOf(ThreadLocalRandom.current().nextInt(1000, 9001));
        String nomeComData = "Leilão editado " + hoje + " - " + valorAleatorio;

        paginaLeilao.editarLeilao(nomeComData, valorAleatorio, hoje);
        Assert.assertTrue(paginaLeilao.estaNaPaginaDeLeiloes());

    }
    @Test
    @Description("Valida mensagens de erro ao tentar cadastrar leilão vazio")
    public void naoDeveCadastrarLeilaoVazio() {
        LeilaoPage paginaLeilao = new LeilaoPage(browser);
        paginaLeilao.clicarNovoLeilao();
        paginaLeilao.clicarSalvar();
        Assert.assertTrue("Mensagens de validação não foram exibidas!",
                paginaLeilao.isMensagensDeValidacaoVisiveis());
    }

}