package semaforo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import semaforo.dao.SemaforoDao;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class SemaforoController {

    @Autowired
    SemaforoDao dao;

    @RequestMapping("/sinal/{id}")
    public String displaySinal(@PathVariable("id") long id, Model model) {
        char estadoAtual = dao.getEstadoAtual(id);
        model.addAttribute("aceso", estadoAtual);

        return "sinal";
    }

    @RequestMapping("/painel/{id}")
    public String painelSinal(@PathVariable("id") long id, Model model) {
        char estadoAtual = dao.getEstadoAtual(id);
        model.addAttribute("aceso", estadoAtual);

        return "painel";
    }

    @RequestMapping(value = "/painel/{id}", method = POST)
    public String painelSinalAction(@PathVariable("id") long id, char estado) {
        dao.setEstadoAtual(id, estado);
        return "redirect:/sinal/{id}";
    }

    @RequestMapping("/painel/add")
    public String painelAdd() {
        return "painel-add";
    }

    @RequestMapping(value = "/painel/add", method = POST)
    public String painelAddAction() {
        dao.addCruzamento();
        return "redirect:/";
    }

}
