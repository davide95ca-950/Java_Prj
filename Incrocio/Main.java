public class Main {
    public static void main(String args[]) {

        Incrocio incrocio = new Incrocio();
        Tornello tornello = new Tornello(incrocio); 
        tornello.start();

        int nTreni = 100;
        int provenienza;
        int binario;
        int categoria;

        Treno treni[] = new Treno[nTreni];

        for (int i = 0; i < nTreni; i++) {

            provenienza = ((int) (Math.random() * 10) % 2);
            binario = ((int) (Math.random() * 10) % 2);
            categoria = ((int) (Math.random() * 10) % 2);

            treni[i] = new Treno(i, provenienza, binario, categoria, incrocio);
            treni[i].start();

            try {
                Thread.sleep((int) (Math.random() * 51));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

