package com.avinash;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

@SpringBootApplication
@RestController
public class XmlParserApplication {

	public static void main(String[] args) throws JAXBException, IOException {
		SpringApplication.run(XmlParserApplication.class, args);
		new XmlParserApplication().marshal();
	}
	
	@GetMapping("/hello")
	public String print() {
		return "Hello World!!!";
	}
	
	public void marshal() throws JAXBException, IOException {
	    Book book = new Book();
	    book.setId(1L);
	    book.setName("Book1");
	    book.setAuthor("Author1");
	    book.setDate(new Date());

	    JAXBContext context = JAXBContext.newInstance(Book.class);
	    Marshaller mar= context.createMarshaller();
	    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    mar.marshal(book, new File("./book.xml"));
	}

}
