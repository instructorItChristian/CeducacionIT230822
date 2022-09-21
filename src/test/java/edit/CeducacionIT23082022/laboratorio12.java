package edit.CeducacionIT23082022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class laboratorio12 {
	
	String url ="https://demo.guru99.com/test/table.html";
	String chromepath="..\\CeducacionIT23082022\\Driver\\chromedriver105.0.5195.52.exe";
	WebDriver driver;
	
	
	@BeforeSuite
	public void AbrirPagina() {
		System.setProperty("webdriver.chrome.driver", chromepath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		driver =new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		
		
	}
	
	@Test
	public void ImprimirValoresTabla() {
		
		String valor1 =driver.findElement(By.xpath("//td[contains(text(),'3')]")).getText();
		
		System.out.println("valor de la primera fila columna tres: "+valor1);
		
		
	String valor2 =driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[2]/td[2]")).getText();
		
		System.out.println("valor de la fila dos columna dos: "+valor2);
		
	String valor3 =driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[1]")).getText();
			
		System.out.println("valor de la fila tres columna uno: "+valor3);
		
	String valor4 =driver.findElement(By.xpath("//tbody/tr[4]/td[3]")).getText();
		
		System.out.println("valor de la cuarta fila columna tres: "+valor4);
		
		
	}
	
	@AfterSuite
	
	public void cerrarNavegador() {
		driver.close();
		
		
	}
	
	
	
	
	

}
