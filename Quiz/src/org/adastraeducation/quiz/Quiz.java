package org.adastraeducation.quiz;
import java.io.*;
import java.lang.reflect.*;

public class Quiz {
	public static void testHTMLAndXML(StringBuilder html, StringBuilder xml) {
		html.append
			("!DOCTYPE html\n<html><body>");

		xml.append
			("<?xml version=\"1.0\" ?>");

		MultiChoice.testHTMLAndXML(html, xml);
		//		MultiAnswer.testHTMLAndXML(html, xml);
		// Equation.testHTMLAndXML(html, xml);
		html.append
			("</body></html>");
	}

	public static void main(String []args){
		StringBuilder html = new StringBuilder();
		StringBuilder xml = new StringBuilder();
		// first conduct unit test for each class
		try {
			String[] classes = {"MultiChoice" } ;//, "MultiAnswer"
			for (String className : classes) {
				Class c = Class.forName("org.adastraeducation.quiz." + className);
				//Method[] allMethods = c.getDeclaredMethods();
				Method m = c.getMethod("testHTMLAndXML", StringBuilder.class, StringBuilder.class);
				//Method m  = c.getMethod("testHTMLAndXML", new Object[] {StringBuilder.class, StringBuilder.class})
				//for (Method m : allMethods) {
					System.out.println(m.getName());
				//}
				//				c.execute(m, html, xml);
				m.invoke(c, new Object[]{html, xml});
				try {
		 			PrintWriter pw = new PrintWriter("html/" + className + ".html");
		 			pw.println(html);
					pw.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				try {
					PrintWriter pw = new PrintWriter("html/" + className + ".xml");
					pw.println(xml);
					pw.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		} catch (Exception e) {
				e.printStackTrace(); // class not found? Some other problem?
		}

		html.setLength(0);
		xml.setLength(0);
		//now clear and create unit test with quiz for everyone 
		testHTMLAndXML(html, xml);
		try {
 			PrintWriter pw = new PrintWriter("html/quiz.html");
 			pw.println(html);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			PrintWriter pw = new PrintWriter("html/question.xml");
			pw.println(xml);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
