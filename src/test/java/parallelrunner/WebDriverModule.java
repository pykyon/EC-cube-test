package parallelrunner;

import com.google.inject.AbstractModule;
import parallelrunner.api.Browser;

public class WebDriverModule extends AbstractModule {
    private final Browser browserProxy;

    public WebDriverModule(Browser browserProxy) {
        this.browserProxy = browserProxy;
    }

    @Override
    protected void configure() {
        bind(Browser.class).toInstance(browserProxy);
    }
}
