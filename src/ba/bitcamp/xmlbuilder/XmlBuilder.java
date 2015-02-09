package ba.bitcamp.xmlbuilder;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlBuilder {

	public static void main(String[] args) {
		
		Document xmlDoc;
		
		DocumentBuilder docReader;
		
		try {
			
			docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			
			xmlDoc = docReader.newDocument();
			
			Element root = xmlDoc.createElement("users");
			
			Element user = xmlDoc.createElement("user");
			
			user.setAttribute("username", "joe");
			
			user.setAttribute("password", "4321");
			
			root.appendChild(user);
			
			xmlDoc.appendChild(root);
			
			Transformer t;
			
			try {
				
				t = TransformerFactory.newInstance().newTransformer();
				
				t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","2");
				
			} catch (TransformerConfigurationException
					| TransformerFactoryConfigurationError e) {
				
				try {
					
					Result r = new StreamResult(new FileOutputStream("./xml/users.xml"));
					t.transform(xmlSource, r);
					
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		}
		

	}

}
