import java.util.*;

public class CustomLinkedList<T> implements Iterable<T> {

    private List<T> linkedList;
    private int currentSize;

    public CustomLinkedList() {
        linkedList = new LinkedList<>();
    }

    public CustomLinkedList(List<T> list) {
        this.linkedList = list;
        this.currentSize = linkedList.size();
    }

    public boolean add(T elem) {
        currentSize++;
        linkedList.add(elem);
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && linkedList.get(currentIndex) != null;
            }

            @Override
            public T next() {
                return linkedList.get(currentIndex++);
            }
        };
        return it;
    }
}
