package az.coders.spring.category.mvc.repository.impl;

import az.coders.spring.category.mvc.domains.Category;
import az.coders.spring.category.mvc.repository.CategoryDao;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Category category) {
        sessionFactory.getCurrentSession().persist(category);
    }

    @Override
    public void update(Category category) {
        sessionFactory.getCurrentSession().merge(category);
    }

    @Override
    public void delete(Integer id) {
        sessionFactory.getCurrentSession().remove(findById(id));

    }

    @Override
    public Category findById(Integer id) {
        return sessionFactory.getCurrentSession().get(Category.class, id);
    }

    @Override
    public List<Category> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Category").list();
    }

    @Override
    public List<Category> findByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Category c where name = :nm");
        query.setParameter("nm", name);
        return query.list();
    }
}
