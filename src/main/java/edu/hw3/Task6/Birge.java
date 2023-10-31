package edu.hw3.Task6;

import java.util.PriorityQueue;

public class Birge implements StockMarket {
    private PriorityQueue<Stock> stocks;

    public Birge() {
        stocks = new PriorityQueue<>(new StockComparator());
    }

    @Override
    public void add(Stock stock) {
        isInvalidStock(stock);
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        isInvalidStock(stock);
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }

    private void isInvalidStock(Stock stock) {
        if (stock == null) {
            throw new IllegalArgumentException("STOCK IS NULL");
        }
    }
}
