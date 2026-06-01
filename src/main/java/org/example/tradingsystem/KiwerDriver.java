package org.example.tradingsystem;

public class KiwerDriver implements StockerBrokerDriverInterface {
    private final KiwerAPI kiwerAPI;

    public KiwerDriver(KiwerAPI kiwerAPI) {
        this.kiwerAPI = kiwerAPI;
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
        kiwerAPI.buy(code, price, count);
    }

    @Override
    public void sell(String code, int price, int count) {
        kiwerAPI.sell(code, price, count);
    }

    @Override
    public int getPrice(String code) {
        return kiwerAPI.currentPrice(code);
    }
}
