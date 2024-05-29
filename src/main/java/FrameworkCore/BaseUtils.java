package FrameworkCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;


public class BaseUtils {

    public static WebDriver baseDriver;


    //open browser
    public void launchBrowser(String browserType){
        if (browserType.equalsIgnoreCase("Chrome")) {         //if browser type is chrome
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/src/test/resources/binaries/chromedriver.exe");
            baseDriver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/resources/binaries/msedgedriver.exe");
            baseDriver = new EdgeDriver();
        }
        baseDriver.manage().window().maximize();
        baseDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //Navigate to URL
    public void openUrl(String url){
        baseDriver.get(url);
    }

    //Close current browser
    public void closeBrowser(){
        baseDriver.close();
    }

    //Close all browsers
    public void closeAllBrowser(){
        baseDriver.quit();
    }


}
