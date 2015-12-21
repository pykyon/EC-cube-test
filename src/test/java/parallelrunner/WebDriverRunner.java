package parallelrunner;

import com.google.inject.Guice;
import com.google.inject.Injector;
import parallelrunner.api.Browser;
import parallelrunner.api.FeatureExecutor;
import parallelrunner.engine.FixedThreadPoolFeatureExecutor;
import parallelrunner.engine.ThreadLocalBrowsers;
import parallelrunner.engine.WebDriverBrowserProxyProvider;
import parallelrunner.feature.DemoFeature;

public class WebDriverRunner {
    
    private final FeatureExecutor featureExecutor;

    public WebDriverRunner(FeatureExecutor featureExecutor) {
        this.featureExecutor = featureExecutor;
    }
    
    private void run() throws Exception {
        featureExecutor.initialize(3);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.execute(DemoFeature.class);
        featureExecutor.awaitTermination();
    }
    
    public static void main(String[] args) throws Exception {
        ThreadLocalBrowsers browsersSupplier = new ThreadLocalBrowsers(new WebDriverFactory());
        try {
        Browser browserProxy = new WebDriverBrowserProxyProvider(browsersSupplier).get();
        Injector injector = Guice.createInjector(new WebDriverModule(browserProxy));
        FeatureExecutor executor = new FixedThreadPoolFeatureExecutor(injector, browserProxy);
        WebDriverRunner runner = new WebDriverRunner(executor);

        long start = System.currentTimeMillis();
        runner.run();
        long end   = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
        } finally {
            browsersSupplier.shutdown();
        }
    }
}
