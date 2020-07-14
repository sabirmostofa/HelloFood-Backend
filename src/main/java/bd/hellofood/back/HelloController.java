package bd.hellofood.back;

import org.springframework.web.bind.annotation.RestController;

import bd.hellofood.back.service.FirebaseService;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
    @Autowired
	FirebaseService firebaseService;

	@RequestMapping("/")
	public String index(Model model) throws InterruptedException, ExecutionException {
		
		Logger logger =LoggerFactory.getLogger(HelloController.class);
		
		logger.info("printing shits");
		
		System.out.println("printing orders");
		
		System.out.println(firebaseService.getOrders().toString());
		
		
		model.addAttribute("content", "helloWorldView");     
		   return "index";
	
	}
	
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("content", "helloWorldView");
		System.out.println("printing orders");
		return "index";
	}

}
