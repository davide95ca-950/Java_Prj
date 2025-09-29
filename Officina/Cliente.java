public class Cliente extends Thread {
    private Sportello sportello;
    private int idCliente;
    private int tipoRichiesta;
    
    public Cliente(int idCliente, int tipoRichiesta, Sportello sportello) {
        this.idCliente = idCliente;
        this.tipoRichiesta = tipoRichiesta;
        this.sportello = sportello;
    }
    
    public int getIdCliente() {
        return idCliente;
    }
    
    public int getTipoRichiesta() {
        return tipoRichiesta;
    }
    
    public void run() {
        sportello.mettiInCoda(this);
    }
}

