public class Main {
    public static void main(String[] args) {

        Supermercato supermercato = new Supermercato();

        Uscita uscita = new Uscita(supermercato);

        int nAddetti = 3;
        int nCasse = 3;
        int nClienti = 100;

        Addetto addetti[] = new Addetto[nAddetti];

        for (int i = 0; i < nAddetti; i++) {
            addetti[i] = new Addetto(i, supermercato);
            addetti[i].start();
        }

        Cassa casse[] = new Cassa[nCasse];

        for (int i = 0; i < nCasse; i++) {
            casse[i] = new Cassa(i, supermercato);
            casse[i].start();
        }

        Cliente clienti[] = new Cliente[nClienti];

        for (int i = 0; i < nClienti; i++) {
            int priorita = ((int) (Math.random() * 10) % 2);

            clienti[i] = new Cliente(i, priorita, supermercato);
            clienti[i].start();

            try {
                Thread.sleep((int) (Math.random() * 501));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

