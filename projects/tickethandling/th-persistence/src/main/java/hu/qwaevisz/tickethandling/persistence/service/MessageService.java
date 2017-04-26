package hu.qwaevisz.tickethandling.persistence.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.ejb.Local;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import hu.qwaevisz.tickethandling.persistence.entity.Message;

@Local
public interface MessageService {

	void createConversation(String ticketId) throws ParserConfigurationException, TransformerException, IOException;

	List<Message> readConversation(String ticketId) throws ParserConfigurationException, SAXException, IOException, DOMException, ParseException;
}
