package CacheProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class CacheProxy {
    private String cachePath = "";
    private String cacheFile = "file.cache";
    private CacheType cacheType;

    public CacheProxy(CacheType cacheType) {
        this.cacheType = cacheType;
    }

    public Service cache(Service service) {
        // TODO
        InvocationHandler handler = new MyInvocationHandler();

        Service f = (Service)Proxy.newProxyInstance(ServiceImpl.class.getClassLoader(),
                new Class[] {ServiceImpl.class},
                handler);

//        Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
//                new Class[] { Foo.class },
//                handler);

        return f;
    }
}
