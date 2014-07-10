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
		//Match.testHTMLAndXML(html, xml);
		//FillIn.testHTMLAndXML(html, xml);
	//		MultiAnswer.testHTMLAndXML(html, xml);
		// Equation.testHTMLAndXML(html, xml);
		html.append
			("</body></html>");
	}
	
	/*
	 * Write out the HTML for a quiz.  The quiz is in charge of 
	 * generating the form, and making sure that each question 
	 * knows its unique name (could be q1, q2, q3...)
	 */
	
	public void writeHTML() {
		// write <form name=""...
	}
	
	/*
	 * Write out the XML to represent an entire quiz
	 * This is not for display, just to save for purposes of export to other systems
	 * or backup.
	 */
	public void writeXML() {
		
	}
	
	public static void main(String []args){
		StringBuilder html = new StringBuilder();
		StringBuilder xml = new StringBuilder();
		
		// first conduct unit test for each class
		try {
			html.setLength(0);
			xml.setLength(0);
			html.append("<html><body>\n");
			String[] classes = {"MultiChoice"} ;//, "MultiAnswer"
			for (String className : classes) {
				Class c = Class.forName("org.adastraeducation.quiz." + className);
				Method m = c.getMethod("testHTMLAndXML", StringBuilder.class, StringBuilder.class);
				m.invoke(c, new Object[]{html, xml});
				html.append("</body></html>");

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
