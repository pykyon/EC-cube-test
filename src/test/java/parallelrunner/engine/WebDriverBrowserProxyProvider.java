package parallelrunner.engine;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import parallelrunner.api.Browser;

public class WebDriverBrowserProxyProvider {
    private final ThreadLocalBrowsers delegate;

    public WebDriverBrowserProxyProvider(ThreadLocalBrowsers delegate) {
        this.delegate = delegate;
    }
    
    public Browser get() {
        return (Browser) Proxy.newProxyInstance(
                Browser.class.getClassLoader(),
                new Class[] { Browser.class },
                proxyInvocationHandler);
    }
    
    private final InvocationHandler proxyInvocationHandler = new InvocationHandler() {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Browser browserForCurrentThread = delegate.get();
            try {
                return method.invoke(browserForCurrentThread, args);
            } catch (InvocationTargetException ite) {
                throw ite.getCause();
            }
        }
    };
}
