import java.util.LinkedList;

public class Incrocio {

    LinkedList<Treno> CodaProvenienza = new LinkedList<>();
    LinkedList<Treno> CodaBinario = new LinkedList<>();
    LinkedList<Treno> CodaCategoria = new LinkedList<>();

    int MAX_COUNTER = 3;
    int counterP = 0;
    int counterB = 0;

    public synchronized void mettiInCoda(Treno treno) {

        if (treno.getProvenienza() == 0) {
            System.out.println(" Il treno " + treno.getIdtreno() + " viene da SUD");
            CodaProvenienza.add(treno);
            notifyAll();
        } else {
            if (treno.getBinario() == 0) {
                System.out.println(" Il treno " + treno.getIdtreno() + " viene da NORD percorrendo il binario 1");
                CodaBinario.add(treno);
                notifyAll();
            } else {
                if (treno.getCategoria() == 0) {
                    System.out.println(" Il treno " + treno.getIdtreno() + " viene da NORD percorrendo il binario 2 ed è di categoria A");
                    CodaCategoria.add(treno);
                    notifyAll();
                } else {
                    System.out.println(" Il treno " + treno.getIdtreno() + " viene da NORD percorrendo il binario 2 ed è di categoria B");
                    CodaCategoria.add(treno);
                    notifyAll();
                }
            }
        }
    }

    public synchronized void transito() {
        while (!CodaProvenienza.isEmpty() || !CodaBinario.isEmpty() || !CodaCategoria.isEmpty()) {
            if (!CodaProvenienza.isEmpty() && counterP < MAX_COUNTER) {
                System.out.println(" Il treno (della coda Provenienza) " + CodaProvenienza.getFirst().getIdtreno() + " sta transitando.");
                CodaProvenienza.removeFirst();
                try {
                    Thread.sleep((int) (Math.random() * 5001));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counterP++;
            } else if (!CodaBinario.isEmpty() && counterB < MAX_COUNTER) {
                System.out.println(" Il treno (della coda Binario) " + CodaBinario.getFirst().getIdtreno() + " sta transitando.");
                CodaBinario.removeFirst();
                try {
                    Thread.sleep((int) (Math.random() * 5001));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counterB++;
                counterP = 0;
            } else if (!CodaCategoria.isEmpty()) {
                System.out.println(" Il treno (della coda Categoria) " + CodaCategoria.getFirst().getIdtreno() + " sta transitando.");
                CodaCategoria.removeFirst();
                try {
                    Thread.sleep((int) (Math.random() * 5001));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counterB =0;
                counterP =0;
            } 
        }
        
        System.out.println(" Nessun treno in transito");
        counterP = 0;
        counterB = 0;
        try {
             wait();
            } catch (InterruptedException e) {
                     e.printStackTrace();
        }
    }
}

