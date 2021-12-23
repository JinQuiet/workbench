package com.jinquiet.pattren.creational;

import java.util.logging.Logger;

import com.jinquiet.logger.LoggerWrapper;

public class FactoryMethod {
    public final static Logger logger = LoggerWrapper.getLogger(FactoryMethod.class);

    public static void go(){
        logger.info("=======FactoryMethod Demo");

        boolean deliveryWorked  = new RoadLogisctics().createTransport().deliver();
        logger.info("Delivery status :: " + deliveryWorked);

        deliveryWorked  = new SeaLogisctics().createTransport().deliver();
        logger.info("Delivery status :: " + deliveryWorked);        

        deliveryWorked  = new BikeLogisctics().createTransport().deliver();
        logger.info("Delivery status :: " + deliveryWorked);

        logger.info("=======FactoryMethod Demo End");        
    }

}

interface Transport {
    public boolean deliver();
}

class Car implements Transport {
    @Override
    public boolean deliver() {
        FactoryMethod.logger.info("Delivering by Car");
        return true;
    }
}

class Boat implements Transport {
    @Override
    public boolean deliver() {
        FactoryMethod.logger.info("Delivering by Boat");
        return true;
    }
}

class Bike implements Transport {
    @Override
    public boolean deliver() {
        FactoryMethod.logger.info("Delivering by Bike");        
        return true;
    }
}

interface Logistics {
    public Transport createTransport();
}

class RoadLogisctics implements Logistics{
    public Transport createTransport() {
        FactoryMethod.logger.info("Creating transport for the Road");        
        return new Car();
    }
}

class SeaLogisctics implements Logistics {
    public Transport createTransport() {
        FactoryMethod.logger.info("Creating transport for the Sea");        
        return new Boat();
    }
}

class BikeLogisctics implements Logistics{
    public Transport createTransport() {
        FactoryMethod.logger.info("Creating transport for the Bike");        
        return new Bike();
    }
}