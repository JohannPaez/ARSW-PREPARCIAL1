package edu.eci.arsw.primefinder;

import java.math.BigInteger;

import edu.eci.arsw.math.MathUtilities;
import edu.eci.arsw.mousePart.ThreadMouse;

public class ThreadPrime extends Thread {
	BigInteger a;
	BigInteger b;
	PrimesResultSet prs;
	
	
	public ThreadPrime(BigInteger a, BigInteger b, PrimesResultSet prs) {
		this.a = a;
		this.b = b;
		this.prs = prs;
	}
	
	
	@Override
	public void run() {
            MathUtilities mt=new MathUtilities();           
            int itCount=0;        
            BigInteger i=a;
            while (i.compareTo(b)<=0){
            	if (!ThreadMouse.flag) {
            		System.out.println("Pausar Hilos");
            		try {
            			synchronized(this) {
            				wait();
            			}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
                itCount++;
                if (mt.isPrime(i)){
                    prs.addPrime(i);
                }
                i=i.add(BigInteger.ONE);
                
            }
	}
	
	
}
