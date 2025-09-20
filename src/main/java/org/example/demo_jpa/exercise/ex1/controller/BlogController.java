package org.example.demo_jpa.exercise.ex1.controller;

import org.example.demo_jpa.exercise.ex1.model.Blog;
import org.example.demo_jpa.exercise.ex1.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/exercise/ex1/blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "exercise/ex1/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "exercise/ex1/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        blog.setCreatedAt(LocalDateTime.now());
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Saved successfully");
        return "redirect:/exercise/ex1/blogs";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable("id") long id, Model model, RedirectAttributes redirect) {
        return blogService.findById(id).map(b -> {
            model.addAttribute("blog", b);
            return "exercise/ex1/view";
        }).orElseGet(() -> {
            redirect.addFlashAttribute("error", "Blog not found");
            return "redirect:/exercise/ex1/blogs";
        });
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable("id") long id, Model model, RedirectAttributes redirect) {
        return blogService.findById(id).map(b -> {
            model.addAttribute("blog", b);
            return "exercise/ex1/edit";
        }).orElseGet(() -> {
            redirect.addFlashAttribute("error", "Blog not found");
            return "redirect:/exercise/ex1/blogs";
        });
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, @ModelAttribute Blog blog, RedirectAttributes redirect) {
        blogService.findById(id).ifPresent(exist -> {
            exist.setTitle(blog.getTitle());
            exist.setAuthor(blog.getAuthor());
            exist.setContent(blog.getContent());
            exist.setUpdatedAt(LocalDateTime.now());
            blogService.save(exist);
        });
        redirect.addFlashAttribute("message", "Updated successfully");
        return "redirect:/exercise/ex1/blogs";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id, RedirectAttributes redirect) {
        blogService.deleteById(id);
        redirect.addFlashAttribute("message", "Deleted successfully");
        return "redirect:/exercise/ex1/blogs";
    }
}