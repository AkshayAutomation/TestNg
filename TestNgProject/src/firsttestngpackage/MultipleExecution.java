package firsttestngpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MultipleExecution {
	
	String driverPath = "C:\\Users\\Akshay\\Downloads\\BrowserDrivers\\geckodriver.exe";
	public WebDriver driver;
	
	@Test    
    public void executSessionOne() throws InterruptedException{
            //First session of WebDriver
        System.setProperty("webdriver.gecko.driver", driverPath);
           driver = new FirefoxDriver(); 
            //Goto guru99 site
            driver.get("http://demo.guru99.com/V4/");
            //find user name text box and fill it
            driver.findElement(By.name("uid")).sendKeys("Driver 1");
            Thread.sleep(5000);
            
        }
        
    @Test    
        public void executeSessionTwo() throws InterruptedException{
            //Second session of WebDriver
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        
            //Goto guru99 site
        driver.get("http://demo.guru99.com/V4/");
        //find user name text box and fill it
        driver.findElement(By.name("uid")).sendKeys("Driver 2");
        Thread.sleep(5000);
        
        }
        
    @Test    
        public void executSessionThree() throws InterruptedException{
            //Third session of WebDriver
        System.setProperty("webdriver.gecko.driver", driverPath);
                    //Goto guru99 site
        driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/V4/");
        //find user name text box and fill it
        driver.findElement(By.name("uid")).sendKeys("Driver 3");
        Thread.sleep(5000);
        
        }    
   
    
}
