package CacheProxy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceImpl implements Service{
    @Override
    public double doHardWork(String str, int number) {
        return str.length() * number;
    }

    @Override
    public List<String> run(String item, double value, Date date) {
        List<String> res = new ArrayList<>();

        res.add("str1");
        res.add("str2");
        res.add("str3");

        return res;
    }

    @Override
    public List<String> work(String item) {
        return null;
    }
}
