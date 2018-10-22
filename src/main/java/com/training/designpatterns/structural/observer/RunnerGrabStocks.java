package com.training.designpatterns.structural.observer;

public class RunnerGrabStocks {
    public static void main(String... args) {
        StockGrabber stockGrabber = new StockGrabber();
        StockObserver ford = new StockObserver("ford", stockGrabber);

        stockGrabber.setApplePrice(179.0);
        stockGrabber.setFordPrice(10.0);
        stockGrabber.setGooglePrice(200.0);
        stockGrabber.setIbmPrice(50.0);

        StockObserver google = new StockObserver("google", stockGrabber);

        stockGrabber.setApplePrice(179.0);
        stockGrabber.setFordPrice(10.0);
        stockGrabber.setGooglePrice(200.0);
        stockGrabber.setIbmPrice(50.0);

        StockObserver apple = new StockObserver("apple", stockGrabber);

        stockGrabber.setApplePrice(179.0);
        stockGrabber.setFordPrice(10.0);
        stockGrabber.setGooglePrice(200.0);
        stockGrabber.setIbmPrice(50.0);

        stockGrabber.unregister(google);
        StockObserver ibm = new StockObserver("ibm", stockGrabber);

        stockGrabber.setApplePrice(179.0);
        stockGrabber.setFordPrice(10.0);
        stockGrabber.setGooglePrice(200.0);
        stockGrabber.setIbmPrice(50.0);
    }
}
