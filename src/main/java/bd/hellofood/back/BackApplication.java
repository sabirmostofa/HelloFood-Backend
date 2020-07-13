package bd.hellofood.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
public class BackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}
	
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(Model model) {
	model.addAttribute("message", "Hello Spring MVC!!");
	return "home";
	}
	
	

}
