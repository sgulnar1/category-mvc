package az.coders.spring.category.mvc.service;

import az.coders.spring.category.mvc.domains.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    void update(Category category);
    void delete(Integer id);
    Category findById(Integer id);
    List<Category> findAll();
    List<Category> findByName(String name);
}
