package pgdp.collections;

public class PenguinCustomer {
    private final String name;
    private int money;
    private Stack<FishyProduct> products;

    public PenguinCustomer(String name, int money) {
        if (name.equals(null)) ExceptionUtil.illegalArgument("Name can't be null!");
        if (money < 0) ExceptionUtil.illegalArgument("Available money can't be non-positive number!");
        this.name = name;
        this.money = money;
        products= new LinkedStack<>();
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public Stack<FishyProduct> getProducts() {
        return products;
    }

    public void addProductToBasket(FishyProduct newproduct) {
        if (newproduct == null) return;
        products.push(newproduct);
    }

    public void placeAllProductsOnBand(Queue<FishyProduct> band) {
        if (band == null) return;
        DataStructureLink<FishyProduct> temp = new DataStructureLink<>(new StackConnector<>(products), new QueueConnector<>(band));
        temp.moveAllFromAToB();
    }

    public void takeAllProductsFromBand(Queue<FishyProduct> band) {
        if (band == null) return;
        DataStructureLink<FishyProduct> temp = new DataStructureLink<>(new QueueConnector<>(band), new StackConnector<>(products));
        temp.moveAllFromAToB();
    }

    public void pay(int price) {
        if (price < 0)
            ExceptionUtil.illegalArgument("Total price have to be positive numbers!!!");
        if(money<price)
            ExceptionUtil.illegalArgument("Insufficient funds!");
        money -= price;
    }

    @Override
    public String toString() {
        return ("FishyProduct{" + "name='" + name + '\'' + ", money=" + money + ", product=" + products);
    }

    public void goToCheckout(PenguinSupermarket temp){

        Checkout A= temp.getCheckoutWithSmallestQueue();

        A.getQueue().enqueue(this);

    }


}
