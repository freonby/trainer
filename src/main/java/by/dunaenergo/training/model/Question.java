package by.dunaenergo.training.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Question implements Serializable, Cloneable {

	private static final long serialVersionUID = -7995246721672274350L;
	private ArrayList<Answer> answers;
	private String text;
	private String short_name;
	private String description;
	private long id;

	public Question(String text, ArrayList<Answer> list) {
		super();
		this.text = text;
		this.answers = list;
	}

	public Question(String text) {
		super();
		this.text = text;
		this.answers = new ArrayList<Answer>();

	}

	public Question(String text, String desc) {
		super();
		this.text = text;
		this.description = desc;
		this.answers = new ArrayList<Answer>();

	}

	public Question() {
		super();
		this.text = "";
		this.description = "";
		this.answers = new ArrayList<Answer>();
	}

	public void shuffle() {
		Collections.shuffle(answers);
	}

	public void sort() {
		Comparator<Answer> cmp = new Comparator<Answer>() {

			@Override
			public int compare(Answer a, Answer b) {
				return a.getName().compareToIgnoreCase(b.getName());
			}

		};
		Collections.sort(answers, cmp);
	}

	public ArrayList<String> receiveAnswerNames() {
		ArrayList<String> listnames = new ArrayList<String>();
		if (answers.isEmpty())
			return null;

		for (Answer answer : answers) {

			listnames.add(answer.getName());
		}
		return listnames;

	}

	public boolean check(String answ) {
		Answer validAnswer = null;
		for (Answer answer : answers) {
			if (answer.getValid()) {
				validAnswer = answer;
				break;
			} else
				continue;
		}
		if (validAnswer.getName().equals(answ))
			return true;
		return false;
	}

	public void removeAllAnswers() {
		answers.removeAll(answers);
	}

	public Answer getValidAnswer() {
		for (Answer answer : answers) {
			if (answer.getValid())
				return answer;
			continue;
		}
		return null;

	}

	public void addAnswer(Answer a) {
		answers.add(a);
	}

	public void deleteAnswer(Answer a) {
		answers.remove(a);
	}

	public int countAnswers() {
		return answers.size();
	}

	@Override
	public String toString() {
		return text;
	}

	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}

	public String getName() {
		return text;
	}

	public void setName(String text) {
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
