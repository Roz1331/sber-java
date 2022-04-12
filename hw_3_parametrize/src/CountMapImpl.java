import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T>{

    private Map<T, Integer> itemMap = new HashMap<>();

    @Override
    public void add(T elem) {
        if(itemMap.containsKey(elem)) {
            itemMap.replace(elem, itemMap.get(elem) + 1);
        }
        else itemMap.put(elem, 1);
    }

    @Override
    public int getCount(T elem) {
        return itemMap.getOrDefault(elem, 0);
    }

    @Override
    public int remove(T elem) {
        return itemMap.remove(elem);
    }

    @Override
    public int size() {
        return itemMap.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public void addAll(CountMap<T> source){
        Map<T, Integer> help = source.toMap();
        for(Map.Entry<T, Integer> x: help.entrySet()) {
            this.add(x.getKey());
        }
    }

    @Override
    public Map toMap() {
        return itemMap;
    }

    @Override
    public void toMap(Map destination) {
        destination.putAll(itemMap);
    }
}
