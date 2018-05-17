package semaforo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// O único propósito desse controller é redirecionar a página principal para o sinal

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "redirect:/sinal";
    }
}
