package nb.sb_nameday_mvc.xml;

import nb.sb_nameday_mvc.dto.NamedayDTO;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class XMLReader {
    public List<NamedayDTO> getNamedays(String namedaysXML) throws IOException, JDOMException {
        List<NamedayDTO> namedays = new ArrayList<>();

        SAXBuilder sb = new SAXBuilder();
        Document document = sb.build(new StringReader(namedaysXML));

        Element rootElement = document.getRootElement();

        List<Element> namedayList = rootElement.getChildren("nameday");

        for (Element nameday : namedayList) {
            namedays.add(new NamedayDTO(nameday.getAttributeValue("date"), nameday.getValue()));
        }

        return namedays;
    }
}