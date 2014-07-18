package org.adastraeducation.quiz.parser;
import org.adastraeduccation.quiz.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.HashMap;



class MyHandler extends DefaultHandler {
	private ObjectFactory current; // which object we are currently working on
	private HashMap<String, ObjectFactory> objMap;
	
	
	
	class MultiChoiceFactory extends ObjectFactory {
		private org.adastraeducation.quiz.Match m;
		public void create(Attributes attr) {
			current = m = new org.adastraeducation.quiz.Match();
			super.setQuestionAttributes(m, attr);
		}
		public void addQuestion(String s) {
			m.setQuestion(s);
		}
	}

	class AFactory extends ObjectFactory {
		//private Answer a;
		public Object create(Attributes attr) {
			//a = new Answer();
			for (int i = 0; i < attr.getLength(); i++)
				System.out.println(attr.getLocalName(i) + "=" + attr.getValue(i));
			return null;
		}
		public void add(String s) {
			//a.setAnswer(s);
		}
	}
	public MyHandler() {
		objMap = new HashMap<String, ObjectFactory>();
		objMap.put("MultiChoice", new MultiChoiceFactory());
	}

	public void startElement(String uri, String localName, String qName, 
			Attributes attributes) throws SAXException {
		System.out.println("Start Element :" + qName);
		ObjectFactory factory = objMap.get(qName);
		if (factory != null) {
			factory.create(attributes);
			current = factory; // remember which tag we are working on NOW.
		}
	}

	public void endElement(String uri, String localName,
			String qName) throws SAXException {
		System.out.println("End Element :" + qName);
	}

	public void characters(char ch[], int start, int length) throws SAXException {
		String s = new String(ch, start, length);
		System.out.println(s);
		current.add(s);
	}
};


public class ParseTest {
	public static void main(String argv[]) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			MyHandler handler = new MyHandler();
			saxParser.parse("question.xml", handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
