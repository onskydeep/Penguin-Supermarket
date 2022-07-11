package pgdp.collections;

public interface DataStructureConnector <T> {
    boolean hasNextElement();
    void addElement(T x);
    T removeNextElement();
}
