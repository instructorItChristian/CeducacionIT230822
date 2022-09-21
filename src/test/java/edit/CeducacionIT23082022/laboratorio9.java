package edit.CeducacionIT23082022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class laboratorio9 {
	
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
	
@Test (dataProvider="Datos Login")
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

@DataProvider(name="Datos Login")

 public Object [][] obtenerDatos(){
	
	Object[][] datos = new Object[4][2];
	
	datos[0][0]="micorreo0.7003443681795096@correo.com";
	datos[0][1]="12345test";
	
	
	datos[1][0]="ama@test.com";
	datos[1][1]="test1234";
	
	datos[2][0]="pedro@test.com";
	datos[2][1]="test1234";
	
	datos[3][0]="juan@test.com";
	datos[3][1]="test1234";
	
	
	return datos;
	
}



	

}
