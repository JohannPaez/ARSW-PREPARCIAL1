package edu.eci.arsw.mousePart;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import edu.eci.arsw.mouseutils.MouseMovementMonitorExample;
import edu.eci.arsw.primefinder.ThreadPrime;

public class ThreadMouse extends Thread {
	
	public static boolean flag = false;
	List<ThreadPrime> lista;
	
	public ThreadMouse(List<ThreadPrime> lista) {
		this.lista = lista;
	}
	
	public void run() {
		long time = 0; 
		while (true) {
			if (time > 10000) {
				for (ThreadPrime tp: lista) {
					synchronized(tp) {
						tp.notifyAll();
						flag = true;
					}
				}
				System.out.println("Renaudar Hilos");
			} else {
				flag = false;
			}
            //System.out.println("Tiempo transcurrido desde el último movimiento de mouse:");
            //System.out.println(MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MouseMovementMonitorExample.class.getName()).log(Level.SEVERE, null, ex);
            }
            time = MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement();          
        }
		
		
		
	}
}
