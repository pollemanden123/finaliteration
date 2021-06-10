package com.xml.test;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

public class xmlWriter {
    public static void main(String[] args) throws Exception {
        Person person = XMLtoPersonExample("C:\\Users\\LauUn\\IdeaProjects\\testProject\\src\\com\\xml\\test\\person.xml");
        System.out.println(person);
        personToXMLExample("person-output.xml", person);
    }

    private static Person XMLtoPersonExample(String filename) throws Exception {
        File file = new File(filename);
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Person) jaxbUnmarshaller.unmarshal(file);
    }

    private static void personToXMLExample(String filename, Person person) throws Exception {
        File file = new File(filename);
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(person, file);
        jaxbMarshaller.marshal(person, System.out);
    }
}
