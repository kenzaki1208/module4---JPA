package org.example.demo_jpa.practice.p2.controller;

import org.example.demo_jpa.practice.p2.model.CustomerStore;
import org.example.demo_jpa.practice.p2.service.CustomerStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/practice/p2/customers")
public class CustomerStoredController {
    @Autowired
    private CustomerStoreService customerService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("practice/p2/create");
        modelAndView.addObject("customer", new CustomerStore());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("customer") CustomerStore customer) {
        boolean checksave = customerService.saveWithStoredProduce(customer);
        ModelAndView modelAndView = new ModelAndView("practice/p2/create");
        modelAndView.addObject("customer", new CustomerStore());
        if (checksave) {
            modelAndView.addObject("message", "Saved successfully");
        } else {
            modelAndView.addObject("message", "Save failed");
        }
        return modelAndView;
    }
}
