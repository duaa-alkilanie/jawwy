package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlgeriaCountryPage extends PageBase{
    public AlgeriaCountryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="country-name")
    WebElement algeriaTitle;
//    @FindBy(xpath = "//*[@id=\"main\"]/div/div[1]/div[3]/div")
//    WebElement jordanCountry;
    public WebElement checkAlgeriaTitle(){
        return algeriaTitle;
    }

public WebElement checkPriceAndCurrency(){
        return  checkAlgeriaTitle();
}

}
