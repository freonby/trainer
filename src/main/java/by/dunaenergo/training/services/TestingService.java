package by.dunaenergo.training.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import by.dunaenergo.training.interfaces.UserDAO;
import by.dunaenergo.training.model.Part;

public class TestingService {
	@Autowired
	private UserDAO hdao;

	public TestingService() {
		super();
	}

	public ArrayList<Part> getPartList() {

		ArrayList<Part> plist = (ArrayList<Part>) hdao.list();

		return plist;
	}
}
