package com.acme.mytrader.strategy;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {
    Double sellMark;
    int sellVolume;
    Double buyMark;
    int buyVolume;
    String security;

    Strategy strategyInUse = Strategy.NA;

    public enum Strategy {
        BUY, SELL, NA
    }

    public TradingStrategy(Double sellMark, int sellVolume, Double buyMark, int buyVolume, String security) {
        this.sellMark = sellMark;
        this.sellVolume = sellVolume;
        this.buyMark = buyMark;
        this.buyVolume = buyVolume;
        this.security = security;
    }

    public int getSellVolume() {
        return sellVolume;
    }

    public int getBuyVolume() {
        return buyVolume;
    }

    public Strategy getStrategyInUse() {
        return strategyInUse;
    }

    public Strategy getTradingStrategy(Double price){
        if((buyMark != null ) && (!strategyInUse.equals(Strategy.BUY)) && (buyMark.compareTo(price) > 0)){
            strategyInUse = Strategy.BUY;
            return Strategy.BUY;
        }
        else if((sellMark != null ) && (sellMark.compareTo(price) < 0)) {
            return Strategy.SELL;
        }

        return Strategy.NA;
    }
}
