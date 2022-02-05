package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class LoginTest {

	ChromeDriver driver = new ChromeDriver();

	@BeforeTest
	public void testSetup() {
		driver.get("http://localhost:8080/");
		driver.manage().window().maximize();
	}

	@Test
	public void loginWithValidUser() {
		String username = "SomeUser_name";
		String password = "TopSecret1234!";

//		String username = "dummytree";
//		String password = "test1";
		driver.findElement(By.xpath("//input[@placeholder='Enter Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys(password);
		driver.findElement(By.tagName("button")).click();
	}

	@Test
	public void nameVerifiedIfAvailable() {
		String nameOfUser = "SomeName";
		WebElement name = driver.findElement(By.xpath("//div[text()='Name']"));
		if (name.isDisplayed()) {
			String actualTitle = driver.findElement(By.xpath("//div[contains(text(),'Hello')]")).getText();
			org.testng.Assert.assertEquals(actualTitle, "Hello " + nameOfUser);

		}
	}
	
	@Test
	public void logOut() {	
		driver.findElement(By.tagName("button")).click();
		System.out.println("Logout Site");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
