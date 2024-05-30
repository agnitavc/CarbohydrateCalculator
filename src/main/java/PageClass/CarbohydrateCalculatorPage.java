package PageClass;

import FrameworkCore.BaseUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CarbohydrateCalculatorPage extends BaseUtils {

    WebDriverWait wait;

    @FindBy(xpath = "//input[@id='cage']")
    WebElement input_age;

    @FindBy(xpath = "//input[@id='cheightmeter']")
    WebElement input_height;

    @FindBy(xpath = "//input[@id='ckg']")
    WebElement input_weight;

    @FindBy(xpath = "//input[@value='Calculate']")
    WebElement btn_calculate;

    @FindBy(xpath = "//input[@value='Clear']")
    WebElement btn_clear;

    @FindBy(xpath = "//h2[contains(text(),'Result')]")
    WebElement label_result;

    @FindBy(xpath = "//table[@class='cinfoT']//following-sibling::tr//child::td[1]")
    List<WebElement> table_data_Goal;

    public CarbohydrateCalculatorPage() {
        wait = new WebDriverWait(baseDriver, Duration.ofSeconds(5));
        PageFactory.initElements(baseDriver, this);
    }

    public String getPageTitle() {
        String pgTitle = baseDriver.getTitle();
        return pgTitle;
    }

    public void inputAge(int age){
        input_age.sendKeys(String.valueOf(age));
    }

    public void inputHeight(double height){
        input_height.sendKeys(String.valueOf(height));
    }

    public void inputWeight(double weight){
        input_weight.sendKeys(String.valueOf(weight));
    }

    public void clickClearButton(){
        btn_clear.click();
    }

    public void clickCalculateButton(){
        btn_calculate.click();
    }

    public List<String> getResult(){
        wait.until(ExpectedConditions.visibilityOf(label_result));
        return table_data_Goal.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void verifyInputElementsAreDisplayed(){
        if (input_age.isDisplayed() && input_weight.isDisplayed() && input_height.isDisplayed()) {
            System.out.println("Carbohydrate Calculator input elements are displayed.");
        } else {
            System.out.println("Carbohydrate Calculator input elements are not displayed.");
        }
    }
}
