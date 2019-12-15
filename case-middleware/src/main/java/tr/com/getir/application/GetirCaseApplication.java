package tr.com.getir.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by omeruluoglu on 15.12.2019.
 */
@SpringBootApplication (exclude = { DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = {"tr.com.getir"})
@PropertySource("file:/usr/local/tomcat/properties/application.properties")
@EnableMongoRepositories(basePackages = "tr.com.getir.persistency.dao")
public class GetirCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetirCaseApplication.class, args);
    }
}
