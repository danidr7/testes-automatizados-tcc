package br.com.unisul.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.unisul.page.FormularioDeCadastroPage;

public class TestFormularioDeCadastro {
	
	private WebDriver webDriver;
	private FormularioDeCadastroPage formularioPage;
	
	@BeforeClass
	public void preConditions() throws MalformedURLException{
		webDriver = new RemoteWebDriver(new URL("http://localhost:4441/wd/hub"), DesiredCapabilities.firefox());
		webDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		webDriver.get("http://formtcc-drserver.rhcloud.com/");
		formularioPage = new FormularioDeCadastroPage(webDriver);
	}
	
	@Test
	public void cadastrarUmUsuarioComSucesso(){
		formularioPage.preencherPrimeiroNome("Daniel");
		formularioPage.preencherUltimoNome("Rosa");
		formularioPage.preencherEmail("daniel.rosa1@unisul.com.br");
		formularioPage.preencherDataNascimento("07/07/1992");
		formularioPage.preencherEstado("Santa Catarina");
		formularioPage.preencherCidade("Palhoça");
		formularioPage.preencherUsuario("daniel.rosa1");
		formularioPage.preencherSenha("123456");
		formularioPage.clickBtSalvar();
		Assert.assertEquals(formularioPage.getTxtMensagemFeedback(), "Cadastro realizado com sucesso.");
	}
	
	@AfterClass
	public void closeDriver(){
		webDriver.close();
	}

}
