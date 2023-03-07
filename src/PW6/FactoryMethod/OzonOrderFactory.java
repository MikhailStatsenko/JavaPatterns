package PW6.FactoryMethod;

public class OzonOrderFactory extends DeliveryCompany{

    @Override
    public Order createPackage(OrderType type) {
        Order order = null;

        switch (type) {
            case SMALL -> order = new OzonSmallOrder();
            case MEDIUM -> order = new OzonMediumOrder();
            case BIG -> order = new OzonBigOrder();
        }

        return order;
    }
}
