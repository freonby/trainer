package by.dunaenergo.training;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@WebListener
public class HomeController implements HttpSessionListener, ServletRequestListener {
	@Autowired
	private UserDAO hdao;
	@Autowired
	private ModelAndView menuModel;
	private static final Logger log = Logger.getLogger(HomeController.class);

	@RequestMapping(value = { "/", "/mainPage" }, method = RequestMethod.GET)
	public ModelAndView home(HttpSession session) {
		int questionIndex = 1;
		session.setAttribute("questionIndex", questionIndex);
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
	public ModelAndView menu(HttpSession session) {

		int questionIndex = 1;
		session.setAttribute("questionIndex", questionIndex);
		ArrayList<Part> plist = (ArrayList<Part>) hdao.list();
		menuModel.addObject("partitionList", plist);

		return menuModel;
	}

	@RequestMapping(value = "/checkoption", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String checkOption(@RequestParam String option, HttpSession session) {
		int questionIndex = 1;
		session.setAttribute("questionIndex", questionIndex);
		Part p = hdao.getPartitionByName(option);
		String jsonString = "";
		Gson gson = new Gson();
		jsonString = gson.toJson(p.themeList());

		return jsonString;
	}

	@RequestMapping(value = "/start", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public ModelAndView start(@RequestParam String partition, @RequestParam String theme, HttpSession session) {
		Part p = hdao.getPartitionByName(partition);
		int questionIndex = 1;
		if (theme.equals("Все разделы")) {
			Theme themeCurrent = new Theme("Все разделы", p.allQuestionList());
			Question questionCurrent = themeCurrent.getList().get(questionIndex - 1);
			saveParametersInSession(session, themeCurrent, questionCurrent, questionIndex);
			ModelAndView testingModel = new ModelAndView();
			testingModel.setViewName("konspekt");
			testingModel.addObject("partitionName", p.getName());
			testingModel.addObject("themeName", themeCurrent.getName());
			testingModel.addObject("countQuestions", themeCurrent.CountQuestions());

			return testingModel;

		}
		Theme themeCurrent = p.receiveTheme(theme);
		Question questionCurrent = themeCurrent.getList().get(questionIndex - 1);
		questionCurrent.shuffle();
		saveParametersInSession(session, themeCurrent, questionCurrent, questionIndex);
		ModelAndView testingModel = new ModelAndView();
		testingModel.setViewName("konspekt");
		testingModel.addObject("partitionName", p.getName());
		testingModel.addObject("themeName", themeCurrent.getName());
		testingModel.addObject("countQuestions", themeCurrent.CountQuestions());

		return testingModel;
	}
	// @RequestMapping(value = "/start", method = RequestMethod.GET, produces =
	// "text/html;charset=UTF-8")
	// public String start(@RequestParam String partition, @RequestParam String
	// theme, Model model) {
	// Part p = hdao.getPartitionByName(partition);
	// themeCurrent = p.receiveTheme(theme);
	// questionCurrent = themeCurrent.getList().get(questionIndex - 1);
	// questionCurrent.shuffle();
	// model.addAttribute("partitionName", p.getName());
	// model.addAttribute("themeName", themeCurrent.getName());
	// model.addAttribute("countQuestions", themeCurrent.CountQuestions());
	//
	// return "redirect:testing";
	// }

	@RequestMapping(value = "/check", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String check(@RequestParam String param, HttpSession session) {
		Alert alert = null;
		Result result = null;
		String jsonString = "";
		Theme themeCurrent = (Theme) session.getAttribute("themeCurrent");
		Question questionCurrent = (Question) session.getAttribute("questionCurrent");
		Integer questionIndex = (Integer) session.getAttribute("questionIndex");

		if (param.equals("start")) {
			alert = new Alert("", "none", "", "");
			if (themeCurrent == null)
				return jsonString;
			questionCurrent = themeCurrent.getList().get(questionIndex - 1);
			result = new Result(questionIndex, questionCurrent, alert);
			jsonString = result.toJsonString();
			saveParametersInSession(session, themeCurrent, questionCurrent, questionIndex);
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
				saveParametersInSession(session, themeCurrent, questionCurrent, questionIndex);
				return jsonString;
			}
			questionCurrent = themeCurrent.getList().get(questionIndex - 1);
			result = new Result(questionIndex, questionCurrent, alert);
			jsonString = result.toJsonString();
			saveParametersInSession(session, themeCurrent, questionCurrent, questionIndex);
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
				saveParametersInSession(session, themeCurrent, questionCurrent, questionIndex);
				return jsonString;
			}
			questionCurrent = themeCurrent.getList().get(questionIndex - 1);
			result = new Result(questionIndex, questionCurrent, alert);
			jsonString = result.toJsonString();
			saveParametersInSession(session, themeCurrent, questionCurrent, questionIndex);
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
				saveParametersInSession(session, themeCurrent, questionCurrent, questionIndex);
				jsonString = result.toJsonString();

				return jsonString;
			}
			alert = new Alert("alert alert-success", "block", "ПРАВИЛЬНО!", "");
			questionCurrent = themeCurrent.getList().get(questionIndex - 1);
			result = new Result(questionIndex, questionCurrent, alert);
			jsonString = result.toJsonString();
			saveParametersInSession(session, themeCurrent, questionCurrent, questionIndex);
			return jsonString;
		}

		alert = new Alert("alert alert-danger", "block", "НЕПРАВИЛЬНО!", "Правильный ответ: " + questionCurrent.getValidAnswer().getName());
		result = new Result(questionIndex, questionCurrent, alert);
		saveParametersInSession(session, themeCurrent, questionCurrent, questionIndex);
		jsonString = result.toJsonString();
		return jsonString;
	}

	@RequestMapping(value = "/closeSession", method = RequestMethod.GET)
	@ResponseBody
	public void close(@RequestParam(required = false) String optionClose) {
		System.out.println("Ping server for session validating...");
	}

	@RequestMapping(value = "/overview", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String overview(@RequestParam String param, HttpSession session) {
		Alert alert = null;
		Result result = null;
		String jsonString = "";
		Theme themeCurrent = (Theme) session.getAttribute("themeCurrent");
		Question questionCurrent = (Question) session.getAttribute("questionCurrent");
		Integer questionIndex = (Integer) session.getAttribute("questionIndex");

		if (param.equals("start")) {
			alert = new Alert("", "none", "", "");
			if (themeCurrent == null)
				return jsonString;
			questionCurrent = themeCurrent.getList().get(questionIndex - 1);
			result = new Result(questionIndex, questionCurrent, alert);
			jsonString = result.konspektJson();
			saveParametersInSession(session, themeCurrent, questionCurrent, questionIndex);
			return jsonString;

		}
		if (param.equals("prev")) {
			alert = new Alert("", "none", "", "");
			questionIndex--;
			if (questionIndex < 1) {
				questionIndex = 1;
				questionCurrent = themeCurrent.getList().get(questionIndex - 1);
				result = new Result(questionIndex, questionCurrent, alert);
				jsonString = result.konspektJson();
				saveParametersInSession(session, themeCurrent, questionCurrent, questionIndex);
				return jsonString;
			}
			questionCurrent = themeCurrent.getList().get(questionIndex - 1);
			result = new Result(questionIndex, questionCurrent, alert);
			jsonString = result.konspektJson();
			saveParametersInSession(session, themeCurrent, questionCurrent, questionIndex);
			return jsonString;

		}
		if (param.equals("next")) {
			alert = new Alert("", "none", "", "");
			questionIndex++;
			if (questionIndex > themeCurrent.CountQuestions()) {
				alert = new Alert("alert alert-info", "block", "Вы просмотрели все доступные вопросы данного раздела!", "");
				questionIndex--;
				questionCurrent = themeCurrent.getList().get(questionIndex - 1);
				result = new Result(questionIndex, questionCurrent, alert);
				jsonString = result.konspektJson();
				saveParametersInSession(session, themeCurrent, questionCurrent, questionIndex);
				return jsonString;
			}
			questionCurrent = themeCurrent.getList().get(questionIndex - 1);
			result = new Result(questionIndex, questionCurrent, alert);
			jsonString = result.konspektJson();
			saveParametersInSession(session, themeCurrent, questionCurrent, questionIndex);
			return jsonString;

		}
		return jsonString;
	}

	public void saveParametersInSession(HttpSession session, Theme th, Question q, Integer index) {
		session.setAttribute("themeCurrent", th);
		session.setAttribute("questionCurrent", q);
		session.setAttribute("questionIndex", index);

	}

	@Override
	public void sessionCreated(HttpSessionEvent ev) {
		Date d = new Date(ev.getSession().getCreationTime());

		log.warn("session created time: " + d);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent ev) {

	}

	@Override
	public void requestDestroyed(ServletRequestEvent ev) {

	}

	@Override
	public void requestInitialized(ServletRequestEvent ev) {
		log.warn(" new request: " + ev.getServletRequest().getRemoteAddr());

	}

}
