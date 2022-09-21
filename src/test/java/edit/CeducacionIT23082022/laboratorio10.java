package edit.CeducacionIT23082022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class laboratorio10 {
	
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
	
@Test (dataProvider="Datos Login desde excel")
public void login(String email, String password) {
	
	// en la pagina principal hacer click en el sing in
	
	PaginaInicio inicio = new PaginaInicio(driver);
	inicio.hacerClickEnSignIn();
	
	
	// ingresar el correo 
	
	PaginaLogin login = new PaginaLogin(driver);
	
	login.escribirEmail(email);
	
	//ingresar la contraseña
	login.escribirpassword(password);
	
	//hacer click en el boton 
	
	login.hacerClickBtnSingIn();
	
	Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
	
	
	//log out
	
	login.hacerClickSingOut();
	
}

@DataProvider(name="Datos Login desde excel")

 public Object [][] obtenerDatosExcel() throws Exception{
	
	return DatosExcel.leerExcel("..\\CeducacionIT23082022\\Datos\\datos_login.xlsx", "Hoja1");
	
}



	

}
