package edu.eci.arsw.primefinder;

import edu.eci.arsw.mousePart.ThreadMouse;
import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {

	public static void main(String[] args) throws InterruptedException {
		            
            int maxPrim=1000;
            
            PrimesResultSet prs=new PrimesResultSet("john");
            ThreadPrime a =  new ThreadPrime(new BigInteger("1"), new BigInteger("2500"), prs);
            ThreadPrime b =  new ThreadPrime(new BigInteger("2501"), new BigInteger("5000"), prs);
            ThreadPrime c =  new ThreadPrime(new BigInteger("5001"), new BigInteger("7500"), prs);
            ThreadPrime d =  new ThreadPrime(new BigInteger("7501"), new BigInteger("10000"), prs);            
            a.start();
            b.start();
            c.start();
            d.start();
            ArrayList<ThreadPrime> lista = new ArrayList<ThreadPrime>();
            lista.add(a);
            lista.add(b);
            lista.add(c);
            lista.add(d);
            ThreadMouse mouse = new ThreadMouse(lista);
            mouse.start();
            a.join();
            b.join();
            c.join();
            d.join();
            
            System.out.println("Prime numbers found:");
            
            System.out.println(prs.getPrimes());
            
            
            /*while(task_not_finished){
                try {
                    //check every 10ms if the idle status (10 seconds without mouse
                    //activity) was reached. 
                    Thread.sleep(10);
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                        System.out.println("Idle CPU ");
                    }
                    else{
                        System.out.println("User working again!");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
                        
            
            
            
            
	}
	
}


