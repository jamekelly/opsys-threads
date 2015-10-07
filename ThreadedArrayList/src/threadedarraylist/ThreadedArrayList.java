/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadedarraylist;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author James
 */
public class ThreadedArrayList {
    
    private final ArrayList<Integer> listA = new ArrayList<>();
    private final ArrayList<Integer> listB = new ArrayList<>();
    
    public synchronized void addToListA() {
        Random r = new Random();
        listA.add(r.nextInt(100));
    }
    
    public synchronized void addToListB() {
        Random r = new Random();
        listB.add(r.nextInt(100));
    }

    public ArrayList<Integer> getListA() {
        return listA;
    }

    public ArrayList<Integer> getListB() {
        return listB;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        // TODO code application logic here
        ThreadedArrayList tal = new ThreadedArrayList();
        Worker t1 = new Worker(tal);
        Worker t2 = new Worker(tal);
        Verifier v = new Verifier(tal);
        long start = System.currentTimeMillis();
        t1.start();t2.start();t1.join();t2.join();
        v.start();
        v.join();
        long end = System.currentTimeMillis();
        long totalTime = end - start;
        System.out.println("total time: " + totalTime + " ms");
    }
    
}
