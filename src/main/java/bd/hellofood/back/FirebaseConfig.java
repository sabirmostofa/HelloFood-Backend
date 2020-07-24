package bd.hellofood.back;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "firebase")
public class FirebaseConfig {

    private String dbUrl;
    private String accountInfo;
}