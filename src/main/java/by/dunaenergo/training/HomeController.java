package by.dunaenergo.training;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import by.dunaenergo.training.interfaces.UserDAO;
import by.dunaenergo.training.model.Alert;
import by.dunaenergo.training.model.Part;
import by.dunaenergo.training.model.Question;
import by.dunaenergo.training.model.Result;
import by.dunaenergo.training.model.Theme;

@Controller
public class HomeController implements DisposableBean {
	@Autowired
	private UserDAO hdao;

	@Autowired
	private ModelAndView menuModel;
	private Theme themeCurrent;
	private Question questionCurrent;
	private int questionIndex = 1;

	private HttpSession session;

	@RequestMapping(value = { "/", "/mainPage" }, method = RequestMethod.GET)
	public ModelAndView home(HttpSession session) {
		this.session = session;
		ModelAndView model = new ModelAndView();
		model.setViewName("mainPage");
		model.addObject("sid", session.getId());
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Ошибка авторизации:");
		}

		model.setViewName("login");

		return model;

	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public ModelAndView menu() {

		questionIndex = 1;
		ArrayList<Part> plist = (ArrayList<Part>) hdao.list();
		menuModel.addObject("partitionList", plist);

		return menuModel;
	}

	@RequestMapping(value = "/checkoption", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String checkOption(@RequestParam String option) {
		questionIndex = 1;
		Part p = hdao.getPartitionByName(option);
		String jsonString = "";
		Gson gson = new Gson();

		jsonString = gson.toJson(p.themeList());

		return jsonString;
	}

	// @RequestMapping(value = "/start", method = RequestMethod.GET, produces =
	// "text/html;charset=UTF-8")
	// public ModelAndView start(@RequestParam String partition, @RequestParam
	// String theme) {
	// Part p = hdao.getPartitionByName(partition);
	// themeCurrent = p.receiveTheme(theme);
	// questionCurrent = themeCurrent.getList().get(questionIndex - 1);
	// questionCurrent.shuffle();
	// testingModel.addObject("partitionName", p.getName());
	// testingModel.addObject("themeName", themeCurrent.getName());
	// testingModel.addObject("countQuestions", themeCurrent.CountQuestions());
	//
	// return testingModel;
	// }
	@RequestMapping(value = "/start", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String start(@RequestParam String partition, @RequestParam String theme, ModelMap model) {
		Part p = hdao.getPartitionByName(partition);
		themeCurrent = p.receiveTheme(theme);
		questionCurrent = themeCurrent.getList().get(questionIndex - 1);
		questionCurrent.shuffle();
		model.addAttribute("partitionName", p.getName());
		model.addAttribute("themeName", themeCurrent.getName());
		model.addAttribute("countQuestions", themeCurrent.CountQuestions());

		return "redirect:testing";
	}

	@RequestMapping(value = "/check", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String check(@RequestParam String param) {
		Alert alert = null;
		Result result = null;
		String jsonString = "";

		if (param.equals("start")) {
			alert = new Alert("", "none", "", "");
			if (themeCurrent == null)
				return jsonString;
			questionCurrent = themeCurrent.getList().get(questionIndex - 1);
			result = new Result(questionIndex, questionCurrent, alert);
			jsonString = result.toJsonString();
			return jsonString;

		}
		if (param.equals("prev")) {
			alert = new Alert("", "none", "", "");
			questionIndex--;
			if (questionIndex < 1) {
				questionIndex = 1;
				questionCurrent = themeCurrent.getList().get(questionIndex - 1);
				result = new Result(questionIndex, questionCurrent, alert);
				jsonString = result.toJsonString();
				return jsonString;
			}
			questionCurrent = themeCurrent.getList().get(questionIndex - 1);
			result = new Result(questionIndex, questionCurrent, alert);
			jsonString = result.toJsonString();
			return jsonString;

		}
		if (param.equals("next")) {
			alert = new Alert("", "none", "", "");
			questionIndex++;
			if (questionIndex > themeCurrent.CountQuestions()) {
				questionIndex--;
				questionCurrent = themeCurrent.getList().get(questionIndex - 1);
				result = new Result(questionIndex, questionCurrent, alert);
				jsonString = result.toJsonString();
				return jsonString;
			}
			questionCurrent = themeCurrent.getList().get(questionIndex - 1);
			result = new Result(questionIndex, questionCurrent, alert);
			jsonString = result.toJsonString();
			return jsonString;

		}
		boolean check = questionCurrent.check(param);
		if (check) {

			questionIndex++;
			if (questionIndex > themeCurrent.CountQuestions()) {
				questionIndex = 1;
				questionCurrent = themeCurrent.getList().get(questionIndex - 1);
				alert = new Alert("alert alert-info", "block", "ТЕСТ ОКОНЧЕН.", "");
				result = new Result(questionIndex, questionCurrent, alert);
				jsonString = result.toJsonString();

				return jsonString;
			}
			alert = new Alert("alert alert-success", "block", "ПРАВИЛЬНО!", "");
			questionCurrent = themeCurrent.getList().get(questionIndex - 1);
			result = new Result(questionIndex, questionCurrent, alert);
			jsonString = result.toJsonString();
			return jsonString;
		}

		alert = new Alert("alert alert-danger", "block", "НЕПРАВИЛЬНО!", "Правильный ответ: " + questionCurrent.getValidAnswer().getName());
		result = new Result(questionIndex, questionCurrent, alert);
		jsonString = result.toJsonString();
		return jsonString;
	}

	@Override
	public void destroy() throws Exception {
		this.session.invalidate();

		System.out.println("......DESTROY CONTROLLER.....");
	}

	@RequestMapping(value = "/closeSession", method = RequestMethod.GET)
	@ResponseBody
	public void close(@RequestParam(required = false) String optionClose) {
		System.out.println("ping server for session validating...");
	}

}
