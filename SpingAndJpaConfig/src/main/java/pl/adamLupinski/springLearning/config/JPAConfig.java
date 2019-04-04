package pl.adamLupinski.springLearning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class JPAConfig {

    @Bean
    public LocalEntityManagerFactoryBean createLEMF(){
        LocalEntityManagerFactoryBean lemfb = new LocalEntityManagerFactoryBean();
        lemfb.setPersistenceUnitName("springJPAPersistenceUnit");
        return lemfb;
    }

}
