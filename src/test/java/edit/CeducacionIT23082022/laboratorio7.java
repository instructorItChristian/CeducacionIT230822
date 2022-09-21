package edit.CeducacionIT23082022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class laboratorio7 {
	
	String Url="http://automationpractice.com/index.php";
	String chromePath="..\\CeducacionIT23082022\\Driver\\chromedriver105.0.5195.52.exe";
	WebDriver driver;
	
	
	
	@BeforeSuite
	public void setup(){
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		driver = new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
						
	}
	
@Test
public void login() {
	
	// en la pagina principal hacer click en el sing in
	
	PaginaInicio inicio = new PaginaInicio(driver);
	inicio.hacerClickEnSignIn();
	
	
	// ingresar el correo 
	
	PaginaLogin login = new PaginaLogin(driver);
	
	login.escribirEmail("micorreo0.7003443681795096@correo.com");
	
	//ingresar la contraseña
	login.escribirpassword("12345test");
	
	//hacer click en el boton 
	
	login.hacerClickBtnSingIn();
	
	Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
	
	
}



@Test
public void buscarPalabra() {
	PaginaInicio inicio = new PaginaInicio(driver);
	inicio.escribirPalabra("dress");
	inicio.presionarEnterBuscador();
	
	
	
}



	

}
