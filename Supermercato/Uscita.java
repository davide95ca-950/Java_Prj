public class Uscita extends Thread {

     private Supermercato supermercato;
     
     public Uscita (Supermercato supermercato) {
         this.supermercato = supermercato;
         }
         
     public void run() {
     
         while(true) {
              supermercato.esci();
              }
           }
        }
