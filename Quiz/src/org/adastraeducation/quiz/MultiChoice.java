package org.adastraeducation.quiz;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Represent a Multiple choice question.  Questions and answers may be images or text
 * @author qiangzhang
 * Createddate 6/30/2014
 * 
 */
public class MultiChoice {
	private String id; // unique id for all questions in system
	private String name; // title of the question
	private String level; // level of the question
	private String question; // context of the question
	private Answer[] answers;
	private boolean imgAnswer; // determine graphanswer or textanswer 
	private StdChoice stdchoice;
	private String choices;
	
	
	
	public MultiChoice(String id, String name, String level, String question, String[] answers,String imgAnswer){
		this.id = id;
		this.name = name;
		this.level = level;
		this.question = question;
		this.choices = "";
		
		this.answers = new Answer[answers.length/2];
		for(int i = 0, j = 0; i < this.answers.length; i++,j+=2)
		{
			this.answers[i] = new Answer(answers[j], answers[j+1].equals("t"));
		}
		this.imgAnswer = imgAnswer.equals("t");
	}
	public MultiChoice(String id, String name, String question, StdChoice c, String choices){
		this.id = id;
		this.name = name;
		this.question = question;
		this.choices = choices;
		stdchoice = c;
	}	
	public static void testHTMLAndXML(StringBuilder html, StringBuilder xml){
		String []ans1 = { "A dynosaur", "t", "A fish", "f", "A primate", "f", "A mammal", "f"};
		MultiChoice m1 = new MultiChoice("3", "dynosaur", "1", "What is a Tyranosaurus Rex?", ans1, "f"); 
		
		String []ans2 = { "Tyranosauraus.jpg", "t", "komododragon.jpg", "f", "shark.jpg", "f", "apatosaurus.jpg", "f"};
		MultiChoice m2 = new MultiChoice("4", "dynosaur2", "1", "Identify which of the following is Tyranosauraus Rex", ans2, "t");
		
		String[] a1 = {"Strongly Disagree", "1", "Disagree", "2", "No Opinion", "3", "Agree", "4", "Strongly Agree", "5"};
		StdChoice standardchoice1 = new StdChoice(a1);
		MultiChoice m3 = new MultiChoice("1", "poll1", "I enjoy studying computational complexity.", standardchoice1, "stdopinion");
		
		MultiChoice m4 = new MultiChoice("x1", "poll1", "I enjoy eating Chinese food.", standardchoice1, "stdopinion");
		
		String[] a2 = {"O(1)", "1", "O(log_2 n)", "logn", "O(sqrt n)", "sqrtn", "O(n)", "n", "O(n log_2 n)", "nlogn", "O(n^2)", "n^2", "O(n^3)", "n^3"};
		StdChoice standardchoice2 = new StdChoice(a2);
		MultiChoice m5 = new MultiChoice("2", "complexity", "The complexity of insertion sort is:", standardchoice2, "complexity");
		
		m1.writeHTML(html);
		m2.writeHTML(html);
		m3.writeHTML(html);
		m4.writeHTML(html);
		m5.writeHTML(html);
		m1.writeXML(xml);
		m2.writeXML(xml);
		m3.writeXML(xml);
		m4.writeXML(xml);
		m5.writeXML(xml);
	}
	public void writeHTML(StringBuilder b){
		b.append("<h1>").append(this.name).append("</h1>");
		b.append("<h2>" + question + "</h2>");
		b.append("<form id=\"").append(id).append("\" name=\"").append(name).append("\">");
		if(this.choices.equals("stdopinion")||this.choices.equals("complexity"))
			this.stdchoice.writeHTML(b);
		else
			for(int i = 0; i < this.answers.length; i++) {
				if(imgAnswer)
					b.append(this.answers[i].graphanswer());
				else 
					b.append(this.answers[i].textanswer());
			}
		b.append("</form>");
	}
	
	public void writeXML(StringBuilder b) {
		b.append("<MultiChoice id=\"").append(id).append("\" name=\"").append(name).append("\" level=\"").append(level).append("\" imgAnswer=\"").append(imgAnswer).append("\">");
		b.append(question);
		if(this.choices.equals("stdopinion")||this.choices.equals("complexity"))
			this.stdchoice.writeXML(b);
		else
			for(int i = 0; i < answers.length ; i++)
			{
				b.append(answers[i].writeXML());
			}
		b.append("</MultiChoice>");
	}
	public static void main(String []args){
		StringBuilder html = new StringBuilder();
		StringBuilder xml = new StringBuilder();	
		MultiChoice.testHTMLAndXML(html, xml);
		try {
			PrintWriter pw1 = new PrintWriter("html/multichoice.html");
			PrintWriter pw2 = new PrintWriter("html/multichoice.xml");
			pw1.println(html);
			pw2.println(xml);
			pw1.close();
			pw2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}

