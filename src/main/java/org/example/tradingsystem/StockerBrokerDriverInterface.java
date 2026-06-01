package org.example.tradingsystem;

public interface StockerBrokerDriverInterface {
    String selectStockBroker();

    boolean login(String id, String pass);

    void buy(String code, int price, int count);

    void sell(String code, int price, int count);

    int getPrice(String code);
}
