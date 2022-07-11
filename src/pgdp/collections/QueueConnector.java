package pgdp.collections;

public class QueueConnector <T> implements DataStructureConnector <T> {

    private final Queue <T> q;

    public QueueConnector(Queue<T> qnew) {
        this.q = qnew;
    }

    @Override
    public boolean hasNextElement() {
        return !q.isEmpty();
    }

    @Override
    public void addElement(T x) {
        q.enqueue(x);
    }

    @Override
    public T removeNextElement() {
        return q.dequeue();
    }
}
