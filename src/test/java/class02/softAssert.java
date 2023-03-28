package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class softAssert {

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
    public void testCase(){
        WebElement loginBtn=driver.findElement(By.xpath("//input[@name='Submit']"));
        loginBtn.click();

        WebElement error=driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualError=error.getText();
        String expectedError="Username cannot be empty";

        SoftAssert soft=new SoftAssert();
        soft.assertEquals(actualError,expectedError);

        boolean loginDisplayed=loginBtn.isDisplayed();
        soft.assertTrue(loginDisplayed);

        soft.assertAll();

    }
}
