package pgdp.collections;

public class StackConnector <T> implements DataStructureConnector <T> {

    private final Stack <T> stck;

    public StackConnector(Stack<T> st) {
        this.stck = st;
    }

    @Override
    public boolean hasNextElement() {
        return !stck.isEmpty();
    }

    @Override
    public void addElement(T x) {
        stck.push(x);
    }

    @Override
    public T removeNextElement() {
        return stck.pop();
    }

}
