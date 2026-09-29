package nb.sb_nameday_mvc.controller;

import nb.sb_nameday_mvc.dto.ChangeNamedayDTO;
import nb.sb_nameday_mvc.dto.ChangeNamedayResponseDTO;
import nb.sb_nameday_mvc.dto.NamedayDTO;
import nb.sb_nameday_mvc.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/change")
    public String getChange() {
        return "change.html";
    }

    @PostMapping("/nameday/changedate")
    public String changeDate(Model model, ChangeNamedayDTO changeNamedayDTO) {
        ChangeNamedayResponseDTO dto = service.changeDate(changeNamedayDTO);

        model.addAttribute("changeDTO", dto);

        return "change.html";
    }

    @PostMapping("/nameday/changename")
    public String changeName(Model model, ChangeNamedayDTO changeNamedayDTO) {
        ChangeNamedayResponseDTO dto = service.changeName(changeNamedayDTO);

        model.addAttribute("changeDTO", dto);

        return "change.html";
    }
}