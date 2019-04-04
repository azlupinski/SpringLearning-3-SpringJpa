package pl.adamLupinski.springLearning.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JPAConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean createLCEMF(JpaVendorAdapter adapter, DataSource ds){
        LocalContainerEntityManagerFactoryBean lcemf = new LocalContainerEntityManagerFactoryBean();
        Map<String, String> properties = new HashMap<>();
//        Below setting has been moved to DataSource Bean can be uncomment if ds bean must be deleted
//        properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC");
//        properties.put("javax.persistence.jdbc.user", "groot");
//        properties.put("javax.persistence.jdbc.password", "rocket");
//        properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
        properties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
        lcemf.setPersistenceUnitName("springJpaPersistenceUnit");
        lcemf.setJpaPropertyMap(properties);
        lcemf.setDataSource(ds);
        lcemf.setJpaVendorAdapter(adapter);
        lcemf.setPackagesToScan("pl.adamLupinski.springLearning.model");
        return lcemf;
    }

    @Bean
    public JpaVendorAdapter createVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        return adapter;
    }

    @Bean
    public DataSource createDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("groot");
        dataSource.setPassword("rocket");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setInitialSize(5);
        return dataSource;
    }

}
