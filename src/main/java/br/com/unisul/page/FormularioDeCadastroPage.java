package br.com.unisul.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormularioDeCadastroPage {
	
	@FindBy(id="firstName")
	private WebElement txtPrimeiroNome;
	
	@FindBy(id="inputEmail")
	private WebElement txtEmail;
	
	@FindBy(id="state")
	private WebElement txtEstado;
	
	@FindBy(id="user")
	private WebElement txtUsuario;
	
	@FindBy(id="lastName")
	private WebElement txtUltimoNome;
	
	@FindBy(id="birth_date")
	private WebElement txtDataNascimento;

	@FindBy(id="city")
	private WebElement txtCidade;

	@FindBy(id="pass")
	private WebElement txtSenha;
	
	@FindBy(id="submit")
	private WebElement btSalvar;
	
	@FindBy(id="result_message")
	private WebElement txtMensagemFeedback;
	
	public FormularioDeCadastroPage (WebDriver webDriver){
		PageFactory.initElements(webDriver, this);
	}
	
	public void preencherPrimeiroNome(String primeiroNome){
		txtPrimeiroNome.sendKeys(primeiroNome);
	}

	public void preencherUltimoNome(String ultimoNome){
		txtUltimoNome.sendKeys(ultimoNome);
	}
	
	public void preencherEmail(String email){
		txtEmail.sendKeys(email);
	}
	
	public void preencherDataNascimento(String dataNascimento){
		txtDataNascimento.sendKeys(dataNascimento);
	}
	
	public void preencherEstado(String estado){
		txtEstado.sendKeys(estado);
	}
	
	public void preencherCidade(String cidade){
		txtCidade.sendKeys(cidade);
	}
	
	public void preencherUsuario(String usuario){
		txtUsuario.sendKeys(usuario);
	}
	
	public void preencherSenha(String senha){
		txtSenha.sendKeys(senha);
	}
	
	public void clickBtSalvar(){
		btSalvar.click();
	}
	
	public String getTxtMensagemFeedback(){
		return txtMensagemFeedback.getText();
	}

}
