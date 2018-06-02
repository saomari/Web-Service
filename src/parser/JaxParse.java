package parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class JaxParse {
    public static <T> void marshal(T object, String path, File file) throws JAXBException {
        path = path.substring(path.lastIndexOf('/')+1, path.length());
        path = path.substring(0, path.lastIndexOf('.')) + ".xsd";
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, path);
        marshaller.marshal(object, file);
    }

    public static <T> T unmarshal(Class<T> object, File file) throws JAXBException {
        return unmarshal(object, new StreamSource(file));
    }

    private static <T> T unmarshal(Class<T> object, Source source) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller.unmarshal(source, object).getValue();
    }
}
