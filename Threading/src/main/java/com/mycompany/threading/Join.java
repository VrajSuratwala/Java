/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.threading;

/**
 *
 * @author Vraj Suratwala
 */
public class Join extends Thread{
    @Override
    public void run()
    {
        for(int i = 0 ;i < 3 ; i ++) {
        System.out.println("Thread : " + Thread.currentThread().getName());
        }
    }
}
