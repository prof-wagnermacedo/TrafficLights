package semaforo.domain;

public class Semaforo {
    // Constantes
    public static final char VERMELHO = 'R';
    public static final char AMARELO = 'Y';
    public static final char VERDE = 'G';

    // Atributo que indica a cor atual: inicia por vermelho
    private char estado = VERMELHO;

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

}
