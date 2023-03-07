package PW6.FactoryMethod;

public class Main {
    public static void main(String[] args) {
        DeliveryCompany ozon = new OzonOrderFactory();
        ozon.deliverOrder(OrderType.BIG);
        ozon.deliverOrder(OrderType.SMALL);

        System.out.println();

        DeliveryCompany yandexMarket = new YandexMarketOrderFactory();
        yandexMarket.deliverOrder(OrderType.SMALL);
        yandexMarket.deliverOrder(OrderType.MEDIUM);

    }
}
