package finance.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import finance.api.domain.services.IdGenerator;
import finance.api.domain.services.UuidGenerator;


@Configuration
public class IdGeneratorConfig {
    
    @Bean
    public IdGenerator idGenerator(){
        return new UuidGenerator();
    }
}
