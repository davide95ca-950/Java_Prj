public class Tornello extends Thread {

    private Incrocio incrocio;

    public Tornello(Incrocio incrocio) {
        this.incrocio = incrocio;
    }

    public void run() {
    
       while(true){ 
       
        System.out.println("Il Binario è libero");
        incrocio.transito();
        try {
            Thread.sleep((int) (Math.random() * 501));
        } catch (InterruptedException e) {
            e.printStackTrace();
            }
         }   
    }
}

           
           
           
