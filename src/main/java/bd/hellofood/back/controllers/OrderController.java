package bd.hellofood.back.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bd.hellofood.back.beans.OrderBean;
import bd.hellofood.back.services.FirebaseService;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private FirebaseService firebaseService;

    @GetMapping
    public ModelAndView index(@RequestParam(name = "area", required = false) String area)
            throws InterruptedException, ExecutionException {

        List<OrderBean> orders = (area != null) ? firebaseService.getOrdersByArea(area) : firebaseService.getOrders();
        String heading = (area != null) ? "All orders from " + area + " area" : "All orders" ;
        ModelAndView modelAndView = new ModelAndView("orders");
        modelAndView.addObject("orders", orders);
        modelAndView.addObject("heading", heading);
        return modelAndView;
    }
}
