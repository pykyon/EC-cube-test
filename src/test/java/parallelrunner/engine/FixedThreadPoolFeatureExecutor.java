package parallelrunner.engine;

import com.google.inject.Injector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import parallelrunner.api.Browser;
import parallelrunner.api.FeatureExecutor;
import parallelrunner.api.Feature;

public class FixedThreadPoolFeatureExecutor implements FeatureExecutor {
    private final Injector injector;
    
    private ExecutorService executor;
    
    private final Browser browserProxy;

    public FixedThreadPoolFeatureExecutor(Injector injector, Browser browserProxy) {
        this.injector = injector;
        this.browserProxy = browserProxy;
    }

    @Override
    public void initialize(int threadPoolSize) {
        executor = Executors.newFixedThreadPool(threadPoolSize);
    }

    @Override
    public void execute(Class<? extends Feature> featureType) {
        final Feature feature = injector.getInstance(featureType);
        executor.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    feature.run();
                } catch (Exception e) {
                    //TODO handle exception: log, take a screenshot or something...
                } finally {
                    browserProxy.cleanupAfterTest();
                }
            }
        });
    }

    @Override
    public void awaitTermination() throws Exception {
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }
}
