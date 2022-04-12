import java.util.Map;

public interface CountMap <T> {

    void add(T elem);

    int getCount(T o);

    int remove(T o);

    int size();

    void addAll(CountMap<T> source);

    Map toMap();

    void toMap(Map destination);

}
