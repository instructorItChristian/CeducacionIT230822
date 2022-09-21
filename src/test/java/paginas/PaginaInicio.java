package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	
	
	//elementos que vamos a utilizar
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSingIn;
	
	@FindBy(id="search_query_top")
	WebElement txtBuscador;
	
	//constructor
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
					
	}
	
	//acciones 
	
	public void hacerClickEnSignIn() {
		lnkSingIn.click();
		
	}
	
	
	public void escribirPalabra(String palabra) {
		txtBuscador.sendKeys(palabra);
		
	}
	
	public void presionarEnterBuscador() {
		
		txtBuscador.sendKeys(Keys.ENTER);
	}
	

}
