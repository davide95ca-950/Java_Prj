import java.util.LinkedList;

public class Aeroporto {
        
    LinkedList<Aereo> arrivi = new LinkedList<Aereo>();
    LinkedList<Aereo> partenze = new LinkedList<Aereo>();
    
    int counter = 0;
    int max_counter = 5;
    
    public synchronized void atterraggio(LinkedList<Aereo> a) {
        System.out.println("L'aereo " + a.getFirst().getId() + " richiede atterraggio");
        if (a.getFirst().getTipoTratta() == 0) {
            arrivi.addFirst(a.removeFirst());
        } else if (a.getFirst().getTipoTratta() == 1) {
            arrivi.addLast(a.removeFirst());
        }
        notifyAll();
    }
    
    public synchronized void decollo(LinkedList<Aereo> b) {
        System.out.println("L'aereo " + b.getFirst().getId() + " richiede decollo");
        if (b.getFirst().getTipoTratta() == 0) {
            partenze.addFirst(b.removeFirst());
        } else if (b.getFirst().getTipoTratta() == 1) {
            partenze.addLast(b.removeFirst());
        }
        notifyAll();
    }  
    
    public synchronized void esciAeroporto() {
         if (!arrivi.isEmpty()) {
          System.out.println("L'aereo " + arrivi.getFirst().getId() + " atterra");
          arrivi.removeFirst();
         }  else if (arrivi.isEmpty()) {
                 if (!partenze.isEmpty()) {
                  System.out.println("L'aereo " + partenze.getFirst().getId() + " decolla");
            partenze.removeFirst();
        } else if (partenze.isEmpty()) {
                System.out.println("L'aeroporto non ha aerei da servire. WAIT"); 
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace(); 
                }
            }
        }
    } 
}

