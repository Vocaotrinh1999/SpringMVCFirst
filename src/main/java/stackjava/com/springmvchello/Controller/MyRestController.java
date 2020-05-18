package stackjava.com.springmvchello.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import Entity.Person;

@RestController
public class MyRestController {

	@ResponseBody
	@RequestMapping(value = "/testVariable/{id}/{name}")
	public String testVarible(@PathVariable("id") int id, @PathVariable("name") String name) {
		return "Test path variable with id : " + id + ", and name : " + name;
	}

	@ResponseBody
	@RequestMapping(value = "/test2")
	public String testResponseBody() {
		return "testResponse Body";
	}

	@ResponseBody
	@RequestMapping(value = "/testJson")
	public Person testJson() {
		Person p1 = new Person(1,"Vo Cao Trinh", "Quang Ngai", 18, "vocaotrinh1999@gmail.com", "0905384893");
		return p1;
	}

	@ResponseBody
	@RequestMapping(value = "/testListJson", method = RequestMethod.GET)
	public List<Person> testListPerson() {
		List<Person> list = new ArrayList<Person>();
		Person p1 = new Person(1,"Vo Cao Trinh", "Quang Ngai", 18, "vocaotrinh1999@gmail.com", "0905384893");
		Person p2 = new Person(2,"Cao Thi Nga", "Tay Ninh", 28, "ngacao@gmail.com", "019384756");
		Person p3 = new Person(3,"Vo Duoc", "An Giang", 38, "duocvo@gmail.com", "0905384893");
		Person p4 = new Person(4,"Vo Kim Ngan", "Phu Tho", 12, "ngankim@gmail.com", "0905384893");
		Person p5 = new Person(5,"Do My Linh", "Ha Noi", 22, "mylinh@gmail.com", "0905364754");
		Person p6 = new Person(6,"Nguyen Khanh Ha", "Phu Tho", 12, "ngankim@gmail.com", "0905384893");
		Person p7 = new Person(7,"Dinh Ha Thu", "An Giang", 48, "thuha@gmail.com", "0905381254");
		Person p8 = new Person(8,"Kim Ha Minh", "Tien Giang", 45, "minhkim@gmail.com", "0905343562");
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		list.add(p8);
		return list;
	}

}
