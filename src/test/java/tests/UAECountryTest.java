package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UAECountryPage;

public class UAECountryTest extends TestBase {
    HomePage homePage;
    UAECountryPage UAEPage;

    @Test(priority = 1, description = "check the UAE types that return ")
    public void checkUAETypes() {
        homePage = new HomePage(driver);
        UAEPage = new UAECountryPage(driver);
        homePage.clickonCountryBtn().click();
        homePage.clickOnUAECountry().click();
        String LiteTypeValue = homePage.checkTypeLite().getText();
        String classicTypeValue = homePage.checkClassicType().getText();
        String premiumTypeValue = homePage.checkTypePremium().getText();
        System.out.println(LiteTypeValue + "\n" + classicTypeValue + "\n" + premiumTypeValue);

        String liteTypeTitle = "LITE";
        String classicTypeTitle = "CLASSIC";
        String premiumTypeTitle = "PREMIUM";
        Assert.assertEquals(LiteTypeValue, liteTypeTitle);
        Assert.assertEquals(classicTypeValue, classicTypeTitle);
        Assert.assertEquals(premiumTypeValue, premiumTypeTitle);
    }

    @Test(priority = 2, description = "check the prices and currency for UAE")
    public void checkPricesAndCurrency() {
        homePage = new HomePage(driver);
        UAEPage = new UAECountryPage(driver);
        homePage.clickonCountryBtn().click();
        homePage.clickOnUAECountry().click();
        String priceAndCurrency = homePage.checkPriceAndCurrency().getText();
        String expected = "From 10.00 AED/week";
        System.out.println(expected);
        Assert.assertEquals(priceAndCurrency, expected);

    }
}