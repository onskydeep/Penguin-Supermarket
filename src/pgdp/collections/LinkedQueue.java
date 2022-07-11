package pgdp.collections;

public class LinkedQueue<T> implements Queue<T> {
    private List<T> first;
    private List<T> last;

    public LinkedQueue() {
        first = null;
        last = null;
    }

    @Override
    public int size() {
        if (isEmpty()) return 0;
        return first.length();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(T x) {
        if (isEmpty())
            first = last = new List<T>(x);

        else {
            last.insert(x);
            last=last.getNext();
        }
        System.out.println(first+"first");
        System.out.println(last +"last");

    }

    public T dequeue() {

        if (isEmpty()) return null;

        else {
            T ans = first.getInfo(); //returning value
            if (last == first) last = null;
            first = first.getNext();
            return ans;
        }

    }


}
