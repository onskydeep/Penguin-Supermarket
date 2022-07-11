package pgdp.collections;

public class main {
    public static void main(String[] args){

        LinkedQueue q= new LinkedQueue<>();

        q.enqueue(22);
        q.enqueue("ss");
        q.enqueue("axxx");

        //System.out.println(q.size());
        q.dequeue();
        //System.out.println(q.size());

        q.dequeue();
        q.enqueue(2);
        //System.out.println(q.size());

        LinkedStack st=new LinkedStack<>();

        st.push("dddd");
        st.push("cw");
        System.out.println(st.size());

        st.push(232); st.push(32);

        st.pop();
        System.out.println(st.size());

        DataStructureLink data= new DataStructureLink(new QueueConnector<>(q), new StackConnector<>(st));
        data.moveAllFromAToB();

    }
}
