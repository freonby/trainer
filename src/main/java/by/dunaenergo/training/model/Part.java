package by.dunaenergo.training.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Part implements Serializable {

	private static final long serialVersionUID = -6135871883599814544L;
	private String name;
	private ArrayList<Theme> list;
	private long id;

	public Part() {
		super();
		this.name = "";
		this.list = new ArrayList<Theme>();
	}

	public void removeAllThemes() {
		list.removeAll(list);
	}

	public void addTheme(Theme t) {
		list.add(t);
	}

	public boolean checkTheme(Theme t) {

		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				if ((list.get(i)).equals(t))
					return true;
			}
		}
		return false;

	}

	public Theme receiveTheme(String name) {
		Theme theme = null;
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				if ((list.get(i)).getName().equals(name))
					return theme = list.get(i);
			}
		}
		return null;

	}

	public void deleteTheme(Theme t) {
		list.remove(t);
	}

	public void deleteTheme(String name) {
		if (list.isEmpty())
			return;
		Theme th = null;
		for (int i = 0; i < list.size(); i++) {
			th = list.get(i);
			if (th.getName().equals(name))
				list.remove(th);
		}

	}

	public ArrayList<String> themeList() {
		ArrayList<String> listName = new ArrayList<String>();
		if (list.isEmpty())
			return null;
		for (Theme theme : list) {
			listName.add(theme.getName());
		}
		return listName;

	}

	public int CountThemas() {
		return list.size();
	}

	public String getName() {
		return name;
	}

	public void setName(String text) {
		this.name = text;
	}

	public ArrayList<Theme> getList() {
		return list;
	}

	public void setList(ArrayList<Theme> list) {
		this.list = list;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Part other = (Part) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
