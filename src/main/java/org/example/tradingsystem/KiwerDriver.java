package org.example.tradingsystem;

public class KiwerDriver implements StockerBrokerDriverInterface {
    KiwerAPI kiwerAPI;

    public KiwerDriver(KiwerAPI kiwerAPI) {
        this.kiwerAPI = kiwerAPI;
    }

    @Override
    public String selectStockBroker() {
        return "";
    }

    @Override
    public boolean login(String id, String pass) {
        try {
            kiwerAPI.login(id, pass);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
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
