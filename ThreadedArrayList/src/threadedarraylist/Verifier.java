/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadedarraylist;

/**
 *
 * @author James
 */
public class Verifier extends Thread{
    
    private ThreadedArrayList tal;
    
    public Verifier(ThreadedArrayList tal) {
        this.tal = tal;
    }
    
    // Make sure there are 10000 elements in the list
    public void verify() {
        if(this.tal.getListA().size() == 10000 && this.tal.getListB().size() == 10000) {
            System.out.println("Success!");
        } else {
            System.out.println("Failed");
        }
        System.out.println("A: " + tal.getListA().size());
        System.out.println("B: " + tal.getListB().size());
    }
    
    @Override
    public void run() {
        this.verify();
    }
    
}
