package org.adastraeducation.quiz.parser;

import org.xml.sax.Attributes;

public abstract class ObjectFactory {
	public abstract Object create(Attributes attr);
	public abstract void addQuestion(String s);
	public abstract void addAnswer(String s);
	public void setQuestionAttributes(org.adastraeducation.quiz.Question q,
		Attributes attr) {
		String id = attr.getValue("id");
		String name = attr.getValue("name");
		String level = attr.getValue("level");
		String graphicQuestion = attr.getValue("")
		q.setId(id);
		q.setName(name);
		q.setLevel(Integer.parseInt(level));
	}

}