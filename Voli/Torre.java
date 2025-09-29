import java.util.LinkedList;

public class Torre extends Thread {
    LinkedList<Aereo> codaArrivi = new LinkedList<Aereo>();

    private Aeroporto aeroporto;
    public Torre (Aeroporto aeroporto) {
    
    this.aeroporto=aeroporto;
    }

    public synchronized void codaArrivi(Aereo a) {
        if (a.getTipoTratta() == 0) {
            System.out.println("L'aereo " + a.getId() + " internazionale in coda per atterrare");
            codaArrivi.addFirst(a);
        } else if (a.getTipoTratta() == 1) {
            System.out.println("L'aereo " + a.getId() + " nazionale in coda per atterrare");
            codaArrivi.addLast(a);
        }
        notifyAll();
    }

    public void run() {
        while (true) {
          synchronized (this) {
            if (!codaArrivi.isEmpty()) {
                aeroporto.atterraggio(codaArrivi);
            } else {
                System.out.println("Nessun aereo deve atterrare. WAIT");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
      }
    }
}

