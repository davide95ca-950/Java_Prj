public class Uscita extends Thread {

    private Sportello sportello;

    public Uscita(Sportello sportello) {
        this.sportello = sportello;
    }

    public void run() {
        while (true) {
            System.out.println("Uscita libera");
            sportello.esci();
            
               
            }
        }
    }

