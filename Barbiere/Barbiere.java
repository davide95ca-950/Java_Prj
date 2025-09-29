public class Barbiere extends Thread {

   private Sala sala;
   private int id;
   
   public Barbiere (Sala s, int i)
   {
       super ("Barbiere");
       sala =s;
       id = i;
       }
       
       
       public void run() {
       
       while (true) {
          System.out.println ("Barbiere " + id + " è pronto per servire i clienti");
          
             sala.serviCliente(id);
          try{
            Thread.sleep ( (int) (Math.random() * 5001));
            } catch (InterruptedException exception) {
                exception.printStackTrace();
                }
              }
            }
          }             
             
                
   
   
   
   
   
   
   
