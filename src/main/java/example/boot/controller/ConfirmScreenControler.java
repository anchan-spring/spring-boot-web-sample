package example.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.boot.entity.InputEntity;

@Controller
public class ConfirmScreenControler {

  @Autowired
  private InputEntity inputEntity;

  @RequestMapping(value = "/confirm", params = "doBack", method = RequestMethod.POST)
  public String doBack(Model model) {
	  model.addAttribute("InputEntity", inputEntity);
	  return "input";
  }

  //PostMapping,GetMappingでも可能
  //@RequestMapping(value = "/confirm", params = "doComplete", method = RequestMethod.POST)
  @PostMapping(value = "/confirm", params = "doComplete")
  public String doComplete(Model model) {
	  return "complete";
  }

}
