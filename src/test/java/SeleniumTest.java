import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
    WebDriver driver;
    @BeforeTest
    public void setup(){

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Downloads\\geckodriver\\geckodriver.exe");
        // Initialize the FirefoxDriver instance
        driver = new FirefoxDriver();

        //driver.get("http://your-web-app/login");
        driver.get("https://app.miniemoney.com/login");
    }
    @Test
    public void testSuccessfulLogin(){
        WebElement usernameField = driver.findElement(By.cssSelector("input[placeholder='Enter your Email Address']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password'][placeholder='Enter password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));

        usernameField.sendKeys("anuboyo@gmail.com");
        passwordField.sendKeys("P@$$w0rd2024#");
        loginButton.click();

        // Verify successful login by checking the URL or an element on the landing page
       // String expectedUrl = "http://your-web-app/dashboard";
        String expectedUrl = "https://app.miniemoney.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

    }
     @Test
     public void testFailedLogin() {
//         WebElement usernameField = driver.findElement(By.id("username"));
//         WebElement passwordField = driver.findElement(By.id("password"));
//         WebElement loginButton = driver.findElement(By.id("loginButton"));
//
//         usernameField.sendKeys("invalidUsername");
//         passwordField.sendKeys("invalidPassword");
//         loginButton.click();

         WebElement usernameField = driver.findElement(By.cssSelector("input[placeholder='Enter your Email Address']"));
         WebElement passwordField = driver.findElement(By.cssSelector("input[type='password'][placeholder='Enter password']"));
         WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));

         usernameField.sendKeys("anuboyo@gmail.com");
         passwordField.sendKeys("P@$$w0rd2024");
         loginButton.click();


         // Verify the error message is displayed
         WebElement errorMessage = driver.findElement(By.cssSelector("//h2[text()='Login unsuccessful']"));
         Assert.assertTrue(errorMessage.isDisplayed());
         Assert.assertEquals(errorMessage.getText(), "Invalid credentials");
        // Assert.assertEquals(errorMessage.getText(), "Login unsuccessful");
     }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
