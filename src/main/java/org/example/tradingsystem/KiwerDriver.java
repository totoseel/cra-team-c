package org.example.tradingsystem;

public class KiwerDriver implements StockerBrokerDriverInterface {
    @Override
    public String selectStockBroker() {
        return "";
    }

    @Override
    public String login(String id, String pass) {
        return "";
    }

    @Override
    public void buy(String code, int price, int count) {

    }

    @Override
    public void sell(String code, int price, int count) {

    }

    @Override
    public int getPrice(String code) {
        return 0;
    }
}
