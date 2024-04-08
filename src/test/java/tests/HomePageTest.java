package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends TestBase{
    HomePage homePage;
    @Test(priority = 1, description = "use the website as Egypt as country  ")
    public void useWebsiteAsGuest() {
        homePage = new HomePage(driver);
        String expected="Jawwy TV | Watch Movies, Series & Live TV - Enjoy Free Trial";
        String getTitle = driver.getTitle();
        Assert.assertEquals(getTitle, expected,
                "Jawwy TV | Watch Movies, Series & Live TV - Enjoy Free Trial\",\n" +
             "Incorrect title on home page");
    }
    @Test(priority = 2,description = "use the website as Egypt and check the types exist")
    public void goToEgyptAndCheckTypes(){
        homePage=new HomePage(driver);
       String LiteTypeValue=homePage.checkTypeLite().getText();
        String  classicTypeValue=homePage.checkClassicType().getText();
        String  premiumTypeValue=homePage.checkTypePremium().getText();
        System.out.println(LiteTypeValue + "\n" + classicTypeValue + "\n"+  premiumTypeValue);

       String liteTypeTitle="LITE";
       String  classicTypeTitle="CLASSIC";
       String premiumTypeTitle="PREMIUM";
       Assert.assertEquals(LiteTypeValue,liteTypeTitle,"Incorrect lite type value");
       Assert.assertEquals(classicTypeValue,classicTypeTitle,"Incorrect classic type value");
       Assert.assertEquals(premiumTypeValue,premiumTypeTitle,"Incorrect premium type value");
    }
  @Test(priority = 3,description = "go to UAE country and check types ")
    public void goToUAEAndCheckTypes(){
        homePage =new HomePage(driver);
        homePage.clickonCountryBtn().click();
        String currentTitle=homePage.selectCountryTitle().getText();
       System.out.println(currentTitle);
       homePage.clickonCountryBtn().click();
       Boolean UAEBtn =homePage.clickonCountryBtn().isEnabled();

       System.out.println("UAE btn is enable"+UAEBtn );
        String expectedTitle= "Select Your Country";
        Assert.assertEquals(expectedTitle,currentTitle,"Incorrect current country title");
        Assert.assertTrue(UAEBtn,"UAE country is not  enable");
  }
    @Test(priority = 4,description = "check the prices and currency for Egypt")
    public void checkPricesAndCurrency(){
        homePage =new HomePage(driver);
       String priceAndCurrency= homePage.checkPriceAndCurrency().getText();
       String expected ="From 7.00 Egyptian pound/month";
        System.out.println(expected);
       Assert.assertEquals(priceAndCurrency,expected,"Incorrect price and currency");

  }}




