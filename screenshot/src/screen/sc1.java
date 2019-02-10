package screen;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class sc1 {
static FirefoxDriver driver=new FirefoxDriver();
	@Test
	public void test1() throws IOException {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");
		//ChromeDriver driver=new ChromeDriver();
		
	
		driver.get("http://www.facebook.com");
		 
		// Here we are forcefully passing wrong id so that it will fail our testcase
		driver.findElement(By.xpath(".//*[@id='emailasdasdas']")).sendKeys("Learn Automation");
		 
		 
		
	}
	

//@AfterMethod
//public void tesst2(String access)throws IOException{

	//if(access.equalsIgnoreCase("fail")){
		
		//File src =driver.getScreenshotAs(OutputType.FILE);
//File dest=new File("C:\\Users\\neil\\workspace\\screenshot\\Allscreen\\screenshot47.png");
//FileUtils.copyFile(src,dest);
//driver.close();
//driver.quit();
	//	}
//}

@AfterMethod
public void tearDown(ITestResult result)
{
 
// Here will compare if test is failing then only it will enter into if condition
if(ITestResult.FAILURE==result.getStatus())
{
try 
{
// Create refernce of TakesScreenshot
TakesScreenshot ts=(TakesScreenshot)driver;
 
// Call method to capture screenshot
File source=ts.getScreenshotAs(OutputType.FILE);
 
// Copy files to specific location here it will save all screenshot in our project home directory and
// result.getName() will return name of test case so that screenshot name will be same
FileUtils.copyFile(source, new File("C:\\Users\\neil\\workspace\\screenshot\\Allscreen"+result.getName()+".png"));
 
System.out.println("Screenshot taken");
} 
catch (Exception e)
{
 
System.out.println("Exception while taking screenshot "+e.getMessage());
} 
 
}}
}
