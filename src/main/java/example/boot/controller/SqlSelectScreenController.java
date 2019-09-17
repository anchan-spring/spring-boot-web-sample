package example.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.boot.entity.UserEntity;
import example.boot.service.UserService;

@Controller
public class SqlSelectScreenController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/sql_select", method = RequestMethod.GET)
	public String showInputScreen(Model model) {

		try {
			List<UserEntity> userEntity = userService.selectAll();
			model.addAttribute("userList",userEntity);
		}catch(Exception e) {
			return "sql_select";
		}

		return "sql_select";
	}

}
