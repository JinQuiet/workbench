package com.jinquiet;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Workbench
 *
 */
public class Workbench {
    public static void main(String[] args) throws InterruptedException {
        PrintStream so = System.out;

        /*
            so.format("====================Workbench==============%n");
            Singleton s = Singleton.init();
            so.println(s.hashCode());
            Singleton s1 = Singleton.init();
            so.println(s1.hashCode());        
            Singleton s2 = Singleton.init();
            so.println(s2.hashCode());      
            Singleton s3 = Singleton.init();
            so.println(s3.hashCode());                      
        */

        Singleton s = new Singleton();
        

        Singleton s1 = new Singleton();        
    
        Singleton s2 = new Singleton();        
        Singleton s3 = new Singleton();                

        /***************************** */
        Singleton sl = new Singleton();     

        List<Integer> listOverride  = new ArrayList<Integer>();

        // sl.internalFinalList = listOverride;


        String strPool = "abcd";             //string in the pool string
        String strHeap = new String("abcd"); //string in the HEAP

        so.println(strPool == strHeap);

        strHeap = strPool.intern();

        so.println(strPool == strHeap);       
        
    }
}


class Singleton {

    private static int is;
    private int id;    

    public final List<Integer> internalFinalList = new ArrayList<Integer>();

    //+++++++++++++++++++++++++++++
    static {
        System.out.println("static init");
        Singleton.is=34;

        int a = new Singleton().id;
        
    }  

    //============================
    {
        System.out.println("init");
    }

    //***************************  */
    public Singleton() {
        System.out.println("Singleton object");

        final int integer;

    }
}


class A {
    
    public Number am(){
        return 1;
    }   

}

class B extends A {

    public Integer am() {
         return 1;
    }   
}