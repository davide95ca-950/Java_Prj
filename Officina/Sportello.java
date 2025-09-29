import java.util.LinkedList;

public class Sportello {
     
    private Cliente servito;
     
    LinkedList<Cliente> CodaRevisione = new LinkedList<>();
    LinkedList<Cliente> CodaTagliando = new LinkedList<>();
    LinkedList<Cliente> CodaUscita = new LinkedList<>();
    
    private int MAX_Tagliando =30;

    public synchronized void mettiInCoda(Cliente cliente) {
        if (cliente.getTipoRichiesta() == 0) {
            System.out.println("Il cliente " + cliente.getIdCliente() + " si mette in coda per la Revisione");
            CodaRevisione.add(cliente);
            try {
                Thread.sleep((int) (Math.random() * 501));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyAll();
        } else  if (CodaTagliando.size() < MAX_Tagliando){
            System.out.println("Il cliente " + cliente.getIdCliente() + " si mette in coda per il tagliando");
            CodaTagliando.add(cliente);
            try {
                Thread.sleep((int) (Math.random() * 501));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyAll();
        } else {
        System.out.println("Il cliente " + cliente.getIdCliente() + " non si mette in coda per il tagliando poiché già piena");
            
       }
    }

    public synchronized void esRevisione() {
        while (!CodaRevisione.isEmpty()) {
            System.out.println("Il cliente " + CodaRevisione.getFirst().getIdCliente() + " esegue la revisione");
            servito = CodaRevisione.removeFirst();
            try {
                Thread.sleep((int) (Math.random() * 1001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CodaUscita.addFirst(servito);
        System.out.println("Il cliente " + CodaUscita.getFirst().getIdCliente() + " che ha eseguito la revisione si mette in coda per uscire con priorità");
        }
            try {
             wait();
            } catch (InterruptedException e) {
                     e.printStackTrace();
        }
       
    }

    public synchronized void esTagliando() {
        while (!CodaTagliando.isEmpty()) {
            System.out.println("Il cliente " + CodaTagliando.getFirst().getIdCliente() + " esegue il tagliando");
            servito = CodaTagliando.removeFirst();
            try {
                Thread.sleep((int) (Math.random() * 1001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        CodaUscita.addLast(servito);
        System.out.println("Il cliente " + CodaUscita.getLast().getIdCliente() + " che ha eseguito il tagliando si mette in coda per uscire come ultimo");
        }
        try {
             wait();
            } catch (InterruptedException e) {
                     e.printStackTrace();
        }
    }

    public synchronized void esci() {
        while (!CodaUscita.isEmpty()) {
            System.out.println("Il cliente " + CodaUscita.getFirst().getIdCliente() + " abbandona l'officina");
            CodaUscita.removeFirst();
            try {
                Thread.sleep((int) (Math.random() * 501));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
          try {
             wait();
            } catch (InterruptedException e) {
                     e.printStackTrace();
        }
    }
}

