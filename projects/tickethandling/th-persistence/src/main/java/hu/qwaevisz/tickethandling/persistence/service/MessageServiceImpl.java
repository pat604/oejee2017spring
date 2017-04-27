package hu.qwaevisz.tickethandling.persistence.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.PersistenceException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import hu.qwaevisz.tickethandling.persistence.entity.Message;

@Stateless(mappedName = "ejb/messageService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MessageServiceImpl implements MessageService {

	private static final Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class);

	private static final String XMLFILESPATH = "D:\\Java EE\\TicketingMessages";
	private static final String MESSAGEDATEFORMAT = "yyyy-mm-dd hh:mm:ss";
	private static final String INITIALMESSAGE = "<conversation id=\"%1s\"><message id=\"%2s-0001\"><from>System</from><to>Customer</to><date>%3s</date><text>Initial message</text></message></conversation>";

	@Override
	public List<Message> readConversation(String ticketId) throws ParserConfigurationException, SAXException, IOException, DOMException, ParseException {

		String filepath = XMLFILESPATH + "\\" + ticketId + ".xml";
		LOGGER.info("Read conversation: " + filepath);
		File xmlFile = new File(filepath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("message");

		ArrayList<Message> conversation = new ArrayList<Message>();

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;

				String id = eElement.getAttribute("id");
				String from = eElement.getElementsByTagName("from").item(0).getTextContent();
				String to = eElement.getElementsByTagName("to").item(0).getTextContent();
				DateFormat format = new SimpleDateFormat(MESSAGEDATEFORMAT);
				Date date = format.parse(eElement.getElementsByTagName("date").item(0).getTextContent());
				String text = eElement.getElementsByTagName("text").item(0).getTextContent();

				conversation.add(new Message(id, from, to, date, text));
			}
		}

		return conversation;
	}

	@Override
	public void createConversation(String ticketId) throws FileNotFoundException, IOException {

		LOGGER.info("Creating conversation XML for Ticket(" + ticketId + ") ...");

		String filepath = XMLFILESPATH + "\\" + ticketId + ".xml";

		File file = new File(filepath);

		if (file.createNewFile()) {

			LOGGER.info("Conversation XML for Ticket(" + ticketId + ") created!");

			DateFormat format = new SimpleDateFormat(MESSAGEDATEFORMAT);
			PrintWriter out = new PrintWriter(filepath);
			out.write(String.format(INITIALMESSAGE, ticketId, ticketId, format.format(new Date())));
			out.close();

		} else {
			throw new PersistenceException("File already Exists!");
		}

		// DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstanticketce();
		// DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		//
		// Document doc = docBuilder.newDocument();
		// Element rootElement = doc.createElement("conversation");
		// doc.appendChild(rootElement);
		//
		// Attr attr = doc.createAttribute("ticket");
		// attr.setValue(ticketId);
		// rootElement.setAttributeNode(attr);
		//
		// Element messageElement = doc.createElement("message");
		// Attr messageIdAttr = doc.createAttribute("id");
		// messageIdAttr.setValue(ticketId + "-0001");
		// messageElement.setAttributeNode(messageIdAttr);
		// rootElement.appendChild(messageElement);
		//
		// Element fromElement = doc.createElement("from");
		// fromElement.setNodeValue("System");
		// Element toElement = doc.createElement("to");
		// toElement.setNodeValue("Customer");
		// Element dateElement = doc.createElement("date");
		// dateElement.setNodeValue(new Date().toLocaleString());
		// Element textElement = doc.createElement("text");
		// textElement.setNodeValue("Initial message");
		//
		// messageElement.appendChild(fromElement);
		// messageElement.appendChild(toElement);
		// messageElement.appendChild(dateElement);
		// messageElement.appendChild(textElement);
		//
		// TransformerFactory transformerFactory = TransformerFactory.newInstance();
		// Transformer transformer = transformerFactory.newTransformer();
		// DOMSource source = new DOMSource(doc);
		// File file = new File(XMLFILESPATH + "\\" + ticketId + ".xml");
		// LOGGER.info(file.createNewFile());
		// StreamResult result = new StreamResult(file);
		//
		// transformer.transform(source, result);
	}
}
