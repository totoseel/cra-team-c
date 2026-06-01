package org.example.tradingsystem;

import java.util.Scanner;

public class AutoTradingSystem {
    StockerBrokerDriverInterface stockerBrokerDriver;

    public void selectStockBroker() {
        System.out.println("증권사를 선택하세요");
        System.out.print("Kiwer : 1 입력 / Nemo : 2 입력 -> ");
        Scanner scanner = new Scanner(System.in);
        String selectedBroker = scanner.next();
        System.out.println(selectedBroker);

        if(selectedBroker.equals("1")){
            stockerBrokerDriver = new KiwerDriver(new KiwerAPI());
        } else if(selectedBroker.equals("2")) {
            stockerBrokerDriver = new NemoDriver(new NemoAPI());
        } else {
            System.out.println("잘못 입력하였습니다. 1 또는 2를 입력해주세요");
            throw new RuntimeException("Invalid stock broker selected");
        }
    }

    public void buyNiceTiming(int code, int amount){

    }

    public void sellNiceTiming(int code, int count){

    }
}
