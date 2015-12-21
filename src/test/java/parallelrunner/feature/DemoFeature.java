package parallelrunner.feature;

import parallelrunner.api.Feature;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import parallelrunner.page.GooglePage;

@Singleton
public class DemoFeature implements Feature {
    
    @Inject 
    private GooglePage googlePage;
    
    @Override
    public void run() {
        googlePage.open();
        googlePage.search("Selenium WebDriver\n");
    }
}
