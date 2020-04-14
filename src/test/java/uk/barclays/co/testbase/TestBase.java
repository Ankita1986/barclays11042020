package uk.barclays.co.testbase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import uk.barclays.co.basepage.BasePage;
import uk.barclays.co.browserselector.BrowserSelector;
import uk.barclays.co.loadproperty.LoadProperty;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ankita
 */
public class TestBase extends BasePage {
    BrowserSelector browserSelector = new BrowserSelector();
   // String baseUrl = "https://www.barclays.co.uk//";
   LoadProperty loadProperty = new LoadProperty();

    String baseUrl = loadProperty.getProperty("baseUrl");

    String browser = loadProperty.getProperty("browser");


    @BeforeMethod(groups = {"smoke", "sanity", "regression"})
    public void openBrowser() {

        browserSelector.selectorBrowser(browser);
        driver.manage().window().maximize();
       // driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterMethod(groups = {"smoke", "sanity", "regression"})
    public void tearDown() {
        driver.quit();

    }
}
