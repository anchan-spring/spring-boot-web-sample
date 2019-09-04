package example.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.boot.entity.InputEntity;

@Controller
public class InputScreenControler {

  @RequestMapping(value = "/input", method = RequestMethod.GET)
  public String showInputScreen(Model model) {
	model.addAttribute("InputEntity", new InputEntity());

	// ビュー名として"hello"を返却
	// Viewは下記となる
	// src/main/resources/templates/hello.html
	return "input";
  }

  @RequestMapping(value = "/confirm", method = RequestMethod.POST)
  public String confirm(@ModelAttribute("InputEntity") InputEntity form) {
	// 遷移先を返す(この場合はconfirm.htmlが遷移先となる)
	return "confirm";
  }

  /*@RequestMapping(value = "/input", params = "doBack", method = RequestMethod.POST)
  public String doBack(Model model) {
	  model.addAttribute("InputEntity", new InputEntity());
	  return "input";
  }

  @RequestMapping(value = "/input", params = "doComplete", method = RequestMethod.POST)
  public String doComplete(Model model) {
	  //model.addAttribute("InputEntity", new InputEntity());
	  return "complete";
  }*/

}
