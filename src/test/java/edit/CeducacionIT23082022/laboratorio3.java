package edit.CeducacionIT23082022;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class laboratorio3 {
	
	String url ="http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String Chromepath ="..\\CeducacionIT23082022\\Driver\\chromedriver105.0.5195.52.exe";
	WebDriver driver;
	
	
	@Test
	public void registrarUsuario() {
		
		System.setProperty("webdriver.chrome.driver", Chromepath);
		
		
		driver =new ChromeDriver();
		driver.navigate().to(url); // es equivalente al driver.get(url)
		driver.manage().window().maximize();
		
		
		//paso1 : ingresar el correo
		
		WebElement txtEmail = driver.findElement(By.cssSelector("#email_create"));
		txtEmail.sendKeys("micorreo01092022_2032@test.com");
		
		driver.findElement(By.id("SubmitCreate")).click();	
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		//paso2: cargar todo el formulario
				
		//radio
		driver.findElement(By.id("id_gender1")).click();
		
		//first name
		WebElement txtfirstname = driver.findElement(By.id("customer_firstname"));
		txtfirstname.sendKeys("pepe");
		
		//last name
		
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Argento");
		
		
		//password
		
		driver.findElement(By.id("passwd")).sendKeys("12345test");
		
		//day
		Select days = new Select(driver.findElement(By.id("days")));
		days.selectByIndex(20);
		
		//moth
		
		Select moth = new Select(driver.findElement(By.name("months")));
		moth.selectByValue("1");
		
		
		//year
		
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByVisibleText("2017  ");
		
		
		//avisos
		
		driver.findElement(By.cssSelector("#newsletter")).click();
		
		driver.findElement(By.name("optin")).click();
		
		//direccion
		
		driver.findElement(By.id("address1")).sendKeys("calle la esperanza 1234");
		
		//city
		
		driver.findElement(By.id("city")).sendKeys("caba");
		
		//state
		
		Select state =new Select(driver.findElement(By.id("id_state")));
		state.selectByIndex(10);
		
		
		//zip
		
		driver.findElement(By.cssSelector("#postcode")).sendKeys("90210");
		
				
		//country
		
		Select country =new Select(driver.findElement(By.id("id_country")));
		country.selectByValue("21");
		
		
		//phone mobile
		
		driver.findElement(By.name("phone_mobile")).sendKeys("6547511454");
		
		//alias
		
		//driver.findElement(By.id("alias")).sendKeys("mi casa");
		
		WebElement txtAlias = driver.findElement(By.id("alias"));
		
		txtAlias.clear();
		txtAlias.sendKeys("mi casa");
		
		// apretar el boton
		
		driver.findElement(By.id("submitAccount")).click();
		
		
				
		
		
		
	}
	
	
	
	
	

}
