package firsttestngpackage;

import java.awt.AWTException;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Verify;
@Test
public class FirstTestNGFile {
	
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
    String driverPath = "C:\\Users\\Akshay\\Downloads\\BrowserDrivers\\geckodriver.exe";
    public WebDriver driver; 
    public String expected = null;
    public String actual = null;
    
    
        @BeforeTest
      public void launchBrowser() throws AWTException {
          System.out.println("launching firefox browser"); 
          System.setProperty("webdriver.gecko.driver", driverPath);
          driver= new FirefoxDriver();
          driver.get(baseUrl);
          //Implicit wait 
          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
          	
          //Explicit wait 
          WebDriverWait wait = new WebDriverWait(driver, 10);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("*//class[@id='tst']")));
          	
          
          //JavaScript executor - Interface which provides mechanism to execute java script through webdriver 
		/*
		 * JavascriptExecutor test = (JavascriptExecutor)driver;
		 * test.executeScript(Script , argument);
		 */
          //To scroll down using java script executor 
          ((JavascriptExecutor) driver).executeScript("Window.scrollBy(0,500)");
          
          //Used to keyboard and mouse event with Actions class and In built Actions API's
          Actions builder = new Actions(driver);
          builder.sendKeys(new CharSequence['a']);
          
          
          //To move forward and reverse 
          driver.navigate().forward();
          driver.navigate().back();
          
          //To set the size of window for particular dimension 
          Dimension d = new Dimension(420,600);
          driver.manage().window().setSize(d);
          
          //Switch to window 
          driver.switchTo().window("windowname");
          //If window name is not known 
          String handle= driver.getWindowHandle();
          for (String handles : driver.getWindowHandles())
          {
        	  driver.switchTo().window(handles);
          }
          
          //If login fails due to aythentication pop up 
          wait = new WebDriverWait(driver, 10); 
          Alert alert = wait.until(ExpectedConditions.alertIsPresent()); 
          
          
          
          //Using robot class for completely handling keyboard and mouse events
          Robot r = new Robot();
          r.keyPress('d');
          r.mouseMove(100, 200);
          r.getPixelColor(100, 200);
          r.mouseWheel(10);
          
          
          //Ways to handle alert 
          driver.switchTo().alert().accept();
          driver.switchTo().alert().dismiss();
          driver.switchTo().alert().getText();
          driver.switchTo().alert().sendKeys("hey");
        		  
        		  
      }
      
      @BeforeMethod
      public void verifyHomepageTitle() {
          String expectedTitle = "Welcome: Mercury Tours";
          String actualTitle = driver.getTitle();
          Assert.assertEquals(actualTitle, expectedTitle);
      }
          @Test(priority = 0)
      public void register(){
          driver.findElement(By.linkText("REGISTER")).click() ;
          expected = "Register: Mercury Tours";
          actual = driver.getTitle();
          Assert.assertEquals(actual, expected);
      }
          @Test(priority = 1)
      public void support() {
            driver.findElement(By.linkText("SUPPORT")).click() ;
            expected = "Under Construction: Mercury Tours";
            actual = driver.getTitle();
            Assert.assertEquals(actual, expected);
      }
      @AfterMethod
      public void goBackToHomepage ( ) {
            driver.findElement(By.linkText("Home")).click() ;
      }
       
      @AfterTest
      public void terminateBrowser(){
          driver.close();
      }
}
	


/*
 * @BeforeSuite: The annotated method will be run before all tests in this suite
 * have run.
 * 
 * @AfterSuite: The annotated method will be run after all tests in this suite
 * have run.
 * 
 * @BeforeTest: The annotated method will be run before any test method
 * belonging to the classes inside the tag is run.
 * 
 * @AfterTest: The annotated method will be run after all the test methods
 * belonging to the classes inside the tag have run.
 * 
 * @BeforeGroups: The list of groups that this configuration method will run
 * before. This method is guaranteed to run shortly before the first test method
 * that belongs to any of these groups is invoked.
 * 
 * @AfterGroups: The list of groups that this configuration method will run
 * after. This method is guaranteed to run shortly after the last test method
 * that belongs to any of these groups is invoked.
 * 
 * @BeforeClass: The annotated method will be run before the first test method
 * in the current class is invoked.
 * 
 * @AfterClass: The annotated method will be run after all the test methods in
 * the current class have been run.
 * 
 * @BeforeMethod: The annotated method will be run before each test method.
 * 
 * @AfterMethod: The annotated method will be run after each test method.
 * 
 * @Test: The annotated method is a part of a test case
 */
