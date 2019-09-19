package example.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.boot.entity.InputEntity;
import example.boot.entity.UserEntity;
import example.boot.service.UserService;

@Controller
public class SqlDeleteScreenController {

	@Autowired
	private InputEntity inputEntity;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/sql_delete", method = RequestMethod.GET)
	public String showSqlDeleteScreen(Model model) {
		model.addAttribute("InputEntity",inputEntity);

		return "sql_delete";
	}

	@RequestMapping(value = "/sql_select",name="doDelete" ,method = RequestMethod.POST)
	public String delete(@ModelAttribute("InputEntity") InputEntity form,Model model) {

	  //削除処理
	  userService.delete(form.getDeletekey());

      //再取得
	  List<UserEntity> userEntity = userService.selectAll();
	  model.addAttribute("userList",userEntity);

	  return "sql_select";
	}

}
