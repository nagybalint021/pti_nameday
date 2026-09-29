package nb.sb_nameday_rest.xml;

import nb.sb_nameday_rest.model.Nameday;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;
import org.springframework.stereotype.Component;

@Component
public class XMLWriter {
    public String getNamedaysXMLString(Iterable<Nameday> namedays) {
        XMLOutputter outputter = new XMLOutputter();

        Document document = new Document();
        Element rootElement = new Element("namedays");

        for (Nameday nameday : namedays) {
            Element namedayElement = new Element("nameday");
            namedayElement.setText(nameday.getName());
            namedayElement.setAttribute("date", nameday.getDate());
            rootElement.addContent(namedayElement);
        }

        document.setRootElement(rootElement);

        return outputter.outputString(document);
    }
}