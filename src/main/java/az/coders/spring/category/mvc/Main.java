package az.coders.spring.category.mvc;

import az.coders.spring.category.mvc.configs.SpringHibernateConfig;
import az.coders.spring.category.mvc.domains.Category;
import az.coders.spring.category.mvc.repository.CategoryDao;
import az.coders.spring.category.mvc.service.CategoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringHibernateConfig.class);
        CategoryDao categoryService = context.getBean(CategoryDao.class);
        categoryService.save(new Category(7889, "uyj", "yuiyu"));
    }
}
