public class Treno extends Thread {

    private Incrocio incrocio;
    private int idTreno;
    private int provenienza;
    private int binario;
    private int categoria;

    public Treno(int idTreno, int provenienza, int binario, int categoria, Incrocio incrocio) {
        this.idTreno = idTreno;
        this.provenienza = provenienza;
        this.binario = binario;
        this.categoria = categoria; 

        this.incrocio = incrocio;
    }

    public int getIdtreno() { 
        return idTreno;
    }

    public int getProvenienza() {
        return provenienza;
    }

    public int getBinario() {
        return binario;
    }

    public int getCategoria() {
        return categoria;
    }

    public void run() {
        incrocio.mettiInCoda(this);
        
        
    }
}

