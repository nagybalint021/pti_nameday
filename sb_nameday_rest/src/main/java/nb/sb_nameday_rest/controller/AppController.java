package nb.sb_nameday_rest.controller;

import nb.sb_nameday_rest.dto.ChangeNamedayResponseDTO;
import nb.sb_nameday_rest.dto.NamedayResponseDTO;
import nb.sb_nameday_rest.model.ChangeNameday;
import nb.sb_nameday_rest.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    private final AppService service;

    @Autowired
    public AppController(AppService service) {
        this.service = service;
    }

    @GetMapping("/nameday/all")
    public ResponseEntity<NamedayResponseDTO> getAll() {
        NamedayResponseDTO dto = service.getAll();

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/nameday/changedate")
    public ResponseEntity<ChangeNamedayResponseDTO> changeDate(@RequestBody ChangeNameday changeNameday) {
        ChangeNamedayResponseDTO dto = service.changeDate(changeNameday);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/nameday/changename")
    public ResponseEntity<ChangeNamedayResponseDTO> changeName(@RequestBody ChangeNameday changeNameday) {
        ChangeNamedayResponseDTO dto = service.changeName(changeNameday);

        return ResponseEntity.ok(dto);
    }
}