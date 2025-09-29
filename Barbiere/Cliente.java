public class Cliente extends Thread{

   private Sala sala;
   private int id;
   
   public Cliente ( Sala s, int i)
        {
           super ("Cliente");
           sala = s;
           id =i;
        }
        
        public void run()
        {
               sala.prendiPosto (id);
        }
   }
   
   
