package stackjava.com.springmvchello.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Entity.Person;

@RestController
public class PersonRestController {

	public static HashMap<Integer, Person> mapPerson = new HashMap<Integer, Person>();
	static {
		mapPerson.put(1, new Person(1,"Bao Anh", "Long An", 28, "baoanh@gmail.com", "0905384893"));
		mapPerson.put(2, new Person(2,"Cao Trinh", "Quang Ngai", 21, "caotrinh@gmail.com", "0905386574"));
		mapPerson.put(3, new Person(3,"Hong Ha", "Quang Binh", 24, "hongha@gmail.com", "09053864521"));
		mapPerson.put(4, new Person(4,"Bich Chi", "Hue", 25, "bichchi@gmail.com", "0905387894"));
		mapPerson.put(5, new Person(5,"Hong Nhung", "Quang Ninh", 28, "hongnhung@gmail.com", "090535364"));
		mapPerson.put(6, new Person(6,"Khanh Ha", "Tien Giang", 32, "khanhha@gmail.com", "0907845123"));
		Person p1 = new Person(7,"Vo Cao Trinh", "Quang Ngai", 18, "vocaotrinh1999@gmail.com", "0905384893");
		Person p2 = new Person(8,"Cao Thi Nga", "Tay Ninh", 28, "ngacao@gmail.com", "019384756");
		Person p3 = new Person(9,"Vo Duoc", "An Giang", 38, "duocvo@gmail.com", "0905384893");
		Person p4 = new Person(10,"Vo Kim Ngan", "Phu Tho", 12, "ngankim@gmail.com", "0905384893");
		Person p5 = new Person(11,"Do My Linh", "Ha Noi", 22, "mylinh@gmail.com", "0905364754");
		Person p6 = new Person(12,"Nguyen Khanh Ha", "Phu Tho", 12, "ngankim@gmail.com", "0905384893");
		Person p7 = new Person(13,"Dinh Ha Thu", "An Giang", 48, "thuha@gmail.com", "0905381254");
		Person p8 = new Person(14,"Kim Ha Minh", "Tien Giang", 45, "minhkim@gmail.com", "0905343562");
		mapPerson.put(7, p1);
		mapPerson.put(8, p2);
		mapPerson.put(9, p3);
		mapPerson.put(10, p4);
		mapPerson.put(11, p5);
		mapPerson.put(12, p6);
		mapPerson.put(13, p7);
		mapPerson.put(14, p8);
	}
	
	//Get all person
	@RequestMapping(value="/persons", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getAllPerson(){ 
		List<Person> users = new ArrayList<Person>(mapPerson.values());
		return new ResponseEntity<List<Person>>(users,HttpStatus.OK);
	}
	//find person by id
	@RequestMapping(value="/persons/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getPersonById(@PathVariable int id){
		System.out.println(id);
		Person person = mapPerson.get(id);
		if(person != null) {
			return new ResponseEntity<Object>(person, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Not found person", HttpStatus.NO_CONTENT);
	}	
}
