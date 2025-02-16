package az.coders.spring.category.mvc.controller;

import az.coders.spring.category.mvc.domains.Category;
import az.coders.spring.category.mvc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //@GetMapping("/get")
    @RequestMapping(value = "test/{id}", method = RequestMethod.GET)
    public String getCategories(@RequestParam(required = false) String name, @RequestParam String surname, @PathVariable Integer id, Model model) {
        System.out.println("nameee:  " + name);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        return "categories";
    }

    @GetMapping
    public String getCategories(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/name")
    public String getCategoriesByName(@RequestParam String name, Model model) {
        List<Category> categories = categoryService.findByName(name);
        System.out.println("find All");
        model.addAttribute("categories", categories);
        return "categories";
    }

    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/categories";
    }
    @GetMapping("/create")
    public String createCategoryView() {
        return "categoryCreate";
    }

    @GetMapping("/update/{id}")
    public String updateCategoryView(@PathVariable Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "categoryUpdate";
    }

    @PostMapping("/update/{id}")
    public String createCategory(@PathVariable Integer id, @ModelAttribute Category category) {
        System.out.println("category: " + category);
        categoryService.update(category);
        return "redirect:/categories";
    }


    /*
    .../categories get findAll
    .../categories/17 get findById
    .../categories/17 delete delete
    .../categories/17 put update
    .../categories post create


     */
}
