package example.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.boot.entity.InputEntity;
import example.boot.service.UserService;

@Controller
public class SqlInsertScreenController {

	@Autowired
	private InputEntity inputEntity;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/sql_insert", method = RequestMethod.GET)
	public String showSqlDeleteScreen(Model model) {
		//model.addAttribute("InputEntity",inputEntity);
		return "sql_insert";
	}

}
