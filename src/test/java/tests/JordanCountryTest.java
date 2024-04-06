package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlgeriaCountryPage;
import pages.HomePage;
import pages.UAECountryPage;

public class AlgeriaCountryTest extends TestBase {
    HomePage homePage;
    AlgeriaCountryPage algeriaCountryPage;

    @Test(priority = 1, description = "click on AlgeriaCountry btn and check the types")
    public void checkTheAlgeriaCountryTypes() {
        homePage = new HomePage(driver);
        algeriaCountryPage = new AlgeriaCountryPage(driver);
        homePage.clickonCountryBtn().click();
        homePage.clickOnCountryAlgeriaBtn().click();
        Boolean algeriaCountryBtn = homePage.clickOnCountryAlgeriaBtn().isEnabled();
        String LiteTypeValue = homePage.checkTypeLite().getText();
        String classicTypeValue = homePage.checkClassicType().getText();
        String premiumTypeValue = homePage.checkTypePremium().getText();
        System.out.println(LiteTypeValue + "\n" + classicTypeValue + "\n" + premiumTypeValue);

        String liteTypeTitle = "LITE";
        String classicTypeTitle = "CLASSIC";
        String premiumTypeTitle = "PREMIUM";
        Assert.assertTrue(algeriaCountryBtn, "algeria country btn is not enable");
        Assert.assertEquals(LiteTypeValue, liteTypeTitle);
        Assert.assertEquals(classicTypeValue, classicTypeTitle);
        Assert.assertEquals(premiumTypeValue, premiumTypeTitle);

    }

    @Test(priority = 2, description = "check the prices and currency for UAE")
    public void checkPricesAndCurrency() {
        homePage = new HomePage(driver);
        algeriaCountryPage = new AlgeriaCountryPage(driver);
        homePage.clickonCountryBtn().click();
        homePage.clickOnCountryAlgeriaBtn().click();
        String priceAndCurrency = homePage.checkPriceAndCurrency().getText();
        String expected = "";
        System.out.println(expected);
        Assert.assertEquals(priceAndCurrency, expected);
    }
}