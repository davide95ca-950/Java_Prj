import java.util.LinkedList;

public class Pista extends Thread {

    LinkedList<Aereo> codaPartenze = new LinkedList<Aereo>();
    private Aeroporto aeroporto;
    private int idPista;
    private int max_Posti = 10;

    public Pista(int idPista, Aeroporto aeroporto) {
        this.aeroporto = aeroporto;
        this.idPista = idPista;
    }

    public synchronized void codaPartenze(Aereo b) {

        if (codaPartenze.size() < max_Posti) {
            if (b.getTipoTratta() == 0) {
                System.out.println("L'aereo " + b.getId() + " internazionale in coda per decollare");
                codaPartenze.addFirst(b);

            } else if (b.getTipoTratta() == 1) {
                System.out.println("L'aereo " + b.getId() + " nazionale in coda per decollare");
                codaPartenze.addLast(b);
            }
            notifyAll();
        }
    }

    public void run() {
        while (true) {
          synchronized (this) {
            if (codaPartenze.size() > 0) {
                aeroporto.decollo(codaPartenze);
            } else if (codaPartenze.size() == 0) {
                System.out.println("Nessun aereo deve decollare. WAIT");
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

