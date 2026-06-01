package org.example.tradingsystem;

public class NemoDriver implements StockerBrokerDriverInterface {
    private final NemoAPI nemoAPI;

    public NemoDriver(NemoAPI nemoAPI) {
        this.nemoAPI = nemoAPI;
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
        nemoAPI.purchasingStock(code, price, count);
    }

    @Override
    public void sell(String code, int price, int count) {
        nemoAPI.sellingStock(code, price, count);
    }

    @Override
    public int getPrice(String code) {
        int MIN_THRESHOLD = 100;
        return nemoAPI.getMarketPrice(code, MIN_THRESHOLD);
    }
}
