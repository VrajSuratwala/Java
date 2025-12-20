/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.threading;

/**
 *
 * @author Vraj Suratwala
 */
public class Threading {

    public static void main(String[] args) {
//        System.out.println("Hello World!");

        //Thread - 1
//        Thread_1 T1 = new Thread_1();
//        T1.setName("ABC");
//        
//        T1.start();
        //Thread - 2 
//        Thread_2 T2 = new Thread_2();
//        Thread T = new Thread(T2,"ABCD");
//        
//        T.start();

        //Priority
//        Priority P1 = new Priority();
//        Priority P2 = new Priority();
//        Priority P3 = new Priority();
//        
//        P1.setName("ABC");
//        P2.setName("BCD");
//        P3.setName("XYZ");
//        
//        P1.setPriority(1);
//        P2.setPriority(5);
//        P3.setPriority(10);
//        
//        P1.start();
//        P2.start();
//        P3.start();

//        // Sleep Example
//        Sleep S1 = new Sleep();
//        S1.setName("Sleep Thread");
//        S1.start();
//        
//        //Let's Try with an Intrrupt
//        S1.interrupt();

        // Join
//        Join J1 = new Join();
//        Join J2 = new Join();
//        Join J3 = new Join();
//        
//        J1.setName("ABC");
//        J2.setName("PQR");
//        J3.setName("XYZ");
//        
//        J1.start();
//        
//        try{
//            J1.join();
//        }catch(InterruptedException E)
//        {
//            E.printStackTrace();
//        }
//        
//        J2.start();
//        
//        try{
//            J2.join();
//        }catch(InterruptedException E)
//        {
//            E.printStackTrace();
//        }
//        
//        J3.start();
//        
//        try{
//            J3.join();
//        }catch(InterruptedException E)
//        {
//            E.printStackTrace();
//        }
        
        // Yield
        Yield Y1 = new Yield();
        Yield Y2 = new Yield();
        
        Y1.setName("ABC");
        Y2.setName("XYZ");
        
        Y2.setPriority(1);
        Y1.start();
        Y2.start();
    }
}
