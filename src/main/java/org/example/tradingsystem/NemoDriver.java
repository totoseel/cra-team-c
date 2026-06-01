package org.example.tradingsystem;

public class NemoDriver implements StockerBrokerDriverInterface {
    NemoAPI nemoAPI;

    public NemoDriver(NemoAPI nemoAPI) {
        this.nemoAPI = nemoAPI;
    }

    @Override
    public String selectStockBroker() {
        return "";
    }

    @Override
    public boolean login(String id, String pass) {
        try {
            nemoAPI.certification(id, pass);
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
