public class Tagliando extends Thread {

    private Sportello sportello;
    private int idTagliando;

    public Tagliando(int idTagliando, Sportello sportello) {
        this.idTagliando = idTagliando;
        this.sportello = sportello;
    }

    public int getIdTagliando() {
        return idTagliando;
    }

    public void run() {
        while (true) {
            System.out.println("Tagliando N" + getIdTagliando() + " libero");
            sportello.esTagliando();
            
        }
    }
}

