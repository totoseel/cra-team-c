package org.example.tradingsystem;

import java.util.*;

public class MockStockerBrokerDriver implements StockerBrokerDriverInterface {
    private final Queue<Integer> priceSequence = new ArrayDeque<>();
    private final List<Order> buyOrders = new ArrayList<>();
    private final List<Order> sellOrders = new ArrayList<>();

    private String loginId;
    private String loginPassword;
    private int lastPrice;
    private int priceCallCount;

    public MockStockerBrokerDriver(int... prices) {
        setPriceSequence(prices);
    }

    public void setPriceSequence(int... prices) {
        priceSequence.clear();
        lastPrice = 0;
        priceCallCount = 0;
        for (int price : prices) {
            if (price <= 0) {
                throw new IllegalArgumentException("price must be positive.");
            }
            priceSequence.add(price);
        }
    }

    @Override
    public boolean login(String id, String password) {
        loginId = id;
        loginPassword = password;
        return true;
    }

    @Override
    public void buy(String stockCode, int price, int quantity) {
        buyOrders.add(new Order(stockCode, price, quantity));
    }

    @Override
    public void sell(String stockCode, int price, int quantity) {
        sellOrders.add(new Order(stockCode, price, quantity));
    }

    @Override
    public int getPrice(String stockCode) {
        priceCallCount++;
        if (!priceSequence.isEmpty()) {
            lastPrice = priceSequence.remove();
            return lastPrice;
        }
        if (lastPrice > 0) {
            return lastPrice;
        }
        throw new IllegalStateException("Price sequence is empty.");
    }

    public String getLoginId() {
        return loginId;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public int getPriceCallCount() {
        return priceCallCount;
    }

    public List<Order> getBuyOrders() {
        return Collections.unmodifiableList(buyOrders);
    }

    public List<Order> getSellOrders() {
        return Collections.unmodifiableList(sellOrders);
    }

    public static class Order {
        private final String stockCode;
        private final int price;
        private final int quantity;

        public Order(String stockCode, int price, int quantity) {
            this.stockCode = stockCode;
            this.price = price;
            this.quantity = quantity;
        }

        public String getStockCode() {
            return stockCode;
        }

        public int getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}
