package CarbohydrateCalculatorWeb;

import FrameworkCore.BaseUtils;
import PageClass.CarbohydrateCalculatorPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ExampleTest{

    BaseUtils basePage;

    @BeforeTest
    public void setUp() {
        basePage= new BaseUtils();
        basePage.launchBrowser("Chrome");
        basePage.openUrl("https://www.calculator.net/carbohydrate-calculator.html");
    }


    @Test(description = "Verify url should open Carbohydrate Calculator page")
    public void verifyCarbohydrateCalculatorPage() {
        CarbohydrateCalculatorPage carbohydrateCalculatorPage=new CarbohydrateCalculatorPage();
        String pageTitle = carbohydrateCalculatorPage.getPageTitle();
        Assert.assertEquals(pageTitle,"Carbohydrate Calculator");
    }

    @Test(description = "Verify result is displayed with minimum valid age value.")
    public void verifyCalculationWithMinAgeValue(){
        CarbohydrateCalculatorPage carbohydrateCalculatorPage = new CarbohydrateCalculatorPage();
        carbohydrateCalculatorPage.clickClearButton();
        carbohydrateCalculatorPage.inputAge(18);
        carbohydrateCalculatorPage.inputHeight(165);
        carbohydrateCalculatorPage.inputWeight(100);
        carbohydrateCalculatorPage.clickCalculateButton();
        List<String> expectedGoalList =List.of(
                "Weight Maintenance",
                "Lose 0.5 kg/week",
                "Lose 1 kg/week",
                "Gain 0.5 kg/week",
                "Gain 1 kg/week");
        List<String> actualGoalList = carbohydrateCalculatorPage.getResult();
        Assert.assertEquals(actualGoalList,expectedGoalList);
    }

    @AfterTest
    public void tearDown(){
        basePage.closeAllBrowser();
    }


}
