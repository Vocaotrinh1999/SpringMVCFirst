package stackjava.com.springmvchello.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


import Entity.Person;

@Controller
public class MyController {

	@RequestMapping(value = "/")
	public String index() {
		return "index1";
	}
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
	@RequestMapping(value="/testRest")
	public String testRest() {
		return "testRest";
	}
	@RequestMapping(value = "/testRequestParam", method = RequestMethod.POST)
	public String testRequestParam(@RequestParam("id") int id,@RequestParam("name") String name, @RequestParam("address") String address,
									@RequestParam("age") int age, @RequestParam("email") String email,
									@RequestParam("phoneNumber") String phoneNumber, Model model) {
		Person person = new Person(id,name, address, age, email, phoneNumber);
		model.addAttribute("person", person);
		return "test1";
	}
	
	//test redirect
	@RequestMapping(value="/redirect")
	public String redirect() {
		return "redirect:page2";
	}
	@ResponseBody
	@RequestMapping("/page2")
	public String page2() {
		return "page2";
	}
	//test RedirectView
	//co the tra ve String redirect:page22 nhu tren
	@RequestMapping(value = "/redirectview")
	public RedirectView redirectView(@RequestParam("name") String name, @RequestParam("email") String email,
			RedirectAttributes  redirectAttributes) {
		redirectAttributes.addAttribute("name", name);
		redirectAttributes.addAttribute("email", email);
		return new RedirectView("page22");
	}
	@RequestMapping(value="/page22",method = RequestMethod.POST)
	public String page22(@RequestParam("name") String name, @RequestParam("email") String email, Model model) {
		model.addAttribute("name",name);
		model.addAttribute("email", email);
		return "page2";
	}
	
}
