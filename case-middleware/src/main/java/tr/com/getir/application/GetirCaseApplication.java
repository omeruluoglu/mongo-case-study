package tr.com.getir.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by omeruluoglu on 15.12.2019.
 */
@SpringBootApplication (exclude = { DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = {"tr.com.getir"})
@PropertySource("classpath:application.properties")
@EnableMongoRepositories(basePackages = "tr.com.getir.persistency.dao")
public class GetirCaseApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(GetirCaseApplication.class, args);
    }

    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(GetirCaseApplication.class);
    }
}
