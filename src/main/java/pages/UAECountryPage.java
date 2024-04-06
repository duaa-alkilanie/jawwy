package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UAECountryPage extends PageBase{
    public UAECountryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[1]/div[3]/div")
    WebElement priceAndCurrencyForUAE;

    public WebElement checkPriceAndCurrency(){
        return  priceAndCurrencyForUAE;
    }
}
