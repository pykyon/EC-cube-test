package parallelrunner;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {
    public RemoteWebDriver create() {
        return new FirefoxDriver();
    }
}
