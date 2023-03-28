package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class assertionBasics {

    public static WebDriver driver;

    @BeforeMethod
    public void SetupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void invalidCredentials(){
        WebElement username=driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys("Admin");
        WebElement password=driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("abracadabra");
        WebElement loginBtn=driver.findElement(By.xpath("//input[@name='Submit']"));
        loginBtn.click();

        WebElement error=driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String errorMsg=error.getText();
        String expectedError="Invalid credentials";

        Assert.assertEquals(errorMsg,expectedError);
        password=driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        boolean pswrdDisplayed=password.isDisplayed();
        Assert.assertTrue(pswrdDisplayed);
    }
}
