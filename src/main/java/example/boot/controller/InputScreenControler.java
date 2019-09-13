package example.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.boot.entity.InputEntity;

@Controller
public class InputScreenControler {

  private InputEntity inputEntity;

  //コンストラクタインジェクション
  //コンストラクタ一つの場合は@Autowired省略可能
  @Autowired
  public InputScreenControler(InputEntity inputEntity) {
	  this.inputEntity = inputEntity;
  }

  @RequestMapping(value = "/input", method = RequestMethod.GET)
  public String showInputScreen(Model model) {
	//model.addAttribute("InputEntity", new InputEntity());
	model.addAttribute("InputEntity", inputEntity);

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


}
