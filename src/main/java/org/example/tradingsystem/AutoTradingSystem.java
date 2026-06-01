package org.example.tradingsystem;

import java.util.*;
import java.util.function.Supplier;

public class AutoTradingSystem {

    private static final int TREND_SAMPLE_COUNT = 3;

    private final Map<String, Supplier<StockerBrokerDriverInterface>> brokerRegistry = new HashMap<>();
    StockerBrokerDriverInterface selectedDriver;

    AutoTradingSystem() {
        registerStockBroker("kiwer", () -> new KiwerDriver(new KiwerAPI()));
        registerStockBroker("키워", () -> new KiwerDriver(new KiwerAPI()));
        registerStockBroker("nemo", () -> new NemoDriver(new NemoAPI()));
        registerStockBroker("네모", () -> new NemoDriver(new NemoAPI()));
    }

    AutoTradingSystem(StockerBrokerDriverInterface driver) {
        this();
        selectStockBroker(driver);
    }

    public void selectStockBroker() {
        StockerBrokerDriverInterface stockerBrokerDriver;

        System.out.println("증권사를 선택하세요");
        System.out.print("Kiwer : 1 입력 / Nemo : 2 입력 -> ");

        Scanner scanner = new Scanner(System.in);
        String selectedBroker = scanner.next();
        System.out.println(selectedBroker);

        if (selectedBroker.equals("1")) {
            stockerBrokerDriver = new KiwerDriver(new KiwerAPI());
        } else if (selectedBroker.equals("2")) {
            stockerBrokerDriver = new NemoDriver(new NemoAPI());
        } else {
            System.out.println("잘못 입력하였습니다. 1 또는 2를 입력해주세요");
            throw new RuntimeException("Invalid stock broker selected");
        }

        selectedDriver = stockerBrokerDriver;
    }

    public void registerStockBroker(String brokerName, Supplier<StockerBrokerDriverInterface> driverFactory) {
        brokerRegistry.put(brokerName.toLowerCase(Locale.ROOT), driverFactory);
    }

    public void selectStockBroker(StockerBrokerDriverInterface driver) {
        selectedDriver = driver;
    }

    public void selectStockBroker(String brokerName) {
        Supplier<StockerBrokerDriverInterface> driverFactory =
                brokerRegistry.get(brokerName.toLowerCase(Locale.ROOT));

        if (driverFactory == null) {
            throw new IllegalArgumentException("Unsupported stock broker: " + brokerName);
        }

        selectStockBroker(driverFactory.get());
    }

    private StockerBrokerDriverInterface driver() {
        if (selectedDriver == null) {
            throw new IllegalStateException("Stock broker is not selected.");
        }
        return selectedDriver;
    }

    public void login(String id, String password) {
        driver().login(id, password);
    }

    public void buy(String stockCode, int price, int quantity) {
        driver().buy(stockCode, price, quantity);
    }

    public void sell(String stockCode, int price, int quantity) {
        driver().sell(stockCode, price, quantity);
    }

    public int getPrice(String stockCode) {
        return driver().getPrice(stockCode);
    }

    public void buyNiceTiming(String code, int amount) {
        int[] prices = readTrendPrices(code);
        int currentPrice = prices[prices.length - 1];

        if (!isRisingTrend(prices)) {
            return;
        }

        int quantity = amount / currentPrice;
        if (quantity <= 0) {
            return;
        }

        buy(code, currentPrice, quantity);
    }

    public void sellNiceTiming(String code, int amount) {
        int[] prices = readTrendPrices(code);
        int currentPrice = prices[prices.length - 1];

        if (!isFallingTrend(prices)) {
            return;
        }

        int quantity = amount / currentPrice;
        if (quantity <= 0) {
            return;
        }

        sell(code, currentPrice, quantity);
    }

    private int[] readTrendPrices(String code) {
        int[] prices = new int[TREND_SAMPLE_COUNT];

        for (int i = 0; i < TREND_SAMPLE_COUNT; i++) {
            prices[i] = getPrice(code);
        }

        return prices;
    }

    private boolean isRisingTrend(int[] prices) {
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] >= prices[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isFallingTrend(int[] prices) {
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] <= prices[i]) {
                return false;
            }
        }
        return true;
    }
}