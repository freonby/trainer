package by.dunaenergo.training.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Theme implements Serializable {

	private static final long serialVersionUID = -9128667106174999604L;
	private String text;
	private ArrayList<Question> list;
	private long id;

	public Theme(String text, ArrayList<Question> list) {
		super();
		this.text = text;
		this.list = list;

	}

	public Theme(String text) {
		super();
		this.text = text;
		this.list = new ArrayList<Question>();
	}

	public Theme() {
		super();
		this.text = "";
		this.list = new ArrayList<Question>();
	}

	public void shuffle() {
		Collections.shuffle(list);
	}

	public boolean checkQuestion(Question q) {

		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				if ((list.get(i)).equals(q))
					return true;
			}
		}
		return false;

	}

	public void sort() {
		Comparator<Question> cmp = new Comparator<Question>() {

			@Override
			public int compare(Question a, Question b) {
				return a.getName().compareToIgnoreCase(b.getName());
			}

		};
		Collections.sort(list, cmp);
	}

	public void removeAllQuestions() {
		list.removeAll(list);
	}

	public void addQuestion(Question q) {
		list.add(q);
	}

	public void deleteQuestion(Question q) {
		list.remove(q);
	}

	public void deleteQuestion(String short_name) {
		if (list.isEmpty())
			return;
		Question q = null;
		for (int i = 0; i < list.size(); i++) {
			q = list.get(i);
			if (q.getShort_name().equals(short_name))
				list.remove(q);
		}

	}

	public int CountQuestions() {
		return list.size();
	}

	public String getName() {
		return text;
	}

	public void setName(String text) {
		this.text = text;
	}

	public ArrayList<Question> getList() {
		return list;
	}

	public void setList(ArrayList<Question> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return text;
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
		Theme other = (Theme) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}
