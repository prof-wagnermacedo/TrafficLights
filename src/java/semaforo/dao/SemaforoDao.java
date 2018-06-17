package semaforo.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import semaforo.domain.Semaforo;

import static semaforo.domain.Semaforo.AMARELO;
import static semaforo.domain.Semaforo.VERDE;
import static semaforo.domain.Semaforo.VERMELHO;

@Service
public class SemaforoDao {

    private final List<Semaforo> semaforos = new ArrayList<>();
    private long count = 0;

    public SemaforoDao() {
        this.addCruzamento();
        this.addCruzamento();
    }

    public final void addCruzamento() {
        Semaforo smfA = new Semaforo(++count, VERMELHO);
        Semaforo smfB = new Semaforo(++count, VERDE);

        smfA.setCruzamento(smfB);
        smfB.setCruzamento(smfA);

        semaforos.add(smfA);
        semaforos.add(smfB);
    }

    public char getEstadoAtual(long id) {
        Semaforo smf = this.find(id);
        return smf.getEstado();
    }

    public void setEstadoAtual(long id, char estado) {
        // Impede um estado inválido
        switch (estado) {
            case VERMELHO:
            case AMARELO:
            case VERDE:
                break;
            default:
                throw new IllegalArgumentException("Estado inválido: " + estado);
        }

        // Define o estado do sinal informado
        Semaforo smf = this.find(id);
        smf.setEstado(estado);

        // Garante a consistência do cruzamento
        Semaforo cruz = smf.getCruzamento();
        if (estado == VERMELHO) {
            cruz.setEstado(VERDE);
        } else {
            cruz.setEstado(VERMELHO);
        }
    }

    public Semaforo find(long id) {
        for (Semaforo smf : this.semaforos) {
            if (id == smf.getId()) {
                return smf;
            }
        }

        return null;
    }

    public List<Semaforo> findAll() {
        return this.semaforos;
    }

}
