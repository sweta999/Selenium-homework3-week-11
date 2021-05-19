package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignInAndWrongPassword {
    WebDriver driver;

    @Before
    public void setup() {
        String baseurl = "http://automationpractice.com/index.php";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseurl);
    }

    @Test
    public void verifyUserNotAbleToSignIn() {
        driver.findElement(By.xpath("//div[@class='header_user_info']/a")).click();
        driver.findElement(By.xpath("//h3[text()='Already registered?']"));
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("geeta@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("xyz#gmail.com");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();

        //Assert
        String ExpectedResult = "There is 1 error";

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']/p"));
        String ActualResult = errorMessage.getText();

        Assert.assertEquals(" ", ExpectedResult, ActualResult);

    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
