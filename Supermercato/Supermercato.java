import java.util.LinkedList;

public class Supermercato {

    private final int MAX_Cassa = 10;
    private final int MAX_counter = 3;

    private int counter1 = 0;
    private int counter2 = 0;
    private int counter3 = 0;

    private LinkedList<Cliente> codaEntrataP = new LinkedList<>();
    private LinkedList<Cliente> codaEntrataN = new LinkedList<>();
    private LinkedList<Cliente> codaCassaP = new LinkedList<>();
    private LinkedList<Cliente> codaCassaN = new LinkedList<>();
    private LinkedList<Cliente> codaUscitaP = new LinkedList<>();
    private LinkedList<Cliente> codaUscitaN = new LinkedList<>();

    public synchronized void mettiInCoda(Cliente cliente) {
        if (cliente.getPriorita() == 0) {
                    System.out.println("Il cliente " + cliente.getIdCliente() + " si mette in coda per Entrare con priorita");
            codaEntrataP.add(cliente);
        } else {
                    System.out.println("Il cliente " + cliente.getIdCliente() + " si mette in coda per entrare");
            codaEntrataN.add(cliente);
        }
        notifyAll();
    }

    public synchronized void daPagare() {
        while (!codaEntrataP.isEmpty() || !codaEntrataN.isEmpty()) {
            if (!codaEntrataP.isEmpty() && counter1 < MAX_counter) {
                            System.out.println("Il cliente " + codaEntrataP.getFirst().getIdCliente() + " si mette in coda per la cassa con priorita");
                counter1++;
                Cliente pagante = codaEntrataP.removeFirst();
                if (codaCassaP.size() < MAX_Cassa) {
                    codaCassaP.add(pagante);
                    notifyAll();
                } else {
try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
                }
            } else if (!codaEntrataN.isEmpty()) {
                            System.out.println("Il cliente " + codaEntrataN.getFirst().getIdCliente() + " si mette in coda per la cassa ");
                counter1 = 0;
                Cliente pagante = codaEntrataN.removeFirst();
                if (codaCassaN.size() < MAX_Cassa) {
                    codaCassaN.add(pagante);
                    notifyAll();
                } else {
                    try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
                }
            }
            try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // Wait for next notification
        }
    }

    public synchronized void staPagando()  {
        while (!codaCassaP.isEmpty() || !codaCassaN.isEmpty()) {
            if (!codaCassaP.isEmpty() && counter2 < MAX_counter) {
                            System.out.println("Il cliente " + codaCassaP.getFirst().getIdCliente() + " ha pagato e sta uscendo con priorita");
                counter2++;
                Cliente uscente = codaCassaP.removeFirst();
                codaUscitaP.add(uscente);
                notifyAll();
            } else if (!codaCassaN.isEmpty()) {
                            System.out.println("Il cliente " + codaCassaN.getFirst().getIdCliente() + " ha pagato e sta uscendo");
                counter2 = 0;
                Cliente uscente = codaCassaN.removeFirst();
                codaUscitaN.add(uscente);
                notifyAll();
            }
            }
            try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

    public synchronized void esci(){
        while (!codaUscitaP.isEmpty() || !codaUscitaN.isEmpty()) {
            if (!codaUscitaP.isEmpty() && counter3 < MAX_counter) {
                        System.out.println("Il cliente " + codaUscitaP.getFirst().getIdCliente() + " abbandona il supermercato con priorita");
                counter3++;
                codaUscitaP.removeFirst();
                notifyAll();
            } else if (!codaUscitaN.isEmpty()) {
                        System.out.println("Il cliente " + codaUscitaN.getFirst().getIdCliente() + " abbandona il supermercato");
                counter3 = 0;
                codaUscitaN.removeFirst();
                notifyAll();
            }
            try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // Wait for next notification
        }
    }
}

