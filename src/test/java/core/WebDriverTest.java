package core;

import org.junit.After;
import org.openqa.selenium.WebDriver;

/**
 * Created by kenichiro_ota on 2014/04/21.
 */
public class WebDriverTest {
    protected WebDriver driver;

    @After
    public void tearDown() {
        driver.quit();
    }
}
