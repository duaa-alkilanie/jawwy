package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JordanCountryPage extends PageBase{
    public JordanCountryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="country-name")
    WebElement jordanTitle;
//    @FindBy(xpath = "//*[@id=\"main\"]/div/div[1]/div[3]/div")
//    WebElement jordanCountry;
    public WebElement checkJordanTitle(){
        return jordanTitle;
    }

public WebElement checkPriceAndCurrency(){
        return  checkJordanTitle();
}
}
