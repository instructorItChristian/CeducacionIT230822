package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	
	@FindBy(css="#email")
	WebElement txtEmail;
	
	@FindBy(id="passwd")
	WebElement txtPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement btnSingIn;
	
	
	@FindBy(linkText="Sign out")
	WebElement linSignOut;
	
	
	
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	//acciones
	
	public void escribirEmail(String email) {
		
		txtEmail.sendKeys(email);
		
	}
	
	public void escribirpassword(String password) {
		
		txtPassword.sendKeys(password);
		
	}
	
	public void hacerClickBtnSingIn() {
		btnSingIn.click();
		
		
	}
	
	
	public void hacerClickSingOut() {
		
		linSignOut.click();
		
	}



}
