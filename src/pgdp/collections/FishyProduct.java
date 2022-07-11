package pgdp.collections;

public class FishyProduct {
    private final String name;
    private final int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public FishyProduct(String name, int price) {
        if (name.equals(null)) ExceptionUtil.illegalArgument("Name can not be null!");
        if (price <= 0) ExceptionUtil.illegalArgument("Price have to be positive number!");
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return ("FishyProduct{" + "name='" + name + '\'' + ", price=" + price + '}');
    }

}
