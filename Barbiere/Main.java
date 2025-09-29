public class Main {
   public static void main ( String [] args) {
   
         Sala sala = new Sala();
         
         int nBarbieri = 3;
         Barbiere barbieri[] = new Barbiere[nBarbieri];
         
         for (int i=0; i<nBarbieri; i++) {
         
          barbieri[i] = new Barbiere (sala, i);
          barbieri[i].start();
         }
         
         int nClienti =100;
         Cliente clienti[] = new Cliente[nClienti];
         
         for (int i=0; i<nClienti; i++){
         
         clienti[i] = new Cliente (sala,i);
         clienti[i].start();
         
              try {
                   Thread.sleep( (int) (Math.random() * 501) );
                   } catch(InterruptedException exception) {
                        exception.printStackTrace();
                        
                       }
                      }
                     }
                    }
         
   
   
