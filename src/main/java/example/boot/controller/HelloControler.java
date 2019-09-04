package example.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControler {

  @RequestMapping("/hello")
  public String hello(Model model) {

    model.addAttribute("hello", "Hello Spring MVC");

    // ビュー名として"hello"を返却
    // Viewは下記となる
    // src/main/resources/templates/hello.html
    return "hello";
  }
}
