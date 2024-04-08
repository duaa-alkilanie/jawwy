package tests;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
String urlForHomePageEgypt ="https://subscribe.jawwy.tv/eg-en";
//    String urlForHomePageUAE ="https://subscribe.jawwy.tv/ae-enn";
//    String urlForHomePageAlgeria ="https://subscribe.jawwy.tv/dz-en";


    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();

        driver.navigate().to(urlForHomePageEgypt);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            Files.move(screenshot, new File("src/test/resoures/screenShots" + result.getName() + ".png"));
        }

        System.out.println("afterMethodTearDown");
        driver.quit();
    }
}
