public class Addetto extends Thread {
       
       private int idAddetto;
       private Supermercato supermercato;
       
       public Addetto (int idAddetto, Supermercato supermercato){
       
         this.idAddetto = idAddetto;
         this.supermercato = supermercato;
       }
       
       public int getIdAddetto () {
          return idAddetto;
          }
          
       public void run() {
           
           while(true) {
           supermercato.daPagare();
           }
         }
       }
     
