package pgdp.collections;

public class Checkout {
    private Queue<PenguinCustomer> queue;
    private Queue<FishyProduct> bandBeforeCashier;
    private Queue<FishyProduct> bandAfterCashier;

    public pgdp.collections.Queue<PenguinCustomer> getQueue() {
        return queue;
    }

    public pgdp.collections.Queue<FishyProduct> getBandBeforeCashier() {
        return bandBeforeCashier;
    }

    public pgdp.collections.Queue<FishyProduct> getBandAfterCashier() {
        return bandAfterCashier;
    }

    public Checkout() {
        this.queue = new LinkedQueue<>();
        this.bandAfterCashier = new LinkedQueue<>();
        this.bandBeforeCashier = new LinkedQueue<>();
    }

    public int queueLength() {
        return queue.size();
    }

    public void serveNextCustomer() {
        if (!queue.isEmpty()) {
            PenguinCustomer ping = queue.dequeue();
            ping.placeAllProductsOnBand(bandBeforeCashier);

//            DataStructureLink<FishyProduct> temp = new DataStructureLink<>(new QueueConnector<>(bandBeforeCashier), new QueueConnector<>(bandAfterCashier));
//            temp.moveAllFromAToB();
            int price = 0;
//            StackConnector<FishyProduct> A = new StackConnector(ping.getProducts());

            while (!bandBeforeCashier.isEmpty()) {
                FishyProduct item=bandBeforeCashier.dequeue();
                price += item.getPrice();
                bandAfterCashier.enqueue(item);
            }

            ping.pay(price);

            ping.takeAllProductsFromBand(bandAfterCashier);


        }
    }

    @Override
    public String
    toString() {
        return "Checkout{" +
                "Queue=" + queue +
                ", BandBeforeCashier=" + bandBeforeCashier +
                ", BandAfterCashier=" + bandAfterCashier +
                '}';
    }

}



