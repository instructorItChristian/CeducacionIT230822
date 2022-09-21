package edit.CeducacionIT23082022;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class laboratorio8 {
	
	String Url="https://demoqa.com/alerts";
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
public void alertas1() {
	
	driver.findElement(By.id("alertButton")).click();
	
	Alert alerta = driver.switchTo().alert();
	
	alerta.accept();
		
}

@Test
public void alertas2() {
	
	driver.findElement(By.id("timerAlertButton")).click();
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.alertIsPresent());
	
	Alert alerta = driver.switchTo().alert();
	
	alerta.accept();
		
}


@Test
public void alertas3() {
	
	driver.findElement(By.id("confirmButton")).click();
	
	
	Alert alerta = driver.switchTo().alert();
	
	alerta.dismiss();
		
}





@Test
public void alertas4() {
	
	driver.findElement(By.id("promtButton")).click();
	
	
	Alert alerta = driver.switchTo().alert();
	alerta.sendKeys("mi clase de pop up");
	
	
	alerta.accept();
		
}
	
	
	

}
