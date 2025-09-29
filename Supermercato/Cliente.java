public class Cliente extends Thread {

    private int idCliente;
    private int priorita;
    private Supermercato supermercato;

    public Cliente(int idCliente, int priorita, Supermercato supermercato) {
        this.idCliente = idCliente;
        this.priorita = priorita;
        this.supermercato = supermercato;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getPriorita() {
        return priorita;
    }

    public void run() {
        supermercato.mettiInCoda(this);
    }
}

