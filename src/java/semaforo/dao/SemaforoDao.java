package semaforo.dao;

import org.springframework.stereotype.Service;
import semaforo.domain.Semaforo;

import static semaforo.domain.Semaforo.AMARELO;
import static semaforo.domain.Semaforo.VERDE;
import static semaforo.domain.Semaforo.VERMELHO;

@Service
public class SemaforoDao {

    // Como só existe um sinal, então não é preciso usar uma lista aqui.
    private final Semaforo semaforo = new Semaforo();

    public char getEstadoAtual() {
        return this.semaforo.getEstado();
    }

    public void setEstadoAtual(char estado) {
        // Impede um estado inválido
        switch (estado) {
            case VERMELHO:
            case AMARELO:
            case VERDE:
                break;
            default:
                throw new IllegalArgumentException("Estado inválido: " + estado);
        }

        semaforo.setEstado(estado);
    }

}
