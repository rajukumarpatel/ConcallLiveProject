package concall.MonetConcall_LiveProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MonetConCallLiveProject
{
WebDriver driver;
Robot rb;

@Test
public void operation() throws InterruptedException
{	
 ChromeOptions options = new ChromeOptions();
 Map<String, Object> prefs = new HashMap<String, Object>();
 
 options.addArguments("--use-fake-ui-for-media-stream");
 options.addArguments("--use-fake-device-for-media-stream=C:\\Users\\ASTR-34\\selenium\\MonetConcall-LiveProject\\video\\akiyo_cif.y4m");
 options.addArguments("--use-file-for-fake-video-capture=C:\\Users\\ASTR-34\\selenium\\MonetConcall-LiveProject\\video\\akiyo_cif.y4m");
 
 prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
 prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
 prefs.put("profile.default_content_setting_values.geolocation", 1);
 prefs.put("profile.default_content_setting_values.notifications", 1);
 options.setExperimentalOption("prefs", prefs);
 System.setProperty("webdriver.chrome.driver","C:\\Users\\ASTR-34\\Desktop\\files\\geckodriver\\chromedriver_win32\\chromedriver.exe");
 ChromeDriver driver=new ChromeDriver(options);
 driver.get("https://dev.monetrewards.com/monet-live-newUI/#/teacher/dashboard?name=MonetDummy");
 //https://dev.monetrewards.com/monet-live-newUI/#/teacher/call?name=nbcu@monet.com&room=1632394511731&roomid=1632394511731&id=852910
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
 try{
 rb = new Robot();
 }catch (AWTException e1){
 // TODO Auto-generated catch block
 e1.printStackTrace();
 }	
 Thread.sleep(5000);
 rb.keyPress(KeyEvent.VK_CONTROL);
 rb.keyPress(KeyEvent.VK_W);
 Thread.sleep(1000);
 rb.keyRelease(KeyEvent.VK_CONTROL);
 rb.keyRelease(KeyEvent.VK_W);
 Thread.sleep(2000);
 driver.findElement(By.xpath("//span[contains(text(),'Start Class')]")).click();
 Thread.sleep(2000);
 driver.findElement(By.xpath("//input[@formcontrolname='summary' or @data-grloadid='grloadid-9010']")).sendKeys("Maths");
 driver.findElement(By.xpath("//input[@placeholder='Type Email' or @data-grloadid='grloadid-7254']")).sendKeys("raju.kumar@ashmar.in");
 driver.findElement(By.xpath("//input[@formcontrolname='description' or @data-grloadid='grloadid-3495']")).sendKeys("Description");
 Thread.sleep(1000);
 driver.findElement(By.xpath("//span[contains(text(),'Create')]")).click();
 Thread.sleep(8000);
 driver.findElement(By.xpath("//span[contains(text(),'Start Meeting')]")).click();
 Thread.sleep(8000);
 /*-----------------------copy meeting Link---------------------------------------------------------*/
 driver.findElement(By.xpath("//mat-icon[contains(text(),'person_add')]")).click();
 Thread.sleep(3000);
 /*-------------------Share Own Screen -------------------------------------------------------------*/
 driver.findElement(By.xpath("//body/app-root[1]/app-teacher[1]/app-call[1]/div[1]/div[4]/button[4]/span[1]/mat-icon[1]")).click();
 Thread.sleep(4000); 
 /*--------------------click on microphone icon----------------------------------------------------------*/
 //driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-teacher[1]/app-call[1]/div[1]/div[4]/button[1]/span[1]/mat-icon[1]")).click();
 /*-------------------------------------- Open New Tab-------------------------------------------------  */
 for(int i=1; i<=10; i++)
 {
 ((JavascriptExecutor)driver).executeScript("window.open()");
 }
 String pwin=driver.getWindowHandle();
 Set<String> chwin=driver.getWindowHandles();
 Iterator<String> s=chwin.iterator();
 int j=1;		
 while(s.hasNext())
 {
 String win=s.next();
 if(!pwin.equals(win))
 {
 driver.switchTo().window(win);
 Thread.sleep(2000);
 rb.keyPress(KeyEvent.VK_TAB);
 rb.keyRelease(KeyEvent.VK_TAB);
 Thread.sleep(1000);
 rb.keyPress(KeyEvent.VK_TAB);
 rb.keyRelease(KeyEvent.VK_TAB);
 Thread.sleep(1000);
 rb.keyPress(KeyEvent.VK_CONTROL);
 rb.keyPress(KeyEvent.VK_V);
 rb.keyRelease(KeyEvent.VK_CONTROL);
 rb.keyRelease(KeyEvent.VK_V);
 Thread.sleep(2000);
 rb.keyPress(KeyEvent.VK_ENTER);
 rb.keyRelease(KeyEvent.VK_ENTER);
 Thread.sleep(5000);
 driver.findElement(By.xpath("//input[@formcontrolname='name' or @type='text']")).sendKeys("Raju-"+j);
 j++;
 Thread.sleep(1000);
 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-student[1]/app-student-login[1]/div[1]/form[1]/div[2]/button[1]/span[1]")).click();
 Thread.sleep(10000);  
  } }  
}
@AfterTest
public void closeapp()
{
driver.quit();
}



}
