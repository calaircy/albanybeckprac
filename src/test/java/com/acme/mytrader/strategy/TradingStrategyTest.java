package com.acme.mytrader.strategy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.acme.mytrader.strategy.TradingStrategy.Strategy.BUY;
import static com.acme.mytrader.strategy.TradingStrategy.Strategy.NA;

public class TradingStrategyTest {
    TradingStrategy tradeStrategy;

    @Before
    public void setUp (){
        tradeStrategy = new TradingStrategy(null, 0, 55.0, 100, "IBM");
    }

    @Test
    public void testsNothingToBuy() {
        Assert.assertEquals(NA,tradeStrategy.getTradingStrategy(70.2));
    }

    @Test
    public void testFromNAToBuy() {
        Assert.assertEquals(NA,tradeStrategy.getStrategyInUse());
        Assert.assertEquals(BUY,tradeStrategy.getTradingStrategy(40.2));
    }

    @Test
    public void testNoDuplicatedBuy() {
        Assert.assertEquals(NA,tradeStrategy.getStrategyInUse());
        Assert.assertEquals(BUY,tradeStrategy.getTradingStrategy(40.2));
        Assert.assertEquals(NA,tradeStrategy.getTradingStrategy(30.2));
    }

    @Test
    public void testNoDuplicatedBuyNABuy() {
        Assert.assertEquals(NA,tradeStrategy.getStrategyInUse());
        Assert.assertEquals(BUY,tradeStrategy.getTradingStrategy(40.2));
        Assert.assertEquals(NA,tradeStrategy.getTradingStrategy(60.2));
        Assert.assertEquals(NA,tradeStrategy.getTradingStrategy(40.2));

    }
}
