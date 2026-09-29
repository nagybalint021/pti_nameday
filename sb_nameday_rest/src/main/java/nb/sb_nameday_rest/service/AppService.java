package nb.sb_nameday_rest.service;

import nb.sb_nameday_rest.dto.ChangeNamedayResponseDTO;
import nb.sb_nameday_rest.dto.NamedayResponseDTO;
import nb.sb_nameday_rest.model.ChangeNameday;
import nb.sb_nameday_rest.model.Nameday;
import nb.sb_nameday_rest.repository.NamedayRepository;
import nb.sb_nameday_rest.xml.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    private final NamedayRepository namedayRepo;
    private final XMLWriter xmlWriter;

    @Autowired
    public AppService(NamedayRepository namedayRepo, XMLWriter xmlWriter) {
        this.namedayRepo = namedayRepo;
        this.xmlWriter = xmlWriter;
    }

    public NamedayResponseDTO getAll() {
        return new NamedayResponseDTO("OK", xmlWriter.getNamedaysXMLString(namedayRepo.findAll()));
    }

    public ChangeNamedayResponseDTO changeDate(ChangeNameday changeNameday) {
        ChangeNamedayResponseDTO dto = new ChangeNamedayResponseDTO("NOK", "Couldn't find nameday with this name.");

        Nameday nameday = namedayRepo.findByName(changeNameday.getName());

        if (nameday != null) {
            nameday.setDate(changeNameday.getDate());
            namedayRepo.save(nameday);
            dto = new ChangeNamedayResponseDTO("OK", "Successfully changed date.");
        }

        return dto;
    }

    public ChangeNamedayResponseDTO changeName(ChangeNameday changeNameday) {
        ChangeNamedayResponseDTO dto = new ChangeNamedayResponseDTO("NOK", "Couldn't find nameday with this date.");

        Nameday nameday = namedayRepo.findByDate(changeNameday.getDate());

        if (nameday != null) {
            nameday.setName(changeNameday.getName());
            namedayRepo.save(nameday);
            dto = new ChangeNamedayResponseDTO("OK", "Successfully changed name.");
        }

        return dto;
    }
}