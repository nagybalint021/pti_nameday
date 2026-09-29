package nb.sb_nameday_rest.service;

import nb.sb_nameday_rest.dto.NamedayResponseDTO;
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
}