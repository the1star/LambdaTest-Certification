package lambdatest;
import org.testng.annotations.Test;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.testng.annotations.BeforeTest;

public class Lambdatest {

	public RemoteWebDriver driver = null;
	String username = "d1star";
	String accessKey = "RkBc9pYejWA0A6Orm54IRTC0rYaY0DTrg7fdTWKiETSfjUY3ir";

	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("platform", "Windows 8");
		capabilities.setCapability("browserName", "Chrome");
	 capabilities.setCapability("version", "88.0"); // If this cap isn't specified, it will just get the any available one
		capabilities.setCapability("resolution","1024x768");
	/*	capabilities.setCapability("platform", "MacOS Catalina");
    	capabilities.setCapability("browserName", "Safari");
    	capabilities.setCapability("version", "13.0"); // If this cap isn't specified, it will just get the any available one
		capabilities.setCapability("resolution","1024x768");
	*/	capabilities.setCapability("build", "First Test");
		capabilities.setCapability("name", "Sample Test");
		capabilities.setCapability("network", true); // To enable network logs
		capabilities.setCapability("visual", true); // To enable step by step screenshot
		capabilities.setCapability("video", true); // To enable video recording
		capabilities.setCapability("console", true); // To capture console logs

		try {       
			driver= new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@hub.lambdatest.com/wd/hub"), capabilities);            
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		}
	}

	@Test(enabled = true)
	public void testScript() throws Exception {
		try {
			driver.get("https://www.lambdatest.com/automation-demos/");
			driver.findElement(By.xpath("//a[normalize-space()='I ACCEPT']")).click();
			driver.findElement(By.id("username")).sendKeys("lambda");
			driver.findElement(By.id("password")).sendKeys("lambda123");
			driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
			driver.findElement(By.id("developer-name")).sendKeys("d1star@yahoo.com");
			driver.findElement(By.xpath("//input[@id='populate']")).click();
			driver.switchTo().alert().accept();
			driver.findElement(By.id("month")).click();
			driver.findElement(By.id("delivery-time")).click();
			driver.findElement(By.id("preferred-payment")).click();
			driver.findElement(By.xpath("//input[@id='tried-ecom']")).click();
			driver.findElement(By.xpath("//a[@class='nav-link'][normalize-space()='Automation']")).click(); 
			
			WebElement Image =driver.findElement(By.xpath("img[alt='LambdaTest Jenkins integration']"));
			Actions action= new Actions(driver);
			action.contextClick(Image).build().perform();
			action.sendKeys(Keys.CONTROL, "v").build().perform();
			
			Thread.sleep(3000);
			
			  Robot robot = new Robot();
			  // To press D key.
			  robot.keyPress(KeyEvent.VK_D);
			  // To press : key.
			  robot.keyPress(KeyEvent.VK_SHIFT);
			  robot.keyPress(KeyEvent.VK_SEMICOLON);
			  robot.keyRelease(KeyEvent.VK_SHIFT);
			  // To press \ key.
			  robot.keyPress(KeyEvent.VK_BACK_SLASH);
			  // To press "test" key one by one.
			  robot.keyPress(KeyEvent.VK_T);
			  robot.keyPress(KeyEvent.VK_E);
			  robot.keyPress(KeyEvent.VK_S);
			  robot.keyPress(KeyEvent.VK_T);
			  // To press Save button.
			  robot.keyPress(KeyEvent.VK_ENTER);  
			 
			
			
			driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "t");
		    Set <String> windowHandles = driver.getWindowHandles();
		    System.out.println(windowHandles.size());
		    for(String winHandle : driver.getWindowHandles()){
		        driver.switchTo().window(winHandle);
		    }
		
		//    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		

		
		//	Lambdatest newTab = driver.switchTo().newWindow(WindowType.TAB);
			driver.quit();
		//	WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id<locator>));
			//opening the new tab
	      
			//String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
			//driver.findElement(By.linkText("https://www.lambdatest.com/selenium-automation")).sendKeys(selectLinkOpeninNewTab);

							
		} 
		
		
	//	WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}