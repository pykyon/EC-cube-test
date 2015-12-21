package parallelrunner.api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Browser {
    WebElement find(String description, By locator);
    
    String getCurrentUrl();
    
    void goToUrl(String url);
    
    void cleanupAfterTest();
}
