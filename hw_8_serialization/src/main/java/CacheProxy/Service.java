package CacheProxy;

import java.util.Date;
import java.util.List;

public interface Service {
    public double doHardWork(String str, int number);
    @Cache(cacheType = CacheType.FILE, fileNamePrefix = "data", zip = true, identityBy = {String.class, double.class})
    List<String> run(String item, double value, Date date);

    @Cache(cacheType = CacheType.IN_MEMORY, listList = 100_000)
    List<String> work(String item);

}
