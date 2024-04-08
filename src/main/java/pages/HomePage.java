package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
            super(driver);
        }
@FindBy(id="name-lite")
    WebElement   liteType;
    @FindBy (id = "name-classic")
    WebElement classicType;
    @FindBy (id="name-premium")
    WebElement  premiumType;

    @FindBy(id = "country-btn")
    WebElement countryBtn;
    @FindBy(id = "country-title")
    WebElement selectCountryTitle;
    @FindBy(id = "ae")
    WebElement UAEBtn;
    @FindBy(id = "jo-contry-lable")
    WebElement jordanBtnCountry;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[1]/div[3]/div")
    WebElement priceAndCurrency;

    public WebElement  checkClassicType(){
       return  classicType;
    }
  public WebElement checkTypeLite(){
        return liteType;
  }
  public WebElement checkTypePremium(){
        return  premiumType;
  }
  public WebElement clickonCountryBtn(){
        return countryBtn;
  }
public WebElement selectCountryTitle(){
        return selectCountryTitle;
}
public WebElement clickOnUAECountry(){
        return UAEBtn;
}
public WebElement clickOnCountryJordanBtn(){
        return jordanBtnCountry;
}
public WebElement checkPriceAndCurrency(){
        return priceAndCurrency;
}
}
