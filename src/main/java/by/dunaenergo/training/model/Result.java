package by.dunaenergo.training.model;

import java.util.ArrayList;

import com.google.gson.Gson;

public class Result {
	private Question currentQuestion;
	private Alert alert;
	private int questionIndex;

	public Result(int questionIndex, Question currentQuestion, Alert alert) {
		super();
		this.currentQuestion = currentQuestion;
		this.alert = alert;
		this.questionIndex = questionIndex;
	}

	public Question getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public Alert getAlert() {
		return alert;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}

	public String toJsonString() {
		String jsonString = "";
		ArrayList<String> list = new ArrayList<String>();
		// ObjectMapper mapper = new ObjectMapper();
		Gson gson = new Gson();
		list.add(Integer.toString(questionIndex));
		list.add(currentQuestion.getName());
		list.addAll(currentQuestion.receiveAnswerNames());
		list.add(alert.getStyle());
		list.add(alert.getDisplay());
		list.add(alert.getCause());
		list.add(alert.getAlertMessage());
		list.add(currentQuestion.getDescription());
		jsonString = gson.toJson(list);
		return jsonString;
	}

	public String konspektJson() {
		String jsonString = "";
		ArrayList<String> list = new ArrayList<String>();
		Gson gson = new Gson();
		list.add(Integer.toString(questionIndex));
		list.add(currentQuestion.getName());
		Answer validAnswer = currentQuestion.getValidAnswer();
		if (validAnswer != null) {
			list.add(currentQuestion.getValidAnswer().getName());
			list.add(alert.getStyle());
			list.add(alert.getDisplay());
			list.add(alert.getCause());
			list.add(alert.getAlertMessage());
			list.add(currentQuestion.getDescription());
			jsonString = gson.toJson(list);
			return jsonString;
		}
		list.add("НЕТ ОТВЕТА");
		list.add(alert.getStyle());
		list.add(alert.getDisplay());
		list.add(alert.getCause());
		list.add(alert.getAlertMessage());
		list.add(currentQuestion.getDescription());
		jsonString = gson.toJson(list);
		return jsonString;
	}

}
