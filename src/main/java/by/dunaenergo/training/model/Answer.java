package by.dunaenergo.training.model;

import java.io.Serializable;

public class Answer implements Serializable {

	private static final long serialVersionUID = -5232335801083237745L;
	private String text;
	private boolean valid;
	private long id;

	public Answer(String text, boolean valid) {
		super();
		this.text = text;
		this.valid = valid;

	}

	public Answer() {
		text = "";
		valid = false;
	}

	@Override
	public String toString() {
		return text;
	}

	public String getName() {
		return text;
	}

	public void setName(String text) {
		this.text = text;
	}

	public boolean getValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
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
		Answer other = (Answer) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}
