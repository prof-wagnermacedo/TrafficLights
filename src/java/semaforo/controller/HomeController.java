package semaforo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import semaforo.dao.SemaforoDao;
import semaforo.domain.Semaforo;

// O único propósito desse controller é redirecionar a página principal para o sinal

@Controller
public class HomeController {

    @Autowired
    SemaforoDao dao;

    @RequestMapping("/")
    public String home(Model model) {
        List<Semaforo> all = dao.findAll();
        model.addAttribute("semaforos", all);

        return "index";
    }
}
