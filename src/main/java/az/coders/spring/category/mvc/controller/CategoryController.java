package az.coders.spring.category.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
    @GetMapping("/get")
    public String getCategories(@RequestParam(required = false) String name, Model model) {
        System.out.println("nameee:  " + name);
        model.addAttribute("name", name);
        return "categories";
    }

    @PostMapping("/get")
    public String getCategoriefdgdfs(@RequestParam(required = false) String name, Model model) {
        System.out.println("nameee:  " + name);
        model.addAttribute("name", name);
        return "categories";
    }
}
