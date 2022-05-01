package CacheProxy;

public class CacheProxy {
    private String cachePath = "";
    private String cacheFile = "file.cache";
    private CacheType cacheType;

    public CacheProxy(CacheType cacheType) {
        this.cacheType = cacheType;
    }

    public Service cache(Service service) {
        // TODO
        return null;
    }
}
