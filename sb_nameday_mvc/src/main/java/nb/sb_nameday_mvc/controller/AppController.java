package nb.sb_nameday_mvc.controller;

import nb.sb_nameday_mvc.dto.NamedayDTO;
import nb.sb_nameday_mvc.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppController {
    private final AppService service;

    @Autowired
    public AppController(AppService service) {
        this.service = service;
    }

    @GetMapping("/namedays")
    public String getNamedays(Model model) {
        List<NamedayDTO> dto = service.getNamedays();

        model.addAttribute("namedaysDTO", dto);

        return "namedays.html";
    }
}