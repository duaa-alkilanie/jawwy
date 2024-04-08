package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JordanCountryPage;
import pages.HomePage;

public class JordanCountryTest extends TestBase {
    HomePage homePage;
    JordanCountryPage jordanCountryPage;

    @Test(priority = 1, description = "click on jordan Country btn and check the types")
    public void checkTheJordanCountryTypes() {
        homePage = new HomePage(driver);
        jordanCountryPage = new JordanCountryPage(driver);
        homePage.clickonCountryBtn().click();
        homePage.clickOnCountryJordanBtn().click();
        Boolean algeriaCountryBtn = homePage.clickOnCountryJordanBtn().isEnabled();
        String LiteTypeValue = homePage.checkTypeLite().getText();
        String classicTypeValue = homePage.checkClassicType().getText();
        String premiumTypeValue = homePage.checkTypePremium().getText();
        System.out.println(LiteTypeValue + "\n" + classicTypeValue + "\n" + premiumTypeValue);

        String liteTypeTitle = "LITE";
        String classicTypeTitle = "CLASSIC";
        String premiumTypeTitle = "PREMIUM";
        Assert.assertTrue(algeriaCountryBtn, "jordan country btn is not enable");
        Assert.assertEquals(LiteTypeValue,liteTypeTitle,"Incorrect lite type value");
        Assert.assertEquals(classicTypeValue,classicTypeTitle,"Incorrect classic type value");
        Assert.assertEquals(premiumTypeValue,premiumTypeTitle,"Incorrect premium type value");

    }

    @Test(priority = 2, description = "check the prices and currency for Jorden")
    public void checkPricesAndCurrency() {
        homePage = new HomePage(driver);
        jordanCountryPage = new JordanCountryPage(driver);
        homePage.clickonCountryBtn().click();
        homePage.clickOnCountryJordanBtn().click();
        String priceAndCurrency = homePage.checkPriceAndCurrency().getText();
        String expected = "From 0.99 JOD/week";
        System.out.println(expected);
        Assert.assertEquals(priceAndCurrency, expected);
    }
}