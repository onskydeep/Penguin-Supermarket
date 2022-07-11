package pgdp.collections;

public class PenguinSupermarket {

    private Checkout[] mylist;

    public PenguinSupermarket(int x) {
        if (x <= 0) ExceptionUtil.illegalArgument("Invalid size!");
        else mylist = new Checkout[x];
        for (int i = 0; i < mylist.length; i++)
            mylist[i] = new Checkout();
    }

    public Checkout[] getCheckouts() {
        return mylist;
    }

    public Checkout getCheckoutWithSmallestQueue() {
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < mylist.length; i++) {
            if (minimum > mylist[i].queueLength()) minimum = mylist[i].queueLength();
        }

        for (int i = 0; i < mylist.length; i++) {
            if (minimum == mylist[i].queueLength()) return mylist[i];
        }

        return null;

    }

    public void closeCheckout(int index) {
        if (index >= mylist.length || index < 0) ExceptionUtil.illegalArgument("Given cashier doesn't exist!");
        if (mylist.length == 1) ExceptionUtil.illegalArgument("Something is not right!");
        if (index <= mylist.length - 1) {
            Checkout[] newlist = new Checkout[mylist.length - 1];
            Checkout removal = mylist[index];

            int i = 0;
            while (i < index) {
                newlist[i] = mylist[i];
                i++;
            }
            i = index;
            while (i < mylist.length - 1) {
                newlist[i] = mylist[i + 1];
            }
            mylist = newlist;

            Queue<PenguinCustomer> a = removal.getQueue();

            Stack<PenguinCustomer> b = new LinkedStack<>();

            QueueConnector<PenguinCustomer> A = new QueueConnector<>(a);
            StackConnector<PenguinCustomer> B = new StackConnector<>(b);

            DataStructureLink<PenguinCustomer> PINGU = new DataStructureLink<>(A, B);

            PINGU.moveAllFromAToB();

            while (B.hasNextElement()) {
                B.removeNextElement().goToCheckout(this);
            }
        }
    }

    public void serveCustomers() {
        for (int i = 0; i < mylist.length; i++) mylist[i].serveNextCustomer();
    }

}
