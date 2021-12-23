package com.jinquiet;

import java.util.logging.Logger;

import com.jinquiet.logger.LoggerWrapper;

/**
 * Workbench
 *
 */
public class Workbench {
    private final static Logger logger = LoggerWrapper.getLogger(Workbench.class.getName());

    public static void main(String[] args) throws InterruptedException {
        logger.info("It's working");
logger.info("Building BasicOuterClass");
        logger.info("==========NestedClassDemo");
        OuterClass outerClass = new OuterClass();

        OuterClass.NestedClass nestedClass = outerClass.new NestedClass();

        OuterClass.NestedClass on = new OuterClass().new NestedClass();

        //outerClass.i;
        //outerClass.(new NestedClass())

        logger.info("==========NestedClassDemo End");

        BasicOuterClass basicOuterClass = new BasicOuterClass();

        BasicOuterClass.NestedStaticClass nestedStaticClass= new BasicOuterClass.NestedStaticClass();

        //BasicOuterClass.i;
        Integer integer = basicOuterClass.i;
        //BasicOuterClass.NestedStaticClass

        logger.info("==========Local Class Demo");
        LocalOuterClass localOuterClass = new LocalOuterClass();
        LocalOuterClass.go();

        logger.info("==========Anonimous Class Demo");        
        AnonimousClassTest act = new AnonimousClassTest();
        act.go();

        logger.info("==========Lambda Class Demo");                
        LambdaTest lt = new LambdaTest();
        lt.lambdaDemo();

    }
}

//Вложенный класс
class OuterClass {
    private final static Logger logger = LoggerWrapper.getLogger(OuterClass.class.getName());

    public OuterClass() {
        logger.info("Building OUTER CLASS");
    }

    public Integer i;

    class NestedClass {
        public NestedClass() {
            logger.info("Building NESTED CLASS");
        }

        public void go(){
            logger.info("I'm in the NESTED CLASS");
        }
    }
}

//Вложенный статический класс
class BasicOuterClass {
    private final static Logger logger = LoggerWrapper.getLogger(BasicOuterClass.class.getName());    

    public BasicOuterClass() {
        logger.info("Building BasicOuterClass");
    }

    public static Integer i;

    public static class NestedStaticClass {
        public NestedStaticClass() {
            logger.info("Building NestedStaticClass");
        }
    }
}


//Локальный класс
class LocalOuterClass {
    private final static Logger logger = LoggerWrapper.getLogger(LocalOuterClass.class.getName());    

    public LocalOuterClass() {
        logger.info("Building LocalOuterClass");
    }

    public static void go() {

        abstract class LocalClass {
            public abstract void go();
        }

        final class LocalDerivedClass extends LocalClass {
            public void go() {
                logger.info("Messaging from the Local class");
            }
        }

        LocalClass ls = new LocalDerivedClass();
        ls.go();
    }
}

//Анонимный класс
class AnonimousClassTest {
    private final static Logger logger = LoggerWrapper.getLogger(AnonimousClassTest.class.getName());    

    public AnonimousClassTest() {
        logger.info("Building AnonimousClassTest");
    }

    public static void go() {

        InterfaceAnonimous iai = new InterfaceAnonimous() {
            
            public void go() {
                logger.info("Messaging from the Anonimous class");
            }
        };
        iai.go();

        InterfaceAnonimous iaiPlus  = new InterfaceAnonimousImplementation();
        iaiPlus.go();

        String retrievedInfo = new Test() {
            @Override
            public void test() {
               
            }

            @Override
            public String info() {
                
                return "needed info";
            }
        }.info();        

        logger.info(retrievedInfo);
    }
}



interface Test {
    public void test();
    public String info();
}

class InterfaceAnonimousImplementation implements InterfaceAnonimous{
    private final static Logger logger = LoggerWrapper.getLogger(InterfaceAnonimousImplementation.class.getName());    

    public void go() {
        logger.info("Messaging from the Anonimous class");    
    }
}


interface InterfaceAnonimous {
    public void go();
}

//Лямбда класс
class LambdaTest {
    private final static Logger logger = LoggerWrapper.getLogger(LambdaTest.class.getName());    
    
    public void useLambda(InterfaceAnonimous intA) {
        intA.go();
    }

    public void lambdaDemo() {

        this.useLambda(new InterfaceAnonimous() {
            public void go() {
                logger.info("Messaging from Anonimous Implementation of InterfaceAnonimous");
            }
        });

        this.useLambda(new InterfaceAnonimousImplementation());        

        this.useLambda(() -> logger.info("Messaging from Lambda Implementation of InterfaceAnonimous"));
    }
}
