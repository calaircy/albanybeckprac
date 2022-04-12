package com.acme.mytrader.price;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.strategy.TradingStrategy;

import java.util.Map;
import java.util.TreeMap;

public class PriceListenerImpl implements PriceListener{
    private final static String SECURITY_IBM = "IBM";
    Map<String, TradingStrategy> strategyMap;
    ExecutionService executionService;

    public PriceListenerImpl (){
        this.strategyMap = new TreeMap<>();
        TradingStrategy strategy = new TradingStrategy(null, 0,55.0, 100, SECURITY_IBM);
        strategyMap.put(SECURITY_IBM, strategy);
    }
    @Override
    public void priceUpdate(String security, double price) {
        TradingStrategy tStrategy = strategyMap.get(security);
        TradingStrategy.Strategy strategy = tStrategy.getTradingStrategy(price);

        if(strategy != null){
            switch(strategy){
                case BUY: executionService.buy(security, price, tStrategy.getBuyVolume());
                    break;
                case SELL: executionService.sell(security, price, tStrategy.getBuyVolume());
                    break;
                default:
                    break;
            }
        }
    }
}
