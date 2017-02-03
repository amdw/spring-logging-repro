package uk.org.medworth.springrepro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

public class Repro {
    @Configuration
    @PropertySource(value = "does-not-exist.properties", ignoreResourceNotFound = true)
//    @PropertySource(value = "config.properties", ignoreResourceNotFound = true)
    static class Config {
        @Value("${mykey}")
        String myProp;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Config config = context.getBean(Config.class);
        System.out.println("myProp = " + config.myProp);
    }
}
