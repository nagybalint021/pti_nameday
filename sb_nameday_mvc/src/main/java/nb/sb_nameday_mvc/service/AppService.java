package nb.sb_nameday_mvc.service;

import nb.sb_nameday_mvc.dto.NamedayDTO;
import nb.sb_nameday_mvc.model.NamedayResponse;
import nb.sb_nameday_mvc.xml.XMLReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class AppService {
    private final RestClient rc;
    private final XMLReader reader;

    @Autowired
    public AppService(XMLReader reader) {
        this.rc = RestClient.create();
        this.reader = reader;
    }

    public List<NamedayDTO> getNamedays() {
        List<NamedayDTO> namedays = null;

        try {
            NamedayResponse namedayResponse = rc.get()
                    .uri("http://localhost:8081/nameday/all")
                    .retrieve()
                    .body(NamedayResponse.class);

            namedays = reader.getNamedays(namedayResponse.getNamedays());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return namedays;
    }
}