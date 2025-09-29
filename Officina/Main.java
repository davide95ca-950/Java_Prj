
public class Main {
    public static void main(String args[]) {

        Sportello sportello = new Sportello();

        Uscita uscita = new Uscita(sportello);
        uscita.start();

        Revisione revisione = new Revisione(sportello);
        revisione.start();

        int nTagliandi = 4;

        Tagliando tagliandi[] = new Tagliando[nTagliandi];

        for (int i = 0; i < nTagliandi; i++) {
            tagliandi[i] = new Tagliando(i, sportello);
            tagliandi[i].start();
        }

        int nClienti = 100;
        Cliente clienti[] = new Cliente[nClienti];

        for (int i = 0; i < nClienti; i++) {
            int tipoRichiesta = ((int) (Math.random() *10)%2);
            clienti[i] = new Cliente(i, tipoRichiesta, sportello);
            clienti[i].start();

            try {
                Thread.sleep((int) (Math.random() *501));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

