package az.coders.spring.category.mvc.service.impl;

import az.coders.spring.category.mvc.domains.Category;
import az.coders.spring.category.mvc.repository.CategoryDao;
import az.coders.spring.category.mvc.repository.impl.CategoryDaoImpl;
import az.coders.spring.category.mvc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }

    @Override
    public void delete(Integer id) {
        categoryDao.delete(id);
    }

    @Override
    public Category findById(Integer id) {
        return categoryDao.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public List<Category> findByName(String name) {
        return categoryDao.findByName(name);
    }
}
