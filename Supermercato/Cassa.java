public class Cassa extends Thread {

        private int idCassa;
        private Supermercato supermercato;
        
        public Cassa (int idCassa, Supermercato supermercato){
        
            this.idCassa = idCassa;
            this.supermercato = supermercato;
            }
            
        public int getIdCassa () {
           return idCassa;
           }
           
        public void run() {
        
           while(true) {
            supermercato.staPagando();
            }
           }
          }
