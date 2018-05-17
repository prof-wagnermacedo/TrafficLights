package semaforo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import semaforo.dao.SemaforoDao;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static semaforo.domain.Semaforo.AMARELO;
import static semaforo.domain.Semaforo.VERDE;
import static semaforo.domain.Semaforo.VERMELHO;

@Controller
public class SemaforoController {

    @Autowired
    SemaforoDao dao;

    @RequestMapping("/sinal")
    public String displaySinal(Model model) {
        char estadoAtual = dao.getEstadoAtual();
        model.addAttribute("aceso", estadoAtual);

        return "sinal";
    }

    @RequestMapping("/painel")
    public String painelSinal(Model model) {
        char estadoAtual = dao.getEstadoAtual();
        model.addAttribute("aceso", estadoAtual);

        return "painel";
    }

    @RequestMapping(value="/painel", method=POST)
    public String painelAlteraSinal(char estado) {
        dao.setEstadoAtual(estado);
        return "redirect:/sinal";
    }

}
