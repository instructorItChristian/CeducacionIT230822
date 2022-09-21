package edit.CeducacionIT23082022;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.CapturaEvidencia;

public class lab5c99 {
	

	String URL ="http://automationpractice.com/index.php";
	String ChromePath ="..\\CeducacionIT23082022\\Driver\\chromedriver105.0.5195.52.exe";
	String imagePath="..\\CeducacionIT23082022\\Evidencias\\";
	String docPath="..\\CeducacionIT23082022\\Evidencias\\";
	WebDriver driver;
	File screen;
	
	
	@BeforeSuite
		//acciones que se van a ejecutar antes de toda la suit
	
	public void setUp() {
		System.out.println("beforeSuite - inicio de la suite de prueba");
		
		
	}
	
	@BeforeClass
	//acciones que se van a ejecutar antes del @test  de este archivo
	
	public void beforeClass() {
		System.out.println("beforeClass - inicio de la clase Java");
		
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.get(URL);
			
	}
	
	
	@BeforeTest
	
	public void beforeTest() {
		System.out.println("beforeTest - inicio de la prueba");
				
	}
	
	//acciones que se van a ejecutar antes de cada test
	

	
	
	
	@Test (description="cp002 - ir a la seccion contac US", priority=10)
	public void irAcontacUs() throws InvalidFormatException, IOException, InterruptedException {
		
		Date fecha = new Date();
		
		Integer hora = fecha.getHours();
		
		
		Integer min = fecha.getMinutes();
		
		String docPath2 = docPath+"docEvidencia" +LocalDate.now()+"H"+hora+"M"+min+ ".docx";
		
	/*	docPath2.replace(":"," ");
		
		System.out.println(docPath2);*/
		
		CapturaEvidencia.escribirTituloEnDocumento(docPath2, "Documento de evidencias de pruebas", 18);
		
	
		
		//System.out.println (fecha);
		
		//captura evidencia
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPath2, "pantalla principal" );
		
		driver.findElement(By.linkText("Contact us")).click();
		
		//captura evidencia
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPath2, "formulario de carga");
		
		
		Select Subject = new Select(driver.findElement(By.id("id_contact")));
		Subject.selectByVisibleText ("Customer service");
		
		driver.findElement(By.id("email")).sendKeys("correo@test.com");

		driver.findElement(By.cssSelector("#id_order")).sendKeys("1234545");
		
		driver.findElement(By.xpath("//input[@id='fileUpload']")).sendKeys("c:\\testenvio.txt");
		
		driver.findElement(By.cssSelector("#message")).sendKeys("msj de prueba");
		
		//captura evidencia
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPath2, "formulario completo");
		
		driver.findElement(By.id("submitMessage")).click();
		
		//captura evidencia
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPath2, "resultado");
		
		
		
		
	}
	
	
	
	
	@AfterTest
public void afterTest() {
		System.out.println("aftertest - termina el test");
			
	}
	
	
	@AfterClass
public void afterClass() {
		System.out.println("afterclass - termina la clase java");
		
		driver.close();
			
	}
	
	@AfterSuite
public void afterSuite() {
		System.out.println("afterSuite - termina la suite");
			
	}

	
	
	
	

	
	
	

}
