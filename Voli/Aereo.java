public class Aereo extends Thread {
    
    private Aeroporto aeroporto;
    private Pista pista;
    private Torre torre;
    private int id;
    private int tipoRichiesta;
    private int tipoTratta;
    
    public Aereo(int id, int tipoRichiesta, int tipoTratta, Aeroporto aeroporto, Pista pista, Torre torre) {
    
        this.aeroporto = aeroporto;
        this.pista = pista;
        this.torre = torre;
        this.id = id;
        this.tipoRichiesta = tipoRichiesta;
        this.tipoTratta = tipoTratta;
    }
     
    public void run() {
     
        if (tipoRichiesta == 0) {
            torre.codaArrivi(this);
        } else if (tipoRichiesta == 1) {
            pista.codaPartenze(this);
        }
        
        aeroporto.esciAeroporto();
    }
      
    public int getIdAereo() {
        return id;
    }      
    
    public int getTipoRichiesta() {
        return tipoRichiesta;
    } 
    
    public int getTipoTratta() {
        return tipoTratta;
    } 
}

