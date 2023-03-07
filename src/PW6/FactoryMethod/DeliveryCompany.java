package PW6.FactoryMethod;

public abstract class DeliveryCompany {
    public Order deliverOrder(OrderType type) {
        Order order = createPackage(type);

        order.getFromManufacturer();
        order.transportToWarehouse();
        order.deliverToPickPoint();

        System.out.println("Заказ доставлен!");
        return order;
    }

    protected abstract Order createPackage(OrderType type);

}
