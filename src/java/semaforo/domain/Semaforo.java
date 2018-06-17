package semaforo.domain;

public class Semaforo {
    // Constantes
    public static final char VERMELHO = 'R';
    public static final char AMARELO = 'Y';
    public static final char VERDE = 'G';

    private Long id;
    private Character estado;
    private Semaforo cruzamento;

    public Semaforo() {
    }

    public Semaforo(long id, char estado) {
        this.id = id;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Semaforo getCruzamento() {
        return cruzamento;
    }

    public void setCruzamento(Semaforo cruzamento) {
        this.cruzamento = cruzamento;
    }

}
