package bd.hellofood.back.controllers;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bd.hellofood.back.FirebaseCallback;
import bd.hellofood.back.beans.PlaceBean;
import bd.hellofood.back.services.FirebaseRealtimeService;
import bd.hellofood.back.services.FirebaseService;

@Controller
public class HomeController {


	@Autowired
	private FirebaseRealtimeService firebaseRealService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("content", "helloWorldView");
		return "index";
	}

	@RequestMapping("/place")
	public ModelAndView place(Model model) throws InterruptedException {

		ModelAndView modelAndView = new ModelAndView("place");
		PlaceBean place = firebaseRealService.getPlace("Jamalpur");
		modelAndView.addObject("place", place);
		return modelAndView;

	}
}
