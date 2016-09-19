package by.dunaenergo.training.interfaces;

import java.util.List;

import by.dunaenergo.training.model.Part;

public interface UserDAO {
	public List<Part> list();

	public Part getPartitionByName(String name);
}
