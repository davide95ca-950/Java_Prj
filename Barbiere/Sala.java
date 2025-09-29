import java.util.LinkedList;

public class Sala {
  
   private int servito;
    private int NUM_POSTI =5;
    private LinkedList<Integer> divano = new LinkedList<Integer>();
    
    public synchronized void prendiPosto (int id)
     { 
         System.out.println( "== arriva il cliente" + id);
         
       if (divano.size()  < NUM_POSTI) {
        divano.add(id);
        notifyAll();
        } else {
                System.out.println( "DIVANO PIENO" + divano + " - il cliente" + id + "va via");
                
                }
     }
    
    
    public synchronized void serviCliente(int id)
      {
        while (divano.size() ==0) {
        try {
          System.out.println( "Barbiere" + id + "non ha clienti da servire");
          wait(); 
         }  catch (InterruptedException e){
          e.printStackTrace();
          } 
          }                  
        {
        
          System.out.println("Barbiere " + id + " ottiene il cliente " +divano.getFirst());
        
        servito =divano.removeFirst();
        try {
          Thread.sleep( (int) (Math.random() * 101) ) ;
          }  catch (InterruptedException exception){
          exception.printStackTrace();
          } 
          
          System.out.println("Barbiere " + id + " ha servito il cliente" + servito);
          }                 
          }       
              }   
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
