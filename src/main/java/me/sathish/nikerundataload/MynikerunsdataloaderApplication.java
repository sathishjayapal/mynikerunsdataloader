package me.sathish.nikerundataload;

//import com.datastax.oss.driver.api.core.CqlSessionBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class MynikerunsdataloaderApplication {
    private static final Logger logger = LoggerFactory.getLogger(MynikerunsdataloaderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MynikerunsdataloaderApplication.class, args);
    }

    //    @Bean
//    public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProps astraProps){
//        Path bundle= astraProps.getSecureConnectBundle().toPath();
//        return cqlSessionBuilder -> cqlSessionBuilder.withCloudSecureConnectBundle(bundle);
//    }
    @Bean
    public FilterRegistrationBean simpleCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:3000"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
