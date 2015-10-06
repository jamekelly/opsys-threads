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
public class Worker extends Thread {
    
    private ThreadedArrayList threaded;
    
    public Worker(ThreadedArrayList threaded) {
        this.threaded = threaded;
    }
    
    @Override
    public void run() {
        for(int i = 0; i<5000;i++){
            threaded.addToListA();
            threaded.addToListB();
        }
    }
    
}
