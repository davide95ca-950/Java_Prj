public class Main {
    public static void main(String args[]) {

        Aeroporto aeroporto = new Aeroporto();
        Torre torre = new Torre(aeroporto);

        int nPiste = 2;
        Pista pista[] = new Pista[nPiste];

        for (int i = 0; i < nPiste; i++) {
            pista[i] = new Pista(i, aeroporto);
            pista[i].start();
        }

        int nAerei = 100;
        int tipoRichiesta;
        int tipoTratta;
        int pistaUtilizzata;

        Aereo aereo[] = new Aereo[nAerei]; 

        for (int i = 0; i < nAerei; i++) {
            tipoRichiesta = ((int) (Math.random() * 10)) % 2;
            tipoTratta = ((int) (Math.random() * 10)) % 2;
            pistaUtilizzata = ((int) (Math.random() * 10)) % 2;

            aereo[i] = new Aereo(i, tipoRichiesta, tipoTratta, aeroporto, pista[pistaUtilizzata], torre);
            aereo[i].start();

            try {
                Thread.sleep((int) (Math.random() * 501));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

