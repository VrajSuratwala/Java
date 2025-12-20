/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.threading;

/**
 *
 * @author Vraj Suratwala
 */
public class Sleep extends Thread{
    @Override
    public void run()
    {
        try{
            
            System.out.println("Thread : " + Thread.currentThread().getName());
            System.out.println("GOING IN SLEEP");
            Thread.sleep(2000);
            System.out.println("Woke Up");
            
        }catch(InterruptedException I){
//            I.printStackTrace();
            System.out.println("An Intrrupted Block");
        }
    }
}
