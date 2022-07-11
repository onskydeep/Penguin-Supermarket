package pgdp.collections;

public class LinkedStack <T> implements Stack <T> {
    private List <T> top;

    public LinkedStack(){
        top=null;
    }

    @Override
    public boolean isEmpty() {
        return top==null;
    }

    @Override
    public int size() {
        if (isEmpty()) return 0;
        return top.length();
    }

    public T pop(){

        T removal = null;

        if(!isEmpty()){
            removal=top.getInfo();
            top=top.getNext();
        }

        return removal;

    }

    public void push(T x){
        List <T> newbox= new List<T>(x,top);
        top=newbox;
    }


}
