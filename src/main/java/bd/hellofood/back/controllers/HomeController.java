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

	boolean placeReturned = false;
	PlaceBean place;

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

		placeReturned = false;
		firebaseRealService.getPlace("Jamalpur", new FirebaseCallback() {

			@Override
			public void onCallback(PlaceBean p) {
				// TODO Auto-generated method stub
				place = p;
				placeReturned = true;

			}
		});

		while (!placeReturned) {

		}

		System.out.println("Printing plce from controller: ");
		System.out.println(place.toString());

		modelAndView.addObject("place", place);

		return modelAndView;

	}
}
