public class Revisione extends Thread  {

             private Sportello sportello;
             
             public Revisione(Sportello sportello) {
                   
                   this.sportello = sportello;
                   
                   }
                   
             public void run() {
             
                while(true) {
                      System.out.println("Revisione libera");
                      sportello.esRevisione();
                    try {
                        Thread.sleep((int) (Math.random() * 501));
                        } catch (InterruptedException e) {
                          e.printStackTrace();
                     }
                   }
                 }
               } 
                               
                      
                      
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       








