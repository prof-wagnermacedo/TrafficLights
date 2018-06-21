package semaforo.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import semaforo.domain.Semaforo;

import static semaforo.domain.Semaforo.AMARELO;
import static semaforo.domain.Semaforo.VERDE;
import static semaforo.domain.Semaforo.VERMELHO;

@Service
public class SemaforoDao {

    private static final RowMapper<Semaforo> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Semaforo.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public void addCruzamento() {
        // Insere os semaforos e obtém o id gerado pelo SGBD
        String sqlInsert = "INSERT INTO Semaforo (estado) OUTPUT inserted.id VALUES (?)";
        Integer id1 = jdbcTemplate.queryForObject(sqlInsert, Integer.class, String.valueOf(VERMELHO));
        Integer id2 = jdbcTemplate.queryForObject(sqlInsert, Integer.class, String.valueOf(VERDE));

        // Faz a relação entre os dois sinais
        String sqlUpdate = "UPDATE Semaforo SET semaforo_id=? WHERE id=?";
        jdbcTemplate.update(sqlUpdate, id1, id2);
        jdbcTemplate.update(sqlUpdate, id2, id1);
    }

    public char getEstadoAtual(long id) {
        String sql = "SELECT estado FROM Semaforo WHERE id=?";
        String estado = jdbcTemplate.queryForObject(sql, String.class, id);

        return estado.charAt(0);
    }

    @Transactional
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

        // Obtém o id do outro sinal
        String sqlSelect = "SELECT semaforo_id FROM Semaforo WHERE id=?";
        int outroId = jdbcTemplate.queryForObject(sqlSelect, Integer.class, id);

        // Garante a consistência do cruzamento: qual deve ser o estado do outro sinal?
        char outroEstado = (estado == VERMELHO) ? VERDE : VERMELHO;

        // Faz a atualização dos estados dos dois sinais
        String sqlUpdate = "UPDATE Semaforo SET estado=? WHERE id=?";
        jdbcTemplate.update(sqlUpdate, String.valueOf(estado), id);
        jdbcTemplate.update(sqlUpdate, String.valueOf(outroEstado), outroId);
    }

    public List<Semaforo> findAll() {
        String sql = "SELECT id, estado FROM Semaforo";
        List<Semaforo> semaforos = jdbcTemplate.query(sql, ROW_MAPPER);

        return semaforos;
    }

}
