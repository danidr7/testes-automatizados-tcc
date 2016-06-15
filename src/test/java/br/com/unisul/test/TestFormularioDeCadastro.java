package br.com.unisul.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.unisul.page.FormularioDeCadastroPage;

@Test
public class TestFormularioDeCadastro {
	
	private WebDriver webDriver;
	private FormularioDeCadastroPage formularioPage;
	private WebDriverWait wait;
	
	@BeforeClass
	public void preConditions() throws MalformedURLException{
		webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
		webDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		wait = new WebDriverWait(webDriver, 2);
		formularioPage = new FormularioDeCadastroPage(webDriver);
	}
	
	@BeforeMethod
	public void navigateToUrl(){
		webDriver.get("http://formtcc-drserver.rhcloud.com/");
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
	
	@Test
	public void cadastrarSemPreencherPrimeiroNome(){
		formularioPage.preencherPrimeiroNome("");
		formularioPage.preencherUltimoNome("Rosa");
		formularioPage.preencherEmail("daniel.rosa1@unisul.com.br");
		formularioPage.preencherDataNascimento("07/07/1992");
		formularioPage.preencherEstado("Santa Catarina");
		formularioPage.preencherCidade("Palhoça");
		formularioPage.preencherUsuario("daniel.rosa1");
		formularioPage.preencherSenha("123456");
		formularioPage.clickBtSalvar();
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = webDriver.switchTo().alert().getText();
		webDriver.switchTo().alert().accept();
		Assert.assertEquals(alertText, "O nome informado é inválido!");
	}
	
	@Test
	public void cadastrarSemPreencherUltimoNome(){
		formularioPage.preencherPrimeiroNome("Daniel");
		formularioPage.preencherUltimoNome("");
		formularioPage.preencherEmail("daniel.rosa1@unisul.com.br");
		formularioPage.preencherDataNascimento("07/07/1992");
		formularioPage.preencherEstado("Santa Catarina");
		formularioPage.preencherCidade("Palhoça");
		formularioPage.preencherUsuario("daniel.rosa1");
		formularioPage.preencherSenha("123456");
		formularioPage.clickBtSalvar();
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = webDriver.switchTo().alert().getText();
		webDriver.switchTo().alert().accept();
		Assert.assertEquals(alertText, "O último nome informado é inválido!");
	}
	
	@Test
	public void cadastrarSemPreencherEmail(){
		formularioPage.preencherPrimeiroNome("Daniel");
		formularioPage.preencherUltimoNome("Rosa");
		formularioPage.preencherEmail("");
		formularioPage.preencherDataNascimento("07/07/1992");
		formularioPage.preencherEstado("Santa Catarina");
		formularioPage.preencherCidade("Palhoça");
		formularioPage.preencherUsuario("daniel.rosa1");
		formularioPage.preencherSenha("123456");
		formularioPage.clickBtSalvar();
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = webDriver.switchTo().alert().getText();
		webDriver.switchTo().alert().accept();
		Assert.assertEquals(alertText, "O email informado é inválido!\nInsira no seguinte formato: exemplo@dominio.com");
	}
	
	@Test
	public void cadastrarSemPreencherDataNascimento(){
		formularioPage.preencherPrimeiroNome("Daniel");
		formularioPage.preencherUltimoNome("Rosa");
		formularioPage.preencherEmail("daniel.rosa1@unisul.com.br");
		formularioPage.preencherDataNascimento("");
		formularioPage.preencherEstado("Santa Catarina");
		formularioPage.preencherCidade("Palhoça");
		formularioPage.preencherUsuario("daniel.rosa1");
		formularioPage.preencherSenha("123456");
		formularioPage.clickBtSalvar();
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = webDriver.switchTo().alert().getText();
		webDriver.switchTo().alert().accept();
		Assert.assertEquals(alertText, "A data informada é inválida!");
	}
	
	@Test
	public void cadastrarSemPreencherEstado(){
		formularioPage.preencherPrimeiroNome("Daniel");
		formularioPage.preencherUltimoNome("Rosa");
		formularioPage.preencherEmail("daniel.rosa1@unisul.com.br");
		formularioPage.preencherDataNascimento("07/07/1992");
		formularioPage.preencherEstado("");
		formularioPage.preencherCidade("Palhoça");
		formularioPage.preencherUsuario("daniel.rosa1");
		formularioPage.preencherSenha("123456");
		formularioPage.clickBtSalvar();
		Assert.assertEquals(formularioPage.getTxtMensagemFeedback(), "Cadastro realizado com sucesso.");
	}
	
	@Test
	public void cadastrarSemPreencherCidade(){
		formularioPage.preencherPrimeiroNome("Daniel");
		formularioPage.preencherUltimoNome("Rosa");
		formularioPage.preencherEmail("daniel.rosa1@unisul.com.br");
		formularioPage.preencherDataNascimento("07/07/1992");
		formularioPage.preencherEstado("Santa Catarina");
		formularioPage.preencherCidade("");
		formularioPage.preencherUsuario("daniel.rosa1");
		formularioPage.preencherSenha("123456");
		formularioPage.clickBtSalvar();
		Assert.assertEquals(formularioPage.getTxtMensagemFeedback(), "Cadastro realizado com sucesso.");
	}
	
	@Test
	public void cadastrarSemPreencherUsuario(){
		formularioPage.preencherPrimeiroNome("Daniel");
		formularioPage.preencherUltimoNome("Rosa");
		formularioPage.preencherEmail("daniel.rosa1@unisul.com.br");
		formularioPage.preencherDataNascimento("07/07/1992");
		formularioPage.preencherEstado("Santa Catarina");
		formularioPage.preencherCidade("Palhoça");
		formularioPage.preencherUsuario("");
		formularioPage.preencherSenha("123456");
		formularioPage.clickBtSalvar();
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = webDriver.switchTo().alert().getText();
		webDriver.switchTo().alert().accept();
		Assert.assertEquals(alertText, "O usuário informado é inválido!");
	}
	
	@Test
	public void cadastrarSemPreencherSenha(){
		formularioPage.preencherPrimeiroNome("Daniel");
		formularioPage.preencherUltimoNome("Rosa");
		formularioPage.preencherEmail("daniel.rosa1@unisul.com.br");
		formularioPage.preencherDataNascimento("07/07/1992");
		formularioPage.preencherEstado("Santa Catarina");
		formularioPage.preencherCidade("Palhoça");
		formularioPage.preencherUsuario("daniel.rosa1");
		formularioPage.preencherSenha("");
		formularioPage.clickBtSalvar();
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = webDriver.switchTo().alert().getText();
		webDriver.switchTo().alert().accept();
		Assert.assertEquals(alertText, "Sua senha deve possuir 5 dígitos ou mais.");
	}
	
	@Test
	public void cadastrarComNomeInvalido(){
		formularioPage.preencherPrimeiroNome("Daniel123");
		formularioPage.preencherUltimoNome("Rosa");
		formularioPage.preencherEmail("daniel.rosa1@unisul.com.br");
		formularioPage.preencherDataNascimento("07/07/1992");
		formularioPage.preencherEstado("Santa Catarina");
		formularioPage.preencherCidade("Palhoça");
		formularioPage.preencherUsuario("daniel.rosa1");
		formularioPage.preencherSenha("123456");
		formularioPage.clickBtSalvar();
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = webDriver.switchTo().alert().getText();
		webDriver.switchTo().alert().accept();
		Assert.assertEquals(alertText, "O nome informado é inválido!");
	}
	
	@Test
	public void cadastrarComUltimoNomeInvalido(){
		formularioPage.preencherPrimeiroNome("Daniel");
		formularioPage.preencherUltimoNome("Rosa123");
		formularioPage.preencherEmail("daniel.rosa1@unisul.com.br");
		formularioPage.preencherDataNascimento("07/07/1992");
		formularioPage.preencherEstado("Santa Catarina");
		formularioPage.preencherCidade("Palhoça");
		formularioPage.preencherUsuario("daniel.rosa1");
		formularioPage.preencherSenha("123456");
		formularioPage.clickBtSalvar();
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = webDriver.switchTo().alert().getText();
		webDriver.switchTo().alert().accept();
		Assert.assertEquals(alertText, "O último nome informado é inválido!");
	}
	
	@Test
	public void cadastrarComEmailInvalido(){
		formularioPage.preencherPrimeiroNome("Daniel");
		formularioPage.preencherUltimoNome("Rosa");
		formularioPage.preencherEmail("daniel.rosa1");
		formularioPage.preencherDataNascimento("07/07/1992");
		formularioPage.preencherEstado("Santa Catarina");
		formularioPage.preencherCidade("Palhoça");
		formularioPage.preencherUsuario("daniel.rosa1");
		formularioPage.preencherSenha("123456");
		formularioPage.clickBtSalvar();
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = webDriver.switchTo().alert().getText();
		webDriver.switchTo().alert().accept();
		Assert.assertEquals(alertText, "O email informado é inválido!\nInsira no seguinte formato: exemplo@dominio.com");
	}
	
	@Test
	public void cadastrarComDataNascimentoInvalida(){
		formularioPage.preencherPrimeiroNome("Daniel");
		formularioPage.preencherUltimoNome("Rosa");
		formularioPage.preencherEmail("daniel.rosa1@unisul.com.br");
		formularioPage.preencherDataNascimento("31/02/1992");
		formularioPage.preencherEstado("Santa Catarina");
		formularioPage.preencherCidade("Palhoça");
		formularioPage.preencherUsuario("daniel.rosa1");
		formularioPage.preencherSenha("123456");
		formularioPage.clickBtSalvar();
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = webDriver.switchTo().alert().getText();
		webDriver.switchTo().alert().accept();
		Assert.assertEquals(alertText, "Insira um valor válido. O campo está incompleto ou tem uma data inválida.");
	}
	
	@AfterClass
	public void closeDriver(){
		webDriver.close();
	}

}
