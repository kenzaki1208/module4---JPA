package org.example.demo_jpa.practice.p1.controller;

import org.example.demo_jpa.practice.p1.model.Customer;
import org.example.demo_jpa.practice.p1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/practice/p1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "practice/p1/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "practice/p1/create";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        customerService.save(customer);
        return "redirect:/practice/p1/customers";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "practice/p1/update";
    }

    @PostMapping("update")
    public String update(Customer customer) {
        customerService.save(customer);
        return "redirect:/practice/p1/customers";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "practice/p1/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully");
        return "redirect:/practice/p1/customers";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "practice/p1/view";
    }
}
