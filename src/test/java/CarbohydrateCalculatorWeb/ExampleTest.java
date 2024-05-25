package CarbohydrateCalculatorWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExampleTest {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/binaries/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.calculator.net/carbohydrate-calculator.html");
    }

    @Test(priority = 0,description = "Verify if Carbohydrate Calculator page loads correctly.")
    public void verifyCarbohydrateCalculatorPage() {
        String pageTitle = driver.getTitle(); //get title of the page
        System.out.println(pageTitle);
        Assert.assertEquals(pageTitle,"Carbohydrate Calculator"); //verify title of the page
    }

    @Test(priority = 1,description = "Verify calculation with minimum valid age value.")
    public void verifyCalculationWithMinAgeValue(){
        WebElement btn_clear = driver.findElement(By.xpath("//input[@type='button']"));
        btn_clear.click(); //clear all input box
        WebElement input_age = driver.findElement(By.id("cage"));
        input_age.sendKeys("18"); //input minmum age
        WebElement input_height = driver.findElement(By.id("cheightmeter"));
        input_height.sendKeys("165"); //input height
        WebElement input_weight = driver.findElement(By.id("ckg"));
        input_weight.sendKeys("100"); //input weight
        WebElement btn_calculate = driver.findElement(By.xpath("//input[@value='Calculate']"));
        btn_calculate.click(); //click on calculate
        WebElement txt_result = driver.findElement(By.xpath("//h2[text()='Result']"));
        Assert.assertTrue(txt_result.isDisplayed()); //verify if result is displayed
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
