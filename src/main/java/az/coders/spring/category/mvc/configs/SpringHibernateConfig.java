package az.coders.spring.category.mvc.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("az.coders.spring.category.mvc")
@PropertySource(value = "classpath:database.yaml", factory = YamlPropertySourceFactory.class)
@EnableTransactionManagement
public class SpringHibernateConfig {
    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource() throws ClassNotFoundException {
        String url = environment.getProperty("datasource.url");
        String username = environment.getProperty("datasource.username");
        String password = environment.getProperty("datasource.password");
        System.out.println("url: " + url);
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        Class.forName("org.postgresql.Driver");
        return new DriverManagerDataSource(url, username, password);
    }

    @Bean
    LocalSessionFactoryBean sessionFactory() throws ClassNotFoundException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("az.coders.spring.category.mvc.domains");
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.show_sql", "none");
        properties.put("hibernate.hbm2ddl.auto", "none");
        sessionFactoryBean.setHibernateProperties(properties);
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() throws ClassNotFoundException {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
        return hibernateTransactionManager;
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
