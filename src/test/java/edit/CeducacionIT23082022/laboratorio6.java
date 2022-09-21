package edit.CeducacionIT23082022;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class laboratorio6 {
	
	
	//variables
	
	String url ="http://automationpractice.com/index.php";
	String Chromepath ="..\\CeducacionIT23082022\\Driver\\chromedriver104.0.5112.79.exe"; 
	String Chromepath105 ="..\\CeducacionIT23082022\\Driver\\chromedriver105.0.5195.52.exe"; 
	String firefoxPath ="..\\CeducacionIT23082022\\Driver\\geckodriver-v0.31.0-win64.exe"; 
	WebDriver driver;
	
	
	@Parameters("navegador")
	
	@BeforeTest
	
	public void beforeTest(String navegador) {
		
			
		if(navegador.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", Chromepath105);
			
			//2 abrir el navegador e ingresar a la pagina
				driver = new ChromeDriver();
				driver.get(url);
				
				driver.manage().window().maximize();
				
				driver.manage().deleteAllCookies();
			
		} 
		
		else if(navegador.equalsIgnoreCase("firefox")){
			
			//1 donde esta el driver
			
			System.setProperty("webdriver.gecko.driver", firefoxPath);
		
			
			
		//2 abrir el navegador e ingresar a la pagina
			driver = new FirefoxDriver();
			driver.get(url);	
			
			
				
		}
					
		
		
	}
	
	
	
	//metodos
	@Test
	public void buscarPalabra() {
	
		
		
		
	//3 identificar el campo
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
	
	//3.2 escribir la palabra a buscar
	
		txtBuscador.sendKeys("dress");
				
	//4 boton buscar
		
		txtBuscador.sendKeys(Keys.ENTER);// SIMULANDO EL ENTER
		
		System.out.println("URL :" + driver.getCurrentUrl());
		System.out.println("titulo de la pagina :" + driver.getTitle() );
		
		
		
	//5 cerrar el navegador
		
		
	}
	
	
	
	
	
	
	

}
