package suger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
public class TestApp {
    public static void main(String[] args){
        SpringApplication.run(TestApp.class, args);

    }
}
