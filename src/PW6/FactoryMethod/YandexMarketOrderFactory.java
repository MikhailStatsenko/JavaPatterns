package PW6.FactoryMethod;

public class YandexMarketOrderFactory extends DeliveryCompany{
    @Override
    public Order createPackage(OrderType type) {
        Order order = null;

        switch (type) {
            case SMALL -> order = new YandexSmallOrder();
            case MEDIUM -> order = new YandexMediumOrder();
            case BIG -> order = new YandexBigOrder();
        }

        return order;
    }
}
