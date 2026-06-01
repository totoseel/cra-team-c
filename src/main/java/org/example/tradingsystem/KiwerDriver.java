package org.example.tradingsystem;

public class KiwerDriver implements StockerBrokerDriverInterface {
    KiwerAPI kiwerAPI = new KiwerAPI();

    @Override
    public String selectStockBroker() {
        return "";
    }

    @Override
    public boolean login(String id, String pass) {
        kiwerAPI.login(id, pass);
        return true;
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
